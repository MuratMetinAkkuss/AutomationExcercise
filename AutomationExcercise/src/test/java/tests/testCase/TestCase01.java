package tests.testCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase01 extends TestBase{
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //first 2 mission i did in TesBase Class

        //3. Verify that home page is visible successfully

        WebElement homePageElement = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homePageElement.isDisplayed());

        //4. Click on 'Signup / Login' button

        WebElement signUpAndLogInElement = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpAndLogInElement.click();

        //5. Verify 'New User Signup!' is visible

        WebElement newUserSignupElement = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupElement.isDisplayed());

        //6. Enter name and email address

        WebElement nameElement = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameElement.sendKeys("Murat metin");

        WebElement lastNameElement = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        lastNameElement.sendKeys("muratmetinakkusssss@gmail.com");

        //7. Click 'Signup' button

        WebElement signUpElement = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpElement.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth

        WebElement passWordElement = driver.findElement(By.id("password"));
        passWordElement.sendKeys("123yyyyaaaa"+ Keys.PAGE_DOWN);

        WebElement daysForBirthElement = driver.findElement(By.id("days"));
        Select selectDay = new Select(daysForBirthElement);
        selectDay.selectByValue("4");

        WebElement monthsForBirthElement = driver.findElement(By.id("months"));
        Select selectMonth = new Select(monthsForBirthElement);
        selectMonth.selectByValue("1");

        WebElement yearsForBirthelement = driver.findElement(By.id("years"));
        Select selectYear = new Select(yearsForBirthelement);
        selectYear.selectByValue("1999");

        //10. Select checkbox 'Sign up for our newsletter!'

        WebElement addElement = driver.findElement(By.xpath("//div[@class='grippy-host']"));
        addElement.click();

        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstNameElement.sendKeys("Murat Metin");

        WebElement lastNameElementElement = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastNameElementElement.sendKeys("Akkus");

        WebElement companyElement = driver.findElement(By.xpath("//input[@id='company']"));
        companyElement.sendKeys("WiseQuarter");

        WebElement adressElement = driver.findElement(By.id("address1"));
        String adress = "Wageningselan 2 Veneendaal 3093LA Utrecht The Nederlands";
        adressElement.sendKeys(adress);

        WebElement adress2Element = driver.findElement(By.id("address2"));
        String adress2 = "Turkey Izmir";
        adress2Element.sendKeys(adress2+Keys.PAGE_DOWN);

        WebElement countryElement = driver.findElement(By.id("country"));
        Select selectCountry = new Select(countryElement);
        selectCountry.selectByValue("Canada");

        sleep(3);

        WebElement stateElement = driver.findElement(By.xpath("//input[@data-qa='state']"));
        stateElement.sendKeys("North America");

        WebElement cityElement = driver.findElement(By.xpath("//input[@id='city']"));
        cityElement.sendKeys("Toronto");

        WebElement zipcodeElement = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipcodeElement.sendKeys("3903LA");

        WebElement mobileNumberElement = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumberElement.sendKeys("0684167143");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
