package executor.impl;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import executor.Executor;
import hadoop.JobExecutor;
import helper.CommonConstants;
import mapper.UserMapper;
import profiler.Profiler;
import profiler.impl.UserProfiler;
import reducer.JsonReducer;

public class UserExecutor implements Executor {

	@Override
	public void execute(String inputPath, String outputPath)
			throws IOException, ClassNotFoundException, InterruptedException {
		System.out.println("Starting cleaning of User Dataset");
		JobExecutor.executeJob(inputPath, outputPath, UserExecutor.class, UserMapper.class, JsonReducer.class, null,
				Text.class, NullWritable.class);
		startProfiler(outputPath);
	}

	private void startProfiler(String path) throws IOException, ClassNotFoundException, InterruptedException {
		System.out.println("Starting profiling of User Dataset");
		Profiler profiler = new UserProfiler();
		profiler.profile(profiler.getInputPath(path), profiler.getOutputPath(path));
	}

	@Override
	public String getInputPath(String inputPath) {
		return inputPath.concat(CommonConstants.USER_JSON_PATH);
	}

	@Override
	public String getOutputPath(String outputPath) {
		return outputPath.concat(CommonConstants.USER_OUTPUT_PATH);
	}
}