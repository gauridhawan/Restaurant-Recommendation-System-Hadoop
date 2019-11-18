package reviewFieldProfiler;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import Models.ProcessedReviewModel;

public class ReviewFieldProfilerMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		ObjectMapper mapper = new ObjectMapper();
		ProcessedReviewModel review = mapper.readValue(value.toString(), ProcessedReviewModel.class);
		if(review.getBusiness_id()!=null) {
			context.write(new Text("business_id"), new IntWritable(review.getBusiness_id().length()));
		}
		if(review.getReview_id()!=null) {
			context.write(new Text("review_id"), new IntWritable(review.getReview_id().length()));
		}
		if(review.getUser_id()!=null) {
			context.write(new Text("user_id"), new IntWritable(review.getReview_id().length()));
		}
		if(review.getStars()!=null) {
			context.write(new Text("stars"), new IntWritable(review.getStars()));
		}
		

	}
	
	

}
