import executor.Executor;
import executor.impl.BusinessExecutor;
import executor.impl.UserExecutor;
import helper.CommonHelper;

public class Application {

	public static void main(String[] args) {
		CommonHelper.checkInput(args);
		String inputPath = args[0];
		String outputPath = args[1];
//		Executor userExecutor = new UserExecutor();
//		try {
//			userExecutor.execute(userExecutor.getInputPath(inputPath), userExecutor.getOutputPath(outputPath));
//		} catch (Exception exception) {
//			System.err.println("Error occurred while processing User: " + exception);
//		}

		Executor businessExecutor = new BusinessExecutor();
		try {
			businessExecutor.execute(businessExecutor.getInputPath(inputPath),
					businessExecutor.getOutputPath(outputPath));
		} catch (Exception exception) {
			System.err.println("Error occurred while processing Business: " + exception);
		}
	}

}
