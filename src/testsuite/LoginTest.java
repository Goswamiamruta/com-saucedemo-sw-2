package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    //Lunch the chrome browser

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }
    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials(){
        // Find the usernameField and enter valid Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Find the password Field and enter valid password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login link and click on login link
        driver.findElement(By.xpath("//input[@name='login-button']")).click();
        //Find out the Product verify  text
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);


    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Find the usernameField and enter valid Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Find the password Field and enter valid password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Find the login link and click on login link
        driver.findElement(By.xpath("//input[@name='login-button']")).click();
        //Find out the six Products verify  text
       int productCount = driver.findElements(By.className("inventory_item_name")).size();

        Assert.assertEquals(productCount,6);

    }

}