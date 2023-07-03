package tests.testCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase10 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Scroll down to footer
        WebElement footerElement = driver.findElement(By.xpath("//footer[@id='footer']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(footerElement).perform();
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());
        //6. Enter email address in input and click arrow button
        Faker faker = new Faker();
        WebElement emailSubElement = driver.findElement(By.id("susbscribe_email"));
        emailSubElement.sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("subscribe")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.id("success-subscribe")).isDisplayed());
    }
}
