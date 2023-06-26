package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));
        
        //8. Click 'Submit' button
        //9. Click OK button
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        //11. Click 'Home' button and verify that landed to home page successfully
    }
}
