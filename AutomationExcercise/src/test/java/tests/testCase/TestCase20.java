package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase20 extends TestBase {
    @Test
    public void test20() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());
        //5. Enter product name in search input and click search button
        String productName = "Summer White Top";
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys(productName);
        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
        //6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Summer White Top'])[1]")).isDisplayed());
        //7. Verify all the products related to search are visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Searched Products']")).isDisplayed());
        //8. Add those products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"))).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        //9. Click 'Cart' button and verify that products are visible in cart
        //Thread.sleep(2000); // i add thread because cart page couldn't catch the driver speed
        driver.findElement(By.xpath("//*[@href='/view_cart']")).click();
        driver.navigate().refresh();// i add because of the web page doesnt show the product of cart page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/product_details/6']")).isDisplayed());
        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        WebElement eMailElement = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        eMailElement.sendKeys("muratmetinakkusssss@gmail.com");
        WebElement passWordElement = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        passWordElement.sendKeys("123yyyyaaaa");
        //11. Again, go to Cart page
        driver.findElement(By.xpath("//*[@href='/view_cart']")).click();
        //12. Verify that those products are visible in cart after login as well
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/product_details/6']")).isDisplayed());
    }
}
