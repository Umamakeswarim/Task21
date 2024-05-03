package guvi.task21;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class t21thrird {

 public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
      WebDriver d=new ChromeDriver();
   d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      d.manage().window().maximize();
      //navigate to  URL
      d.get("https://the-internet.herokuapp.com/nested_frames");

      //Switch to Top frame
    WebElement topFrameElement = d.findElement(By.xpath("//frame[@name='frame-top']"));
    d.switchTo().frame(topFrameElement);

    //Verify that there are three frames on the page
    List<WebElement> frameCount=d.findElements(By.tagName("frame"));
    if (frameCount.size()==3)
     System.out.println("Three frames are available on the page");
    else
     System.out.println("Available frames are "+ frameCount);

    //Switch to left frame
    WebElement leftFrameElement = d.findElement(By.name("frame-left"));
    d.switchTo().frame(leftFrameElement);
    System.out.println("Switched to left Frame");

    //Verify that left frame has the text "LEFT"
    WebElement leftBodyFrameElement = d.findElement(By.xpath("//body[contains(.,'LEFT')]"));
    if (leftBodyFrameElement.getText().equals("LEFT"))
     System.out.println("Left frame has the text LEFT");
    else
     System.out.println("Left frame does not have the text LEFT");

    //Switch to top frame
    d.switchTo().defaultContent();
    d.switchTo().frame(topFrameElement);
    System.out.println("Switched from left Frame to Top frame");

    //Switch to middle frame 
    WebElement middleFrameElement = d.findElement(By.xpath("//frame[2]"));
    d.switchTo().frame(middleFrameElement);
    System.out.println("Switched to middle Frame");

    ////Verify that middle frame has the text "MIDDLE"
    WebElement middleBodyFrameElement = d.findElement(By.xpath("//body/div[@id='content']"));
    if (middleBodyFrameElement.getText().equals("MIDDLE"))
     System.out.println("Middle frame has the text MIDDLE");
    else
     System.out.println("Middle frame does not have the text MIDDLE");


    //Switch back to top frame
    d.switchTo().defaultContent();
    d.switchTo().frame(topFrameElement);
    System.out.println("Switched from middle Frame to Top frame");

    //Switch to right frame
    WebElement rightFrameElement = d.findElement(By.xpath("//frame[@name='frame-right']"));
    d.switchTo().frame(rightFrameElement);
    System.out.println("Switched to right Frame");

    //Verify that right frame has the text "RIGHT"
    WebElement rightBodyFrameElement = d.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
    if (rightBodyFrameElement.getText().equals("RIGHT"))
     System.out.println("Left frame has the text RIGHT");
    else
     System.out.println("Left frame does not have the text RIGHT");

    //Switch back to top frame
    d.switchTo().defaultContent();
    System.out.println("Switched from right Frame to Top frame");

    //Switch to bottom frame
    WebElement bottomFrameElement = d.findElement(By.xpath("//frame[2]"));
    d.switchTo().frame(bottomFrameElement);
    //d.switchTo().frame("frame-bottom");
    System.out.println("Switched to bottom Frame");

    //Verify that bottom frame has the text "BOTTOM"
    WebElement bottomBodyFrameElement = d.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
    if (bottomBodyFrameElement.getText().equals("BOTTOM"))
     System.out.println("Left frame has the text BOTTOM");
    else
     System.out.println("Left frame does not have the text BOTTOM");


    //Switch to top frame
    d.switchTo().defaultContent();
    System.out.println("Switched from bottom Frame to top frame");

    //Verify that page title is "Frames"
    d.switchTo().defaultContent();
    if (d.getTitle().equals("Frames"))
     System.out.println("page title is Frames");
    else
     System.out.println("Page title is not Frames");

    //Close the browser
    d.close();

   }

 }

