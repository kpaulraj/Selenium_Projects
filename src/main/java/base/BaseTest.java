package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {	
	
 public static WebDriver driver;
 
 //@Parameters("Browser")
 @BeforeClass
 public void initDriver() {
	String browser = "Chrome"; 
	if (browser.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	 } 
	else if (browser.equals("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
	System.out.println("BaseTest888\n" + "Annotated Method:BeforeClass");
	System.out.println("Browser" + browser + " Instantiated");
		}

 @AfterClass
 public void cleanUp() {
	//driver.quit();
	System.out.println("Class:BaseTest\n" + "Annotated Method:AfterClass");
}

}
