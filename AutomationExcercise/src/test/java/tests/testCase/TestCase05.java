package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase05 extends TestBase {
    @Test
    public void test01(){
        //Test Case 5: Register User with existing email
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());
        //6. Enter name and already registered email address
        WebElement nameElement = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        nameElement.sendKeys("asdasd");
        WebElement eMailElement = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        eMailElement.sendKeys("muratmetinakku@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed());

    }
}
