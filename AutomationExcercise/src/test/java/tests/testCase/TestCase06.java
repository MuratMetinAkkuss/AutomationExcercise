package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class TestCase06 extends TestBase {
    @Test
    public void test01(){
        //Test Case 6: Contact Us Form
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        List<WebElement> homePageList = driver.findElements(By.className("container"));
        for (WebElement each: homePageList
             ) {
            Assert.assertTrue(each.isDisplayed());
        }
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed());
        //6. Enter name, email, subject and message
        WebElement nameElement = driver.findElement(By.xpath("//input[@data-qa='name']"));
        nameElement.sendKeys("Metin");
        WebElement eMailElement = driver.findElement(By.xpath("//input[@data-qa='email']"));
        eMailElement.sendKeys("muratmetinakkus@gmail.com");
        WebElement subjectElement = driver.findElement(By.xpath("//input[@data-qa='subject']"));
        subjectElement.sendKeys("Testing Process");
        WebElement messageElement = driver.findElement(By.xpath("//textarea[@data-qa='message']"));
        messageElement.sendKeys("Text");
        //7. Upload file
        WebElement uploadFileElement = driver.findElement(By.xpath("//input[@name='upload_file']"));
        String filePath = System.getProperty("user.home") + "\\Downloads\\example.png";
        uploadFileElement.sendKeys(filePath);
        messageElement.sendKeys(Keys.PAGE_DOWN);
        //8. Click 'Submit' button
        sleep(1);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleep(1);
        //9. Click OK button
        driver.switchTo().alert().accept();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        sleep(1);
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
    }
}
