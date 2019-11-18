package InspectionProfiler;


import Models.InspectionModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class InspectionProfilerMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String row = value.toString();
        ObjectMapper mapper = new ObjectMapper();
        InspectionModel inspectionModel = mapper.readValue(value.toString(),InspectionModel.class);


        context.write(new Text(inspectionModel.getInspection_grade()), new IntWritable(1));
        context.write(new Text("total"), new IntWritable(1));


    }
}
