package InspectionMR;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import com.fasterxml.jackson.databind.ObjectMapper;

import Models.InspectionModel;

public class InspectionCleanerReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		
		String[] input = key.toString().split("\t");
		String restaurantName = input[0];
		String address = input[1];
		Date maxDate = new Date(0);
		String[] maxDateRecord = new String[6];
		
		for(Text value : values) {
			String[] inputValues= value.toString().split("\t");
			try {
				Date inspectionDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(inputValues[1]);
				if(inspectionDate.after(maxDate)) {
					maxDate = inspectionDate;
					maxDateRecord = inputValues;
				}
			} catch (ParseException e) {
				System.out.println("Error in coverting date");
			} 
		}
		
		String serialNumber = maxDateRecord[0];
		String city = maxDateRecord[2];
		String state = maxDateRecord[3];
		String inspectionGrade = maxDateRecord[4];
		String locationName = maxDateRecord[5];
		
		InspectionModel processedInpsectionModel = new InspectionModel(serialNumber,restaurantName,locationName,address,city,state, inspectionGrade);
		ObjectMapper mapper = new ObjectMapper();
		context.write(new Text(mapper.writeValueAsString(processedInpsectionModel)), new Text(""));
		
		
	}
	
	

}
