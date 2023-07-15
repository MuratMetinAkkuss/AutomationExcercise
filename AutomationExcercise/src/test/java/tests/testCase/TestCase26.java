package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TestCase26 extends TestBase {
    @Test
    public void test26(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());

        //4. Scroll down page to bottom
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());
        //6. Scroll up page to top
        actions = new Actions(driver);
        actions.sendKeys(Keys.UP).perform();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[text()='Full-Fledged practice website for Automation Engineers'])[1]"))));
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Full-Fledged practice website for Automation Engineers'])[1]")).isDisplayed());
    }
}
