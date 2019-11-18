import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import JsonToTsv.InspectionJsonToTsvMapper;

public class JsonToTsvDriver {
	
	public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Wrong input format for jsonToTsv driver!");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(JsonToTsvDriver.class);
        job.setJobName("Converting json to tsv.");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(InspectionJsonToTsvMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        job.setNumReduceTasks(0);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
