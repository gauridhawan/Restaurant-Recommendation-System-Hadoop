package profiler;

import java.io.IOException;

import helper.CommonConstants;

public abstract class Profiler {

	public abstract void profile(String inputPath, String outputPath)
			throws IOException, ClassNotFoundException, InterruptedException;

	public String getInputPath(String path) {
		return path.concat(CommonConstants.PROFILE_INPUT_PATH);
	}

	public String getOutputPath(String path) {
		return path.concat(CommonConstants.PROFILE_OUTPUT_PATH);

	}
}