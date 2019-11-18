package mapper;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import helper.CommonConstants;
import helper.CommonHelper;
import model.BusinessModel;
import model.BusinessModelOutput;

public class BusinessMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String json = value.toString();
		BusinessModel business = new BusinessModel();
		business = CommonHelper.getJsonFromString(json, business);
		if (isValidRestaurant(business)) {
			BusinessModelOutput businessOutput = new BusinessModelOutput(business);
			businessOutput.setCategories(CommonHelper.getListFromString(business.getCategories(),
					CommonConstants.CATEGORIES_TO_REMOVE, CommonConstants.CATEGORIES_TO_REPLACE));
			businessOutput.setName(
					CommonHelper.removeSubstrings(businessOutput.getName(), CommonConstants.RESTAURANT_NAME_EXTRA));
			businessOutput.setAddress(CommonHelper.removeRegex(businessOutput.getAddress().trim(), "[!@#$%^&*(),.?\\\":{}|<>-]", CommonConstants.LOCATION_NAME_EXTRA));
			businessOutput
					.setCity(CommonHelper.removeSubstrings(businessOutput.getCity(), CommonConstants.CITY_PREFIX));
			String outputJson = CommonHelper.getStringFromJson(businessOutput);
			context.write(new Text(outputJson), NullWritable.get());
		}
	}

	private boolean isValidRestaurant(BusinessModel business) {
		if (business == null) {
			return false;
		}
		if (!isValidCategory(business.getCategories())) {
			return false;
		}

		if (!isValidState(business.getState())) {
			return false;
		}
		if (!isValidCity(business.getCity())) {
			return false;
		}
		
		if(business.getIs_open() != 1) return false;
		
		return true;
	}

	private boolean isValidCategory(String businessCategories) {
		if (CommonHelper.isBlank(businessCategories)) {
			return false;
		}
		List<String> categories = CommonHelper.getListFromString(businessCategories);
		for (String category : categories) {
			if (CommonConstants.CATEGORIES_TO_MATCH.contains(category.trim().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidCity(String city) {
		if (CommonHelper.isBlank(city)) {
			return false;
		}
		city = CommonHelper.removeSubstrings(city, CommonConstants.CITY_PREFIX);

		if (CommonHelper.isBlank(city)) {
			return false;
		}
		if (CommonConstants.CITIES_TO_MATCH.contains(city.trim().toLowerCase())) {
			return true;
		}
		return false;
	}

	private boolean isValidState(String state) {
		if (CommonHelper.isBlank(state)) {
			return false;
		}
		if (CommonConstants.STATES_TO_MATCH.contains(state.trim().toLowerCase())) {
			return true;
		}
		return false;
	}
}