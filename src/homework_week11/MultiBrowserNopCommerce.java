package homework_week11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
public class MultiBrowserNopCommerce {
    static String  browser = "Edge";
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2";

    static WebDriver driver;

    public static void main(String[] args) {
        //Set up multiple browser
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong browser name");
        }

        //open the URL into browser
        driver.get(baseUrl);

        //Maximise the browser
        driver.manage().window().maximize();

        //Give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        System.out.println("Title of the page is: " + driver.getTitle());

        //Print the current URL of the page
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        //Get the page source of the page
        System.out.println("Current page source is: " + driver.getPageSource());

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
