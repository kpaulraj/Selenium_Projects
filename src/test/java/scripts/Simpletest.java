package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Simpletest {
	public static final String path = "C:/Kalpana/Installable/Drivers/chromedriver.exe";
	public static WebDriver driver; 
	@BeforeTest
	public void doThisBefore(){
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--remote-allow-origins=*");
	    System.setProperty("webdriver.chrome.driver", path);
	    //System.setProperty("webdriver.http.factory", "jdk-http-client");
	    driver = new ChromeDriver(option);
	    driver.get("https://selenium.dev/");
	}
	
    @Test(priority=1)
    public void getTitle(){
    String title = driver.getTitle();
    System.out.println(driver.getTitle());
    Assert.assertEquals(title,"Selenium");
}
    @Test(priority=2)
    public void checkMenuitem1() {
    	String mItem1=driver.findElement(By.xpath("//*[@id='navbarDropdown']")).getText();
    	Assert.assertEquals(mItem1,"About");
    }
    @Test(priority=3)
    public void checkbodyMsg() {
    	String bMsg=driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/h1")).getText();
    	System.out.println(bMsg+"!");
    	Assert.assertEquals(bMsg,"Selenium automates browsers. That's it!");
    }
    
    @AfterTest
    public void cleanMethod() {
    	System.out.println("Browser Closed");
    	driver.quit();
    }
   
    
}

