package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase03 extends TestBase {
    @Test
    public void test01(){
        //Test Case 3: Login User with incorrect email and password
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Enter incorrect email address and password
        WebElement eMailElement = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        eMailElement.sendKeys("muratmetinakkus@gmail.com");
        WebElement passWordElement = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        passWordElement.sendKeys("asdsadasddsa");
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed());

    }
}
