package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
      String baseURL = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }
    @Test
    public void verifyThatSignInPageDisplay(){
        //click on the 'Create an Account'
        driver.findElement(By.linkText("Create an Account")).click();
        //Verify the text 'Create New Customer Account'
        String expectedText = "Create New Customer Account";
         WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page-title-wrapper']"));
         String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Click on the 'Create an account' link
        driver.findElement(By.linkText("Create an Account")).click();

        //Enter first name
        driver.findElement((By.xpath("//input[@id='firstname']"))).sendKeys("Prime");

        //Enter Last Name
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Testing");

        //Click on checkbox sign up for Newsletter
        driver.findElement(By.xpath("//input[@class='checkbox']")).click();

        //Enter Email
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("prime4144@gmail.com");

        //Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prime24*ABC");

        //Enter confirm password
        driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("prime24*ABC");

        //Click on create an account button
        driver.findElement(By.xpath("//button[@class='action submit primary']")).click();

        //Verify the text 'Thank you for registering with main website store.'
        String expectedMessage = "Thank you for registering with Main Website Store.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-success success message']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

        //click on down aero near welcome
        driver.findElement(By.xpath("//button[@class='action switch']")).click();

        //click on sign out link
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();

        //Verify the text 'You are signed out'
        driver.findElement(By.xpath("//div[@class='page-title-wrapper']"));
        Assert.assertEquals("You are signed out",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
