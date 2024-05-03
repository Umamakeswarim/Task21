package guvi.task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class t21two {

 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
  WebDriver d=new ChromeDriver();
  
  //Navigate to the URL
     d.get("https://the-internet.herokuapp.com/windows");
     d.manage().window().maximize();
     Thread.sleep(1000);
     
     //Click on "CLICKHERE" link 
     d.findElement(By.xpath("//a[.='Click Here']")).click();

     // main window handle
     String mainwindow=d.getWindowHandle();
     //System.out.println(mainWindow);

     //Switch to Child window
     for(String windowHandle:d.getWindowHandles()) {
      //System.out.println(windowHandle);
      d.switchTo().window(windowHandle);
     }

     //Verify the child window message

     WebElement childWindowTitle=d.findElement(By.xpath("//h3"));
     if(childWindowTitle.getText().equals("New Window"))
      System.out.println("Child window has a text - "+ childWindowTitle.getText());
     else
      System.out.println("Child window does not have a text - "+ childWindowTitle.getText());

     //Close the child window
     d.close();

     //Switch to Main window
     d.switchTo().window(d.getWindowHandles().iterator().next());
     // driver.switchTo().window(mainWindow);

     //Verify the main window message
     WebElement mainWindowTitle=d.findElement(By.xpath("//h3[.='Opening a new window']"));
     if(mainWindowTitle.getText().equals("Opening a new window"))
      System.out.println("Main window has a text - "+ mainWindowTitle.getText());
     else
      System.out.println("Main window does not have a text - "+ mainWindowTitle.getText());

     //Close the main window
     d.close();
 }

}