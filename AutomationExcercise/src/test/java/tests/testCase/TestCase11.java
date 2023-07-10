package tests.testCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase11 extends TestBase {
    @Test
    public void test01(){
        //Test Case 11: Verify Subscription in Cart page
        //1. Launch browser

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//*[@href='/view_cart']")).click();
        //5. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("footer"))).perform();
        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());
        //7. Enter email address in input and click arrow button
        Faker faker = new Faker();
        WebElement eMailElement = driver.findElement(By.xpath("//*[@id='susbscribe_email']"));
        eMailElement.sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@id='subscribe']")).click();
        //8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='success-subscribe']")).isDisplayed());

    }
}
