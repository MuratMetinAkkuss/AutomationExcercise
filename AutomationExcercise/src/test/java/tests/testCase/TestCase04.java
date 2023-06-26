package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase04 extends TestBase {
    @Test
    public void test03(){
        //Test Case 4: Logout User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        String loginPageWindow = driver.getWindowHandle();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Enter correct email address and password
        WebElement eMailElement = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        eMailElement.sendKeys("muratmetinakkusss@gmail.com");
        WebElement passWordElement = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        passWordElement.sendKeys("123456789");
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        //10. Verify that user is navigated to login page
        Assert.assertEquals(loginPageWindow,driver.getWindowHandle());
    }
}
