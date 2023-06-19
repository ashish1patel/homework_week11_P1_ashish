package homework_week11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Project-1 - Project Name: com-nopcommerce
 * BaseUrl =
 * https://demo.nopcommerce.com/login?returnUrl=%2
 * 1. Setup chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class NopCommerce {
    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

        // Setup chrome browser
        WebDriver driver = new ChromeDriver();

        //Open the URL into browser
        driver.get(baseUrl);

        //Maximise the browser
        driver.manage().window().maximize();

        // Give Implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page: " + title);
        //System.out.println("Title of the page: " + driver.getTitle());

        //Print the current URL
        String URL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + URL);
      //System.out.println("Current URL is: " + driver.getCurrentUrl());

        //Get the page source
        String pageSource = driver.getPageSource();
        System.out.println("Current page source is: " + pageSource);
       // System.out.println("Current page source is: " + driver.getPageSource());

        //Enter email id into email id field
        WebElement emailIdField = driver.findElement(By.id("Email"));
        emailIdField.sendKeys("ashish123@gmail.com");

        //Enter password into password field
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("ashish123");

        //Close the driver
        driver.close();

    }
}
