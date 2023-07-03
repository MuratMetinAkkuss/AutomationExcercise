package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase08 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //7. Click on 'View Product' of first product
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        sleep(1);
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //8. User is landed to product detail page
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Category: Women > Tops']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Rs. 500']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=' In Stock']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=' New']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=' Polo']")).isDisplayed());
    }
}
