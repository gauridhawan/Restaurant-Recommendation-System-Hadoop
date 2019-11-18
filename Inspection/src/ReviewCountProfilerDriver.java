import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import reviewCountProfiler.ReviewCountProfilerMapper;
import reviewCountProfiler.ReviewCountProfilerReducer;


public class ReviewCountProfilerDriver {
	
	public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Wrong input format for wordCount map reduce.");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(ReviewCountProfilerDriver.class);
        job.setJobName("Processing inspection input");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(ReviewCountProfilerMapper.class);
        job.setReducerClass(ReviewCountProfilerReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(1);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
