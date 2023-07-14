package tests.testCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TestCase23 extends TestBase {
    String name;
    String lastName;
    String eMail;
    String companyName;
    String adress;
    String secondAdress;
    String state;
    String city;
    String zipCode;
    String phoneNumber;

    @Test
    public void test23() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Fill all details in Signup and create account
        Faker faker = new Faker();
        name = faker.name().firstName();
        WebElement nameElement = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameElement.sendKeys(name);

        eMail =faker.internet().emailAddress();
        WebElement lastNameElement = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        lastNameElement.sendKeys(eMail);

        WebElement signUpElement = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpElement.click();

        WebElement passWordElement = driver.findElement(By.id("password"));
        passWordElement.sendKeys(faker.numerify("123321ta")+ Keys.PAGE_DOWN);

        WebElement daysForBirthElement = driver.findElement(By.id("days"));
        Select selectDay = new Select(daysForBirthElement);
        selectDay.selectByValue("4");

        WebElement monthsForBirthElement = driver.findElement(By.id("months"));
        Select selectMonth = new Select(monthsForBirthElement);
        selectMonth.selectByValue("1");

        WebElement yearsForBirthelement = driver.findElement(By.id("years"));
        Select selectYear = new Select(yearsForBirthelement);
        selectYear.selectByValue("1999");

        WebElement addElement = driver.findElement(By.xpath("//div[@class='grippy-host']"));
        addElement.click();

        driver.findElement(By.id("newsletter")).click();

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstNameElement.sendKeys(name);

        lastName = faker.name().lastName();
       WebElement lastNameElementElement = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastNameElementElement.sendKeys(lastName);

        companyName= faker.company().name();
        WebElement companyElement = driver.findElement(By.xpath("//input[@id='company']"));
        companyElement.sendKeys(companyName);

        adress = faker.address().fullAddress();
        WebElement adressElement = driver.findElement(By.id("address1"));
        adressElement.sendKeys(adress);

        secondAdress = faker.address().secondaryAddress();
        WebElement adress2Element = driver.findElement(By.id("address2"));
        adress2Element.sendKeys(secondAdress+Keys.PAGE_DOWN);

        WebElement countryElement = driver.findElement(By.id("country"));
        Select selectCountry = new Select(countryElement);
        selectCountry.selectByValue("Canada");

        sleep(3);

        state = faker.address().country();
        WebElement stateElement = driver.findElement(By.xpath("//input[@data-qa='state']"));
        stateElement.sendKeys(state);

        city = faker.address().city();
        WebElement cityElement = driver.findElement(By.xpath("//input[@id='city']"));
        cityElement.sendKeys(city);

        zipCode = faker.address().zipCode();
        WebElement zipcodeElement = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipcodeElement.sendKeys(zipCode);


        phoneNumber = faker.phoneNumber().cellPhone();
        WebElement mobileNumberElement = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumberElement.sendKeys(phoneNumber);

        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.navigate().refresh();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

        //8. Add products to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[7]"))).perform();
        actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"))).perform();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //9. Click 'Cart' button
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //10. Verify that cart page is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='product_image']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product_image']")).isDisplayed());

        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //12. Verify that the delivery address is same address filled at the time registration of account
        WebElement deliveryName = driver.findElement(By.xpath("(//*[@class='address_firstname address_lastname'])[1]"));
        Assert.assertTrue(deliveryName.getText().contains(name)&&deliveryName.getText().contains(lastName));
        WebElement companyAdress = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[1]"));
        Assert.assertTrue(companyAdress.getText().contains(companyName));
        WebElement adress1 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[2]"));
        Assert.assertTrue(adress1.getText().contains(adress));
        WebElement adress2 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[3]"));
        Assert.assertTrue(adress2.getText().contains(secondAdress));
        WebElement stateCityZipCode = driver.findElement(By.xpath("(//*[@class='address_city address_state_name address_postcode'])[1]"));
        Assert.assertTrue(stateCityZipCode.getText().contains(state)&&stateCityZipCode.getText().contains(city)&&stateCityZipCode.getText().contains(zipCode));
        WebElement phone = driver.findElement(By.xpath("(//*[@class='address_phone'])[1]"));
        Assert.assertTrue(phone.getText().contains(phoneNumber));

        //13. Verify that the billing address is same address filled at the time registration of account
        WebElement billName = driver.findElement(By.xpath("(//*[@class='address_firstname address_lastname'])[1]"));
        Assert.assertTrue(deliveryName.getText().contains(name)&&deliveryName.getText().contains(lastName));
        WebElement BillCompanyAdress = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[1]"));
        Assert.assertTrue(companyAdress.getText().contains(companyName));
        WebElement billAdress1 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[2]"));
        Assert.assertTrue(adress1.getText().contains(adress));
        WebElement billAdress2 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[3]"));
        Assert.assertTrue(adress2.getText().contains(secondAdress));
        WebElement billStateCityZipCode = driver.findElement(By.xpath("(//*[@class='address_city address_state_name address_postcode'])[1]"));
        Assert.assertTrue(stateCityZipCode.getText().contains(state)&&stateCityZipCode.getText().contains(city)&&stateCityZipCode.getText().contains(zipCode));
        WebElement Billphone = driver.findElement(By.xpath("(//*[@class='address_phone'])[1]"));
        Assert.assertTrue(phone.getText().contains(phoneNumber));
        //14. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

    }
}
