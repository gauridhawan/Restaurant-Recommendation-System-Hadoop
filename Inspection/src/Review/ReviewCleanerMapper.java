package Review;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import Models.ProcessedReviewModel;
import Models.ReviewModel;

public class ReviewCleanerMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		ObjectMapper mapper = new ObjectMapper();
		ReviewModel review = mapper.readValue(value.toString(), ReviewModel.class);

		ProcessedReviewModel processedReview = new ProcessedReviewModel(review.getReview_id(), review.getUser_id(),
				review.getBusiness_id(), review.getStars());

		if (processedReview.getReview_id() != null && processedReview.getStars() != null
				&& processedReview.getBusiness_id() != null && processedReview.getUser_id() != null) {
			context.write(new Text(mapper.writeValueAsString(processedReview)), NullWritable.get());
		}

	}
}
