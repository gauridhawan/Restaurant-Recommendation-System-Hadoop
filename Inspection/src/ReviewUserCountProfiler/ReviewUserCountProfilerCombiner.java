package ReviewUserCountProfiler;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import CommonUtils.Constants;

public class ReviewUserCountProfilerCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

//		if (key.toString().equalsIgnoreCase(Constants.review)) {
//			System.out.println("Review");
//			
//			int count = 0;
//			for(IntWritable value : values ) {
//				count = count + value.get();
//			}
//			context.write(new Text(Constants.reviewCount), new IntWritable(count));
//		} else {
			System.out.println("User");
			context.write(new Text(Constants.distinctUserCount), new IntWritable(1));
		//}

	}

}
