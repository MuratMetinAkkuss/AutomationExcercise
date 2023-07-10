package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase13 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Click 'View Product' for any product on home page
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[7]"))).perform();
        actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("(//a[text()='View Product'])[1]"))).perform();
        //5. Verify product detail is opened
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isEnabled());
        //6. Increase quantity to 4
        WebElement increaseButtonElement = driver.findElement(By.xpath("//input[@name='quantity']"));
        increaseButtonElement.clear();
        increaseButtonElement.sendKeys("4");
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        String expectedQuantity = "4";
        String actualQuantity = driver.findElement(By.xpath("//*[@class='disabled']")).getText();

        Assert.assertEquals(expectedQuantity,actualQuantity);
    }
}
