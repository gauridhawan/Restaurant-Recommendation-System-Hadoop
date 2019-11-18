package hadoop;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobExecutor {

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static void executeJob(String inputPath, String outputPath, Class<?> jarClass, Class<?> mapper,
			Class<?> reducer, Class<?> combiner, Class<?> outputKey, Class<?> outputValue)
			throws IOException, InterruptedException, ClassNotFoundException {
		System.out.println("Input Path: " + inputPath);
		System.out.println("Output Path: " + outputPath);
		Job job = new Job();
		job.setJarByClass(jarClass);
		job.setJobName(jarClass.toString());
		FileInputFormat.addInputPath(job, new Path(inputPath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath));
		job.setMapperClass((Class<? extends Mapper>) mapper);
		if (combiner != null) {
			job.setCombinerClass((Class<? extends Reducer>) combiner);
		}
		job.setReducerClass((Class<? extends Reducer>) reducer);
		job.setOutputKeyClass(outputKey);
		job.setOutputValueClass(outputValue);
		job.setNumReduceTasks(1);
		job.waitForCompletion(true);
	}
}