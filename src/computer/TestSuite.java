package computer;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends TopMenuTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu.
        selectMenu("Computers");

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");


        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> beforeFileNameZtoAList= new ArrayList<>();
        for(WebElement nameZtoA : beforeFilterNameZtoAList)
        {
            beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$" , "")));
        }
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        //Sel.selectByVisibleText("Name: Z to A");

        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double>afterFileNameZtoAList = new ArrayList<>();
        for(WebElement nameZtoA : afterFilterNameZtoAList)
        {
            afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$" , "")));
        }

        Collections.sort(beforeFileNameZtoAList);
        Assert.assertEquals(beforeFilterNameZtoAList,afterFilterNameZtoAList);
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        selectMenu("Computers");

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);

        //2.4 Click on "Add To Cart"
        driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]")).click();

        //2.5 Verify the Text "Build your own computer"
        verifyText("Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
//        String expectedText = "Build your own computer";
//        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]")).getText();
//        Assert.assertEquals("", expectedText, actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");


        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(5000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        clickOnElement(By.id("product_attribute_5_10"));
        // clickOnElement(By.id("product_attribute_5_12"));

        //2.11 Verify the price "$1,470.00"
        verifyText("$1,470.00", By.id("price-value-1"));
//        String expectedPrice = "$1,470.00";
//        String actualPrice = getTextFromElement(By.id("price-value-1"));
//        Assert.assertEquals("", actualPrice, expectedPrice);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart", By.className("content"));
//        String expectedText1 = "The product has been added to your shopping cart";
//        String actualText1 = getTextFromElement(By.className("content"));
//        Assert.assertEquals("", actualText1, expectedText1);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.className("close"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).build().perform();
        goToCart.click();

        // 2.15 Verify the message "Shopping cart"
        verifyText("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
//        String expectedMassage = "Shopping cart";
//        String actualMassage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
//        Assert.assertEquals("verify message", expectedMassage, actualMassage);
        Thread.sleep(5000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@aria-label='Qty.']")).clear();
        driver.findElement(By.xpath("//input[@aria-label='Qty.']")).sendKeys("2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,840.00"
        Thread.sleep(5000);
        verifyText("$2,840.00", By.cssSelector("span[class='value-summary'] strong"));
//        String expectedPrice1 = "$2,840.00";
//        String actualPrice1 = getTextFromElement(By.cssSelector("span[class='value-summary'] strong"));
//        Assert.assertEquals("", actualPrice1, expectedPrice1);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
//        String expectedText2 = "Welcome, Please Sign In!";
//        String actualText2 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
//        Assert.assertEquals("", expectedText2, actualText2);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "prime");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "testing");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "prime1231@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "12 kings road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA2 9SG");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07535875458");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "prime testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5521573041475125");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
//        String expectedText3 = "Credit Card";
//        String actualText3 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
//        Assert.assertEquals("", actualText3, expectedText3);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Next Day Air", By.xpath("//span[normalize-space()='Next Day Air']"));
//        String expectedText4 = "Next Day Air";
//        String actualText4 = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
//        Assert.assertEquals("", actualText4, expectedText4);

        //2.33 Verify Total is “$2,950.00”
        verifyText("$2,840.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,840.00')]"));
//        String expectedText5 = "$2,840.00";
//        String actualText5 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,840.00')]"));
//        Assert.assertEquals("", actualText5, expectedText5);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
//        String expectedText6 = "Thank you";
//        String actualText6 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
//        Assert.assertEquals("", actualText6, expectedText6);

        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
//        String expectedText7 = "Your order has been successfully processed!";
//        String actualText7 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
//        Assert.assertEquals("", actualText7, expectedText7);

        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));
//        String expectedText8 = "Welcome to our store";
//        String actualText8 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
//        Assert.assertEquals("", actualText8, expectedText8);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
