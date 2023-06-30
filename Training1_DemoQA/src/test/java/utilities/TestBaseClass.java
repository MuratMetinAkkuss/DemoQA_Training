package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBaseClass {

   protected static WebDriver driver;
 @BeforeClass
    public static void setup(){
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.get("https://demoqa.com/text-box");
 }

 @AfterClass
    public static void teardown(){
     //driver.close();
 }

 public static void stop (int seconds) {
     try {
         Thread.sleep(seconds*1000);
     } catch (InterruptedException e) {
         System.out.println("Unexpected exception");
         throw new RuntimeException();
     }
 }


}
