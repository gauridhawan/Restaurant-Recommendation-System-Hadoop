package executor.impl;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import executor.Executor;
import hadoop.JobExecutor;
import helper.CommonConstants;
import mapper.BusinessMapper;
import profiler.Profiler;
import profiler.impl.BusinessProfiler;
import reducer.JsonReducer;

public class BusinessExecutor implements Executor {

	@Override
	public void execute(String inputPath, String outputPath)
			throws IOException, ClassNotFoundException, InterruptedException {
		System.out.println("Starting cleaning of Business Dataset");
		JobExecutor.executeJob(inputPath, outputPath, BusinessExecutor.class, BusinessMapper.class,
				JsonReducer.class, null, Text.class, NullWritable.class);
		startProfiler(outputPath);
	}

	private void startProfiler(String path) throws IOException, ClassNotFoundException, InterruptedException {
		System.out.println("Starting profiling of Business Dataset");
		Profiler profiler = new BusinessProfiler();
		profiler.profile(profiler.getInputPath(path), profiler.getOutputPath(path));
	}

	@Override
	public String getInputPath(String inputPath) {
		return inputPath.concat(CommonConstants.BUSINESS_JSON_PATH);
	}

	@Override
	public String getOutputPath(String outputPath) {
		return outputPath.concat(CommonConstants.BUSINESS_OUTPUT_PATH);
	}
}