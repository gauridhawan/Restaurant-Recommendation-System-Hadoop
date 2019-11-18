package InspectionMR;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import CommonUtils.Constants;
import Models.InspectionModel;

public class InspectionCleanerMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String row = value.toString();
		String[] columns = row.split("\\t");
		
		for(String col : columns) {
			System.out.print(col);
		}
		String inspectionGrade = columns[17];

		if (isValidCategory(columns[4]) && isValidCity(columns[6]) && 
				inspectionGrade!= null && !inspectionGrade.isEmpty()) {

			// Change North Las Vegas to Las Vegas
			columns[6] = Constants.lasVegas;

			// Restaurant Name Processing
			String restaurantName = columns[2].toLowerCase();
			for (String stopWord : Constants.restaurantNameStopWords) {
				restaurantName = restaurantName.replace(stopWord, "");
				restaurantName = restaurantName.replaceAll("#([0-9])*", "");
				restaurantName = restaurantName.replaceAll("[!@#$%^&*(),.?\":{}|<>-]", "");
				restaurantName = restaurantName.trim();
			}
			
			if(!restaurantName.isEmpty()) {
				
				String serialNumber = columns[0];
				String locationName = columns[3];
				String address = columns[5];
				address = cleanAddress(address);
				String city = columns[6];
				String state = columns[7];
				//Date inspectionDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(columns[13]);
				String date = columns[13];
				inspectionGrade = inspectionGrade.toUpperCase();
				

				StringJoiner outputKey = new StringJoiner("\t");
				outputKey.add(restaurantName);
				outputKey.add(address);
				
				StringJoiner outputValue = new StringJoiner("\t");
				outputValue.add(serialNumber);
				outputValue.add(date);
				outputValue.add(city);
				outputValue.add(state);
				outputValue.add(inspectionGrade);
				outputValue.add(locationName);
				//			InspectionModel processedInspectionModel = new InspectionModel(serialNumber, restaurantName, locationName,
//						address, city, state, inspectionGrade);
//				ObjectMapper mapper = new ObjectMapper();
//				context.write(new Text(mapper.writeValueAsString(processedInspectionModel)), new Text(""));
				
				context.write(new Text(outputKey.toString()), new Text(outputValue.toString()));
			}
			}
			

	}
	
	public boolean isValidCity(String cityName) {
		if(cityName.contains(Constants.lasVegas)) {
			return true;
		}
		return false;
	}
	
	public boolean isValidCategory(String categoryName) {
		if(categoryName.equals(Constants.restaurant)) {
			return true;
		}
		return false;
	}

	public static String cleanAddress(String text) {
		if (!text.isEmpty()) {
			text = text.toLowerCase();
			boolean isChar = false;
			int k = text.length();
			for (int i = 0; i < text.length(); i++) {
				if (Character.isLetter(text.charAt(i))) {
					isChar = true;
				} else if (isChar && Character.isDigit(text.charAt(i))) {
					k = i;
					break;
				}
			}
			text = text.toLowerCase();
			text = text.substring(0, k);
			text = text.replaceAll("#([0-9])*", "");
			text = text.replaceAll("[!@#$%^&*(),.?\":{}|<>-]", "");
			for (String t : Constants.addressStopWords) {
				if (text.contains(t)) {
					int i = text.indexOf(t);
					text = text.substring(0, i);
				}
			}
			text = text.trim();
		}
		return text;
	}
}