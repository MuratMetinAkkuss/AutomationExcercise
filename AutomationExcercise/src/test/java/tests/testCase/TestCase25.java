package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase25 extends TestBase {
    @Test
    public void test25() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());
        //6. Click on arrow at bottom right side to move upward
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();//for pop-up google ads
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='scrollUp']")).click();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='col-sm-12']")).isDisplayed());
    }
}
