package listenerlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import genericlibrary.BaseConfig;

public class ListnerImplementation implements ITestListener
{
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String currentdate = sdf.format(new Date());
	
	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseConfig.staticdriver;
		File temporary_path = ts.getScreenshotAs(OutputType.FILE);
		File permanent_path = new File("./Screenshot/Test_Failure_"+ currentdate + ".png");
		try {
			FileHandler.copy(temporary_path, permanent_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestStart(ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseConfig.staticdriver;
		File temporary_path = ts.getScreenshotAs(OutputType.FILE);
		File permanent_path = new File("./Screenshot/Test_Start_"+ currentdate + ".png");
		try {
			FileHandler.copy(temporary_path, permanent_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSuccess(ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseConfig.staticdriver;
		File temporary_path = ts.getScreenshotAs(OutputType.FILE);
		File permanent_path = new File("./Screenshot/Test_Success_"+ currentdate + ".png");
		try {
			FileHandler.copy(temporary_path, permanent_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
