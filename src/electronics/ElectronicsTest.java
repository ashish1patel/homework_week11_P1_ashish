package electronics;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsTest extends TopMenuTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //  1.1 Mouse Hover on “Electronics”Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        verifyText("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));
    }

    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics”Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //2.3 Verify the text “Cell phones”
        verifyText("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(5000);
        mouseHoverOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”

        verifyText("Nokia Lumia 1020", By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));

        //2.7 Verify the price “$349.00”
        verifyText("$349.00", By.xpath("//span[@id='price-value-20']"));

        //2.8 Change quantity to 2
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart", By.xpath("//p[@class='content']"));

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(shoppingCart).build().perform();
        goToCart.click();

        //2.12 Verify the message "Shopping cart"
        verifyText("Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));

        //2.13 Verify the quantity is 2
        // verifyText("2",By.cssSelector("#itemquantity11219"));


        //2.14 Verify the Total $698.00
        verifyText("$698.00", By.xpath("//td[@class='subtotal']"));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyText("Register", By.xpath("//h1[contains(text(),'Register')]"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "prime");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "test");
        //selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"18");
        //selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"March");
        //selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1988");
        sendTextToElement(By.xpath("//input[@id='Email']"), "prime1231@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "prime123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "prime123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyText("Your registration completed", By.xpath("//div[@class='result']"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping card”
        verifyText("Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));

        clickOnElement(By.xpath("//a[text()='Log in']"));
        sendTextToElement(By.xpath("//input[@id='Email']"), "prime1236@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "prime123");
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // 2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "12 Kings Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA2 9SG");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "01234567899");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));


        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select master card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "prime testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4521573041475124");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        driver.navigate().to("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//span[normalize-space()='Credit Card']"));

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("2nd Day Air", By.xpath("//span[normalize-space()='2nd Day Air']"));

        //2.37 Verify Total is “$698.00”
        verifyText("$698.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//h1[normalize-space()='Thank you']"));

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("", expectedUrl, actualUrl);
    }

    @After
    public void tearDown() {
//        closeBrowser();
    }
}
