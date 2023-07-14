package tests.testCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class TestCase21 extends TestBase {
    @Test
    public void test21(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());
        //5. Click on 'View Product' button
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
        //6. Verify 'Write Your Review' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='#reviews']")).isDisplayed());
        //7. Enter name, email and review
        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@placeholder='Your Name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@placeholder='Add Review Here!']")).sendKeys(faker.book().title());
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//*[@id='button-review']")).click();
        //9. Verify success message 'Thank you for your review.'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Thank you for your review.']")).isDisplayed());
    
    }
}
