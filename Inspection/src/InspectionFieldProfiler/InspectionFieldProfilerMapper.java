package InspectionFieldProfiler;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import Models.InspectionModel;

public class InspectionFieldProfilerMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		ObjectMapper mapper = new ObjectMapper();
		InspectionModel inspection = mapper.readValue(value.toString(), InspectionModel.class);
		if(inspection.getCity()!=null) {
			context.write(new Text("city"), new IntWritable(inspection.getCity().length()));
		}
		if(inspection.getAddress()!=null) {
			context.write(new Text("address"), new IntWritable(inspection.getAddress().length()));
		}
		if(inspection.getRestaurant_name()!=null) {
			context.write(new Text("restaurant_name"), new IntWritable(inspection.getRestaurant_name().length()));
		}
		if(inspection.getLocation_name()!=null) {
			context.write(new Text("location_name"), new IntWritable(inspection.getLocation_name().length()));
		}
		if(inspection.getState()!=null) {
			context.write(new Text("state"), new IntWritable(inspection.getState().length()));
		}
		if(inspection.getSerial_number()!=null) {
			context.write(new Text("serial_number"), new IntWritable(inspection.getSerial_number().length()));
		}
		
		
		
	}
	
	

}
