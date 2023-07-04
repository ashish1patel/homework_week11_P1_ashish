package homepage;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']")).click();
    }

    /**
     * create the @Test method name verifyPageNavigation.use selectMenu method to
     * select the Menu and click on it and verify the page navigation.
     */

    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


