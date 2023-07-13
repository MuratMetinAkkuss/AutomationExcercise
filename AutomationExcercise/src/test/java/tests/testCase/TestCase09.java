package tests.testCase;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase09 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //6. Enter product name 'Winter Top' in search input and click search button
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Winter Top");
        driver.findElement(By.id("submit_search")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());
        //8. Verify all the products related to search are visible
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/get_product_picture/5']")).isDisplayed());
    }
}
