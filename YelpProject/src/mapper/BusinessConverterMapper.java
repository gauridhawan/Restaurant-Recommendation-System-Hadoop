package mapper;

import java.io.IOException;
import java.util.StringJoiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonHelper;
import model.BusinessModelOutput;

public class BusinessConverterMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String json = value.toString();
		BusinessModelOutput business = new BusinessModelOutput();
		business = CommonHelper.getJsonFromString(json, business);
		StringJoiner str = new StringJoiner("\t");
		if (business != null) {
			str.add(business.getBusiness_id());
			str.add(business.getName());
			str.add(business.getAddress());
			str.add(business.getCity());
			str.add(business.getState());
			str.add(String.valueOf(business.getStars()));
			str.add(String.valueOf(business.getReview_count()));
			str.add(CommonHelper.getStringFromList(business.getCategories()));
			str.add(CommonHelper.getStringFromMap(business.getHours()));
			context.write(new Text(str.toString()), NullWritable.get());
		}
	}
}
