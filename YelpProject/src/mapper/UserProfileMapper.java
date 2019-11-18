package mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonConstants;
import helper.CommonHelper;
import model.UserModelOutput;

public class UserProfileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String json = value.toString();
		UserModelOutput user = new UserModelOutput();
		user = CommonHelper.getJsonFromString(json, user);
		if (user != null) {
			context.write(new Text(CommonConstants.TOTAL_NAMES), new IntWritable(1));
			if (CommonHelper.isNotBlank(user.getName())) {
				context.write(new Text(CommonConstants.USER_NAME_SIZE), new IntWritable(user.getName().length()));
			}
		}
	}
	
	
}