package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUP() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
          //Click on 'sign in' link
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();
          //Enter valid Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testing12@gmail.com");
        //Enter valid password
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("TestingB12");
        //Click on 'sign in, button
        driver.findElement(By.xpath("//button[@class='action login primary']")).click();
        //verify the 'Welcome' text is displayed
        String expectedMessage = "Welcome, Testing Prime!";
        WebElement actualTextMessage = driver.findElement(By.xpath("//li[@class='greet welcome']//span[text()='Welcome, Testing Prime!']"));
        String actualMessage = actualTextMessage.getText();
         Assert.assertEquals(expectedMessage,actualMessage);
        }
        @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
            //Click on 'sign in' link
            driver.findElement(By.xpath("//li[@class='authorization-link']")).click();

            //Enter valid Email
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testing123@gmail.com");

            //Enter valid password
            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("TestingB123");

            //Click on 'sign in, button
            driver.findElement(By.xpath("//button[@class='action login primary']")).click();

            //verify the error message is displayed
          String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
          WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily." +
                  " Please wait and try again later.')]"));
          String actualMessage = actualTextElement.getText();
          Assert.assertEquals(expectedMessage,actualMessage);

        }
        @Test
    public void userShouldLogOutSuccessfully(){
            //Click on 'sign in' link
            driver.findElement(By.xpath("//li[@class='authorization-link']")).click();

            //Enter valid Email
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testing12@gmail.com");

            //Enter valid password
            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("TestingB12");

            //Click on 'sign in, button
            driver.findElement(By.xpath("//button[@class='action login primary']")).click();

            //verify the 'Welcome' text is displayed
            String expectedMessage = "Welcome, Testing Prime!";
            WebElement actualTextMessage = driver.findElement(By.xpath("//li[@class='greet welcome']//span[text()='Welcome, Testing Prime!']"));
            String actualMessage = actualTextMessage.getText();
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

