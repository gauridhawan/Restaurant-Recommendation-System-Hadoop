package reviewCountProfiler;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import CommonUtils.Constants;

public class ReviewCountProfilerReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int totalCount = 0;

		
		for (IntWritable value : values) {
			totalCount = totalCount + value.get();
		}
		
		System.out.println("Key ="+key.toString() +" count="+totalCount);

		context.write(new Text(Constants.reviewCount), new IntWritable(totalCount));

	}

}
