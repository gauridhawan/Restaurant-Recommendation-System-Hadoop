package mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonHelper;
import model.BusinessModelOutput;

public class BusinessProfileStarsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String json = value.toString();
		BusinessModelOutput business = new BusinessModelOutput();
		business = CommonHelper.getJsonFromString(json, business);
		context.write(new Text(String.valueOf(business.getStars())), new IntWritable(1));
	}
}
