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

public class TestCase24 extends TestBase {
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
    public void test24() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());

        //4. Add products to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[7]"))).perform();
        actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"))).perform();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //5. Click 'Cart' button
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //6. Verify that cart page is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='product_image']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product_image']")).isDisplayed());

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        //9. Fill all details in Signup and create account
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
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

        //12.Click 'Cart' button
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //14. Verify Address Details and Review Your Order
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
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='heading'])[2]")).isDisplayed());
        Thread.sleep(1000);
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("order");
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//*[@name='name_on_card']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//*[@name='card_number']")).sendKeys(faker.business().creditCardNumber());
        driver.findElement(By.xpath("//*[@name='cvc']")).sendKeys(faker.numerify("123"));
        String expirationCard = faker.business().creditCardExpiry();
        String[] cardExp = expirationCard.split("-");
        driver.findElement(By.xpath("//*[@name='expiry_month']")).sendKeys(cardExp[1]);
        driver.findElement(By.xpath("//*[@name='expiry_year']")).sendKeys(cardExp[0]);

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[@data-qa='pay-button']")).click();

        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).isDisplayed());

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
       driver.findElement(By.xpath("//*[@href='/download_invoice/500']")).click();
        //20. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

    }
}
