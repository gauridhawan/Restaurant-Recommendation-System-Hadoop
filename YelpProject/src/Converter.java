import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import hadoop.JobExecutor;
import helper.CommonHelper;
import mapper.BusinessConverterMapper;
import reducer.JsonReducer;

public class Converter {

	public static void main(String[] args) {
		CommonHelper.checkInput(args);
		String inputPath = args[0];
		String outputPath = args[1];
		try {
			System.out.println("Starting conversion of Business Dataset");
			JobExecutor.executeJob(inputPath, outputPath, Converter.class, BusinessConverterMapper.class,
					JsonReducer.class, null, Text.class, NullWritable.class);
		} catch (Exception exception) {
			System.err.println("Error occurred while processing Business: " + exception);
		}
	}
}
