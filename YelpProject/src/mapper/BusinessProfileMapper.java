package mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonConstants;
import helper.CommonHelper;
import model.BusinessModelOutput;

public class BusinessProfileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		context.write(new Text(CommonConstants.TOTAL_RESTAURANTS), new IntWritable(1));
		String json = value.toString();
		BusinessModelOutput business = new BusinessModelOutput();
		business = CommonHelper.getJsonFromString(json, business);
		if (business != null) {
			if (CommonHelper.isNotBlank(business.getName())) {
				context.write(new Text(CommonConstants.RESTAURANT_NAME_SIZE),
						new IntWritable(business.getName().length()));
			}
			if (CommonHelper.isNotBlank(business.getCity())) {
				context.write(new Text(CommonConstants.CITY_SIZE), new IntWritable(business.getCity().trim().length()));
			}
			if (CommonHelper.isNotBlank(business.getState())) {
				context.write(new Text(CommonConstants.STATE_SIZE),
						new IntWritable(business.getState().trim().length()));
			}
			if (business.getCategories() != null && !business.getCategories().isEmpty()) {
				context.write(new Text(CommonConstants.CATEGORIES_SIZE),
						new IntWritable(business.getCategories().size()));
				for (String category : business.getCategories()) {
					context.write(new Text(CommonConstants.CATEGORY_SIZE), new IntWritable(category.length()));
				}
			}
		}
	}
}