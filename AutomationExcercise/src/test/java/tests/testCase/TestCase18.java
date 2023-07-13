package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase18 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that categories are visible on left side bar
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//*[@href='#Kids']"))).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='left-sidebar']")).isDisplayed());

        driver.findElement(By.xpath("//*[@class='grippy-host']")).click();
        // i put line 19 for pop-up ad
        //4. Click on 'Women' category
        driver.findElement(By.xpath("//*[@href='#Women']")).click();
        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//*[@href='/category_products/1']")).click();
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Women - Dress Products']")).isDisplayed());
        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//*[@href='#Men']")).click();
        driver.findElement(By.xpath("//*[@href='/category_products/3']")).click();
        //8. Verify that user is navigated to that category page
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']")).isDisplayed());

    }
}
