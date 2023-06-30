package tests.demoQA;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.Set;

public class C02_Elements extends TestBaseClass {
    @Test
    public void test01(){
        //button
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(Keys.PAGE_DOWN);// i put for page down
        WebElement buttons = driver.findElement(By.xpath("//*[text()='Buttons']"));
        actions.click(buttons).perform();
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();
    }
    @Test
    public void test02(){
        //button
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(Keys.PAGE_DOWN);
        WebElement buttons = driver.findElement(By.xpath("//*[text()='Buttons']"));
        actions.click(buttons).perform();
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();
        WebElement clickedRight = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(clickedRight.isDisplayed());
    }
    @Test
    public void test03(){
        //button
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(Keys.PAGE_DOWN);
        stop(1);
        WebElement buttons = driver.findElement(By.xpath("//*[text()='Buttons']"));
        actions.click(buttons).perform();
        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMe).perform();
        WebElement messageForClickMe= driver.findElement(By.id("dynamicClickMessage"));
        //You have done a dynamic click
        Assert.assertEquals("You have done a dynamic click",messageForClickMe.getText());
    }
    @Test
    public void test04(){
        //links
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(Keys.PAGE_DOWN);
        stop(1);
        WebElement linksElement = driver.findElement(By.xpath("//span[text()='Links']"));
        actions.click(linksElement).perform();
        String wHDFirstPage = driver.getWindowHandle();
        //Following links will open new tab
        //first Link
        driver.findElement(By.id("simpleLink")).click();
        String secondWHD = driver.getWindowHandle();

        Set<String> pagesWHD = driver.getWindowHandles();
        for (String eachWHD: pagesWHD
             ) {
            if (wHDFirstPage.equals(eachWHD)){
                driver.switchTo().window(eachWHD);
            }
        }
        Assert.assertEquals(wHDFirstPage,driver.getWindowHandle());

        //Second Links

        driver.findElement(By.id("dynamicLink")).click();
        String wHDThirhtPage = driver.getWindowHandle();
        pagesWHD = driver.getWindowHandles();
        for (String eachWHD: pagesWHD
        ) {
            if (wHDFirstPage.equals(eachWHD)){
                driver.switchTo().window(eachWHD);
            }
        }
        Assert.assertEquals(wHDFirstPage,driver.getWindowHandle());

        driver.switchTo().window(secondWHD);
        

    }

}
