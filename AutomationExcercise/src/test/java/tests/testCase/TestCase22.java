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

public class TestCase22 extends TestBase {
    @Test
    public void test22() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Scroll to bottom of page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(4000);
        //4. Verify 'RECOMMENDED ITEMS' are visible
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP ).sendKeys(Keys.PAGE_UP).perform();
        //actions.scrollToElement(driver.findElement(By.xpath("//*[@class='left recommended-item-control']"))).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='recommended items']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='recommended items']")).isDisplayed());
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("//*[@id='recommended-item-carousel']/div/div[1]/div[2]/div/div/div/a")).click();
        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();
        //7. Verify that product is displayed in cart page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/product_details/2']")).isDisplayed());
    }
}
