package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase02 extends TestBase {
    @Test
    public void test01(){
        //Test Case 2: Login User with correct email and password
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
         Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Enter correct email address and password
        WebElement eMailElement = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        eMailElement.sendKeys("muratmetinakkuss@gmail.com");
        WebElement passWordElement = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        passWordElement.sendKeys("sadasddsadsa12.,");
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed());
    }
}
