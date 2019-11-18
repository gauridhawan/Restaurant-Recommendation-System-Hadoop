package executor;

import java.io.IOException;

public interface Executor {

	void execute(String inputPath, String outputPath) throws IOException, ClassNotFoundException, InterruptedException;
	
	String getInputPath(String inputPath);
	
	String getOutputPath(String outputPath);
}