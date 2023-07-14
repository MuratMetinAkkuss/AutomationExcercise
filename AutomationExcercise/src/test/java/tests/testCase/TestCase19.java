package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TestCase19 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //Test Case 19: View & Cart Brand Products
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        //4. Verify that Brands are visible on left side bar

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='brands_products']")).isDisplayed());
        //5. Click on any brand name
        Thread.sleep(4000);// i put here because of google ads in automation page is preventing test
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@href='/brand_products/Babyhug']")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='/brand_products/Babyhug']")))).click();
        //6. Verify that user is navigated to brand page and brand products are displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Brand - Babyhug Products']")).isDisplayed());
        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//*[@href='/brand_products/Madame']")).click();
        //8. Verify that user is navigated to that brand page and can see products
        String expectedProductName = "MADAME";
        String actualProductName = driver.findElement(By.xpath("//*[text()='Brand - Madame Products']")).getText();
        Assert.assertTrue(actualProductName.contains(expectedProductName));
    }
}
