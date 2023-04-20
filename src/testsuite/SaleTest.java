package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseURL = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage(){
        //Click on 'sale' menu tab
        driver.findElement(By.xpath("//a[@class='level-top ui-corner-all']//span[text()='Sale']")).click();
        //Click on 'Jackets' link on left side under WOMEN'S DEAL category
        driver.findElement(By.xpath("//ul[@class='items']//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']")).click(); // //ul[@class='items']//a[text()='Jackets']
       //Verify the text 'Jackets is displayed
        String expectedMsg = "Jackets";
        WebElement actualJacketElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMsg = actualJacketElement.getText();
        Assert.assertEquals(actualMsg,expectedMsg);
        //Count the Total item displayed on page console
        List<WebElement> itemDisplayed = driver.findElements(By.className("product-image-photo"));
        System.out.println("Total items displayed :"+itemDisplayed);

        //Verify total 12 items displayed on page.
        System.out.println(("Total items are :"+itemDisplayed.size()));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
