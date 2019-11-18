package combiner;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import helper.CommonConstants;
import helper.CommonHelper;

public class BusinessProfileDistinctCategoriesCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		String k = key.toString();
		if (CommonHelper.isNotBlank(k)) {
			context.write(new Text(CommonConstants.DISTINCT_CATEGORIES), new IntWritable(1));
		}
	}
}