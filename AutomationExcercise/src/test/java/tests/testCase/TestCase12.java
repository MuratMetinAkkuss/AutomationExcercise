package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TestCase12 extends TestBase {
    @Test
    public void test01(){
        //Test Case 12: Add Products in Cart
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Click 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        sleep(3);
        //5. Hover over first product and click 'Add to cart'
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[7]"))).perform();
        actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"))).perform();
        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        //7. Hover over second product and click 'Add to cart'
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]"))).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();
        //9. Verify both products are added to Cart
        String firstItem = driver.findElement(By.xpath("(//*[@class='disabled'])[1]")).getText();
        String secondItem = driver.findElement(By.xpath("(//*[@class='disabled'])[1]")).getText();

        int firstItemInt = Integer.parseInt(firstItem);
        int secondItemInt = Integer.parseInt(secondItem);
        Assert.assertTrue(firstItemInt > 0);
        Assert.assertTrue(secondItemInt > 0);
    }
}
