package reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import helper.CommonConstants;
import helper.CommonHelper;

public class ProfilerRangeReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		String k = key.toString();
		if (CommonHelper.isNotBlank(k)) {
			if (k.equals(CommonConstants.TOTAL_NAMES) || k.equals(CommonConstants.TOTAL_RESTAURANTS)) {
				int count = CommonHelper.getTotalCount(values);
				context.write(key, new IntWritable(count));
			} else {
				int max = 0;
				int min = Integer.MAX_VALUE;
				for (IntWritable value : values) {
					max = value.get() > max ? value.get() : max;
					min = value.get() < min ? value.get() : min;
				}
				context.write(new Text(CommonConstants.MAX.concat(k)), new IntWritable(max));
				context.write(new Text(CommonConstants.MIN.concat(k)), new IntWritable(min));
			}
		}
	}
}