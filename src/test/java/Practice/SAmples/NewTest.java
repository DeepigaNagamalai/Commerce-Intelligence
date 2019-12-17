package Practice.SAmples;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners(TestListener.class)
public class NewTest extends BaseClass{
 
	public WebDriver driver;
	
  @BeforeClass
  public void setup() {
	  
	  BaseClass bs = new BaseClass();
	  driver = bs.initialize_driver(); ;
	  driver.get("http://www.google.com");
	  
  }
  
  @Test(description="Test method")
  @Story("Story name:Test")
  @Description("Test case description: Test")
  @Severity(SeverityLevel.NORMAL)
  @Epic("EP001")
  @Feature("feature1")
  @Step("verify logo [presence")
  public void f() {
	  
	  Logger logger = Logger.getLogger(NewTest.class);
	  PropertyConfigurator.configure("C:\\Users\\deenagam\\eclipse-workspace\\SAmples\\src\\main\\java\\log4j.properties");
	  System.out.println("Test title of site");
	  Assert.assertEquals(driver.getTitle(),"Google");
	  logger.info("Asserting webpage title");
  }
}
