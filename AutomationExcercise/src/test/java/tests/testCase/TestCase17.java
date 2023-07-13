package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase17 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Add products to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[7]"))).perform();
        actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"))).perform();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //5. Click 'Cart' button
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product_image']")).isDisplayed());

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//*[@class='cart_quantity_delete']")).click();
        //8. Verify that product is removed from the cart
        //Assert.assertFalse(driver.findElement(By.xpath("//*[@src='get_product_picture/1']")).isDisplayed());
        //i thought that the line 35 could be ran but didn't because of the line 33 changed the page.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='empty_cart']")).isDisplayed());
    }
}
