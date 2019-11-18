package JsonToTsv;

import java.io.IOException;
import java.util.StringJoiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import Models.InspectionModel;

public class InspectionJsonToTsvMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		ObjectMapper mapper = new ObjectMapper();
		InspectionModel inspection = mapper.readValue(value.toString(), InspectionModel.class);
		StringJoiner tabSeparatedInspectionModel = new StringJoiner("\t");
		tabSeparatedInspectionModel.add(inspection.getSerial_number());
		tabSeparatedInspectionModel.add(inspection.getRestaurant_name());
		tabSeparatedInspectionModel.add(inspection.getLocation_name());
		tabSeparatedInspectionModel.add(inspection.getAddress());
		tabSeparatedInspectionModel.add(inspection.getCity());
		tabSeparatedInspectionModel.add(inspection.getState());
		tabSeparatedInspectionModel.add(inspection.getInspection_grade());
		
		context.write(new Text(tabSeparatedInspectionModel.toString()), NullWritable.get());
	}
	
	

}
