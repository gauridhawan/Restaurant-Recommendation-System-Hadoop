package mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonHelper;
import model.UserModelOutput;

public class UserProfileDistinctMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String json = value.toString();
		UserModelOutput user = new UserModelOutput();
		user = CommonHelper.getJsonFromString(json, user);
		context.write(new Text(user.getName().trim().toLowerCase()), new IntWritable(1));
	}
}