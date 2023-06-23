package tests.demoQA_day1;

import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseClass;

public class C01_Elements extends TestBaseClass {
    @Test
    public void test01(){
        //Text Box
        driver.get("https://demoqa.com/text-box");
        //FullName Test
        WebElement fullNameElement =driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameElement.sendKeys("Murat Metin Akkus");
        stop(1);
        Assert.assertTrue(fullNameElement.isDisplayed());
        Assert.assertTrue(fullNameElement.isEnabled());
        Assert.assertEquals("input", fullNameElement.getTagName());

        //Email

        WebElement eMailElement = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMailElement.sendKeys("muratmetinakkus@gmail.com");
        stop(1);
        //current adres
        WebElement currentAdressElement = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAdressElement.sendKeys("Wageningselaan, 2 Utrecht/Veneendaal");
        stop(1);
        WebElement permanentAdressElement = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdressElement.sendKeys("Izmir Turkiye");
        stop(1);
        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.submit();

    }
    @Test
    public void test02(){
        WebElement checkBoxElement = driver.findElement(By.xpath("//span[text()='Check Box']"));
        checkBoxElement.click();

        WebElement chechkBoxElement = driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']"));
        Assert.assertTrue(chechkBoxElement.isDisplayed());
        Assert.assertTrue(chechkBoxElement.isEnabled());
        Actions actions = new Actions(driver);
        actions.click(chechkBoxElement).perform();
        stop(2);

        //pick all 3 boxes and test
        WebElement secondCheckBoxElement = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[2]"));
        Assert.assertTrue(secondCheckBoxElement.isEnabled());
        actions.click(secondCheckBoxElement).perform();
        stop(2);

        WebElement thirthCheckBoxElement = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]"));
        Assert.assertTrue(thirthCheckBoxElement.isEnabled());
        actions.click(thirthCheckBoxElement).perform();
        stop(2);

        WebElement fourthCheckBoxElement = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[4]"));
        Assert.assertTrue(fourthCheckBoxElement.isEnabled());
        actions.click(fourthCheckBoxElement).perform();
        stop(2);

        //get text what you have selected
        WebElement textElement = driver.findElement(By.xpath("//div[@id='result']"));
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertTrue(textElement.isEnabled());
        System.out.println(textElement.getText());

    }
    @Test
    public void test03(){
        WebElement radioButtonElement = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        Actions actions = new Actions(driver);
        actions.click(radioButtonElement).perform();

        //do you really like the site?
        WebElement likeElement = driver.findElement(By.xpath("//div[text()='Do you like the site?']"));
        Assert.assertTrue(likeElement.isDisplayed());

        WebElement yesRadioButtonElement = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        actions.click(yesRadioButtonElement).perform();
        Assert.assertTrue(yesRadioButtonElement.isSelected());

        //check no box as a false selected
        WebElement noRadioButtonElement = driver.findElement(By.xpath("//input[@id='noRadio']"));
        Assert.assertFalse(radioButtonElement.isSelected());
        Assert.assertTrue(radioButtonElement.isEnabled());



    }

    @Test
    public void test04(){
        WebElement buttonsElement = driver.findElement(By.xpath("//span[text()='Buttons']"));
        Actions actions = new Actions(driver);
        actions.click(buttonsElement).perform();
    }
}
