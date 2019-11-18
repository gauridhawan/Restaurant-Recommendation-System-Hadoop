import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import ReviewUserCountProfiler.ReviewUserCountProfilerCombiner;
import ReviewUserCountProfiler.ReviewUserCountProfilerMapper;
import ReviewUserCountProfiler.ReviewUserCountProfilerReducer;

public class ReviewUserCountProfilerDriver {
	
	public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Wrong input format for wordCount map reduce.");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(ReviewUserCountProfilerDriver.class);
        job.setJobName("Processing inspection input");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(ReviewUserCountProfilerMapper.class);
        job.setCombinerClass(ReviewUserCountProfilerCombiner.class);
        job.setReducerClass(ReviewUserCountProfilerReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(1);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
