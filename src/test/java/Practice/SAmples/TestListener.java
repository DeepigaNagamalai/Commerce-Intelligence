package Practice.SAmples;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {

private static String getTestMethodName(ITestResult iTestResult) {
	return iTestResult.getMethod().getConstructorOrMethod().getName();
	
}

@Attachment
public byte[] saveFailureScreenshot(WebDriver driver) {
	return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	
}

@Attachment(value= "{0}", type = "text/plain")
public static String saveTextLog(String message) {
	return message;
}

@Override
public void onStart(ITestContext iTestContext) {
	System.out.println("I am in Onstart"+iTestContext.getName());
	iTestContext.setAttribute("WebDriver",BaseClass.getDriver());
}

@Override
public void onFinish(ITestContext iTestContext) {
	System.out.println("I am in OnFinish"+iTestContext.getName());
	
}

@Override
public void onTestStart(ITestResult iTestResult) {
	System.out.println("I am in OnTeststart"+getTestMethodName(iTestResult)+"Test Started");
	
}

@Override
public void onTestSuccess(ITestResult iTestResult) {
	System.out.println("I am in OnTestSuccess"+getTestMethodName(iTestResult)+"passed");
	Object NewTest = iTestResult.getInstance();
	WebDriver driver = BaseClass.getDriver();
	if(driver instanceof WebDriver) {
		System.out.println("Screenshot captured for testcase:"+getTestMethodName(iTestResult));
		saveFailureScreenshot(driver);
	}
	saveTextLog(getTestMethodName(iTestResult)+"passed and screenshot taken!");
	}
	

@Override
public void onTestFailure(ITestResult iTestResult) {
	System.out.println("I am in OnTestFailure"+getTestMethodName(iTestResult)+"failed");
	Object NewTest = iTestResult.getInstance();
	WebDriver driver = BaseClass.getDriver();
	if(driver instanceof WebDriver) {
		System.out.println("Screenshot captured for testcase:"+getTestMethodName(iTestResult));
		saveFailureScreenshot(driver);
	}
	saveTextLog(getTestMethodName(iTestResult)+"failed and screenshot taken!");
	}
}


