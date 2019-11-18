package profiler.impl;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import combiner.UserProfileDistinctCombiner;
import hadoop.JobExecutor;
import helper.CommonConstants;
import helper.CommonHelper;
import mapper.UserProfileDistinctMapper;
import mapper.UserProfileMapper;
import profiler.Profiler;
import reducer.ProfilerCountReducer;
import reducer.ProfilerRangeReducer;

public class UserProfiler extends Profiler {

	@Override
	public void profile(String inputPath, String outputPath)
			throws IOException, ClassNotFoundException, InterruptedException {
		CommonHelper.checkInput(inputPath);
		CommonHelper.checkInput(outputPath);

		System.out.println("Get Total Number of Names");
		String totalNamesOutput = outputPath.concat(CommonConstants.TOTAL_NAMES_PATH);
		JobExecutor.executeJob(inputPath, totalNamesOutput, UserProfiler.class, UserProfileMapper.class,
				ProfilerRangeReducer.class, null, Text.class, IntWritable.class);

		System.out.println("Get Distinct Number of Names");
		String distinctNamesOutput = outputPath.concat(CommonConstants.DISTINCT_NAMES_PATH);
		JobExecutor.executeJob(inputPath, distinctNamesOutput, UserProfiler.class, UserProfileDistinctMapper.class,
				ProfilerCountReducer.class, UserProfileDistinctCombiner.class, Text.class, IntWritable.class);
	}
}