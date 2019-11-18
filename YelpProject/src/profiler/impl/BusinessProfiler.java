package profiler.impl;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import combiner.BusinessProfileDistinctCategoriesCombiner;
import hadoop.JobExecutor;
import helper.CommonConstants;
import helper.CommonHelper;
import mapper.BusinessProfileCategoriesMapper;
import mapper.BusinessProfileMapper;
import mapper.BusinessProfileStarsMapper;
import profiler.Profiler;
import reducer.ProfilerCountReducer;
import reducer.ProfilerRangeReducer;

public class BusinessProfiler extends Profiler {

	@Override
	public void profile(String inputPath, String outputPath)
			throws IOException, ClassNotFoundException, InterruptedException {
		CommonHelper.checkInput(inputPath);
		CommonHelper.checkInput(outputPath);

		System.out.println("Total Number of Restaurants in Las Vegas area");
		String reviewCountOutput = outputPath.concat(CommonConstants.TOTAL_RESTAURANTS_PATH);
		JobExecutor.executeJob(inputPath, reviewCountOutput, BusinessProfiler.class, BusinessProfileMapper.class,
				ProfilerRangeReducer.class, null, Text.class, IntWritable.class);

		System.out.println("Number of Restaurants grouped by stars");
		String starsOutput = outputPath.concat(CommonConstants.STARS_PATH);
		JobExecutor.executeJob(inputPath, starsOutput, BusinessProfiler.class, BusinessProfileStarsMapper.class,
				ProfilerCountReducer.class, null, Text.class, IntWritable.class);

		System.out.println("Distinct Categories");
		String distinctCategoriesOutput = outputPath.concat(CommonConstants.DISTINCT_CATEGORIES_PATH);
		JobExecutor.executeJob(inputPath, distinctCategoriesOutput, BusinessProfiler.class,
				BusinessProfileCategoriesMapper.class, ProfilerCountReducer.class,
				BusinessProfileDistinctCategoriesCombiner.class, Text.class, IntWritable.class);

		System.out.println("Number of Restaurants grouped by Categories");
		String categoriesOutput = outputPath.concat(CommonConstants.CATEGORIES_PATH);
		JobExecutor.executeJob(inputPath, categoriesOutput, BusinessProfiler.class,
				BusinessProfileCategoriesMapper.class, ProfilerCountReducer.class, null, Text.class, IntWritable.class);
	}
}