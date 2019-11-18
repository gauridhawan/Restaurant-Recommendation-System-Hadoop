package ReviewUserCountProfiler;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import CommonUtils.Constants;
import Models.ProcessedReviewModel;

public class ReviewUserCountProfilerMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		ProcessedReviewModel review = mapper.readValue(value.toString(), ProcessedReviewModel.class);
		System.out.println("UserId ="+review.getUser_id());
		context.write(new Text(review.getUser_id()), new IntWritable(1));
		
		//context.write(new Text(Constants.review),new IntWritable(1));
		
		
		
	}

}
