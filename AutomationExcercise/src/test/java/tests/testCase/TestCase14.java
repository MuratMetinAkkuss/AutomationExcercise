package tests.testCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCase14 extends TestBase {
    @Test
    public void test14(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
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
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product_image']")).isDisplayed());
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        //9. Fill all details in Signup and create account
        Faker faker = new Faker();
        WebElement nameElement = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameElement.sendKeys(faker.name().firstName());

        WebElement lastNameElement = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        lastNameElement.sendKeys(faker.internet().emailAddress());

        WebElement signUpElement = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpElement.click();

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

        WebElement addElement = driver.findElement(By.xpath("//div[@class='grippy-host']"));
        addElement.click();

        driver.findElement(By.id("newsletter")).click();

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

        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

        //12.Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //14. Verify Address Details and Review Your Order
       // String fullAdress = "Murat Metin Akkus WiseQuarter Wageningselan 2 Veneendaal 3093LA Utrecht The Nederlands Turkey Izmir Toronto North America 3903LA Canada 0684167143";
       // WebElement name = driver.findElement(By.xpath("(//*[@class='address_firstname address_lastname'])[1]"));
       // WebElement adress1 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[1]"));
       // WebElement adresss2 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[2]"));
       // WebElement adress3 = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[3]"));
       // WebElement state = driver.findElement(By.xpath("(//*[@class='address_city address_state_name address_postcode'])[1]"));
       // WebElement country = driver.findElement(By.xpath("(//*[@class='address_country_name'])[1]"));
       // WebElement phone = driver.findElement(By.xpath("(//*[@class='address_phone'])[1]"));
       // List<WebElement> adressList = new ArrayList<>();
       // adressList.add(name);
       // adressList.add(adress1);
       // adressList.add(adresss2);
       // adressList.add(adress3);
       // adressList.add(state);
       // adressList.add(country);
       // adressList.add(phone);
       // for (WebElement each: adressList
        //     ) {
        //    if (!fullAdress.contains(each.getText())){
        //        Assert.assertTrue(fullAdress.contains(each.getText()));
        //    }
        //}
        //!!!!!!!!!!!!!!!!!!!!14. section must be reviwed// not dynamic!!!!!!!!!!!!!!!!!!!!!!!!!!

        //15. Enter description in comment text area and click 'Place Order'
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();
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
        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
    }
}
