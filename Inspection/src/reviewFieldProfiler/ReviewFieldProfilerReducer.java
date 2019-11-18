package reviewFieldProfiler;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReviewFieldProfilerReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (IntWritable value : values) {
			min = Math.min(value.get(), min);
			max = Math.max(value.get(), max);
		}

		String minVal = "Min "+key.toString();
		String maxVal = "Max "+key.toString();
		context.write(new Text(minVal), new IntWritable(min));
		context.write(new Text(maxVal), new IntWritable(max));

	
	}

}
