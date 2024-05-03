package guvi.task21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class t21one {

 public static void main(String[] args) {

	 System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
  
  WebDriver driver=new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  driver.manage().window().maximize();

  //Navigate to the URL
     driver.get("https://the-internet.herokuapp.com/iframe");

     //Switch to IFRAME
     driver.switchTo().frame("mce_0_ifr");

     //Locate the area and write the content "Hello People!"
     WebElement Area = driver.findElement(By.xpath("//p"));
     Area.clear();
     Area.sendKeys("Hello People!");

     //Switch to main frame
     driver.switchTo().defaultContent();

        //Close the browser
     driver.close();

   }
  
 }

