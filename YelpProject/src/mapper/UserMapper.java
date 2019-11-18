package mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonHelper;
import model.UserModel;
import model.UserModelOutput;

public class UserMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String json = value.toString();
		UserModel user = new UserModel();
		user = CommonHelper.getJsonFromString(json, user);
		if (user != null) {
			UserModelOutput userOutput = new UserModelOutput(user);
			if (CommonHelper.isNotBlank(userOutput.getUser_id()) && CommonHelper.isNotBlank(userOutput.getName())) {
				String outputJson = CommonHelper.getStringFromJson(userOutput);
				context.write(new Text(outputJson), NullWritable.get());
			}
		}
	}
}
