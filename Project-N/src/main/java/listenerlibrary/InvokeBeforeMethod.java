package listenerlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import genericlibrary.BaseConfig;

public class InvokeBeforeMethod implements IInvokedMethodListener 
{
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String currentdate = sdf.format(new Date()); 
	
	public void beforeInvocation(IInvokedMethod method, ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseConfig.staticdriver;
		File temporary_path = ts.getScreenshotAs(OutputType.FILE);
		File permanent_path = new File("./Screenshot/BeforeInvocation_"+ currentdate + ".png");
		try {
			FileHandler.copy(temporary_path, permanent_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void afterInvocation(IInvokedMethod method, ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseConfig.staticdriver;
		File temporary_path = ts.getScreenshotAs(OutputType.FILE);
		File permanent_path = new File("./Screenshot/AfterInvocation_"+ currentdate + ".png");
		try {
			FileHandler.copy(temporary_path, permanent_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
