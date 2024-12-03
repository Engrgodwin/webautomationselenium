package myfirstselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class SeleniumLesson1 {

    // Import my webdriver or instantiate webdriver
    // Create a variable of a driver

    WebDriver driver;


    // Setup the browser
    @BeforeTest
    public void setupBrowser(){
   // Test is the main focus
    // We use webdriver manager, because it help us to manage the webdriver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @Test
    public void demoTesting(){
        System.out.println("This step1 opens our test application to the Saucedemo.com");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60));


        // To interract with elements on the webpage, we have to use webelement command

        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //Verification and assertion
        String productUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(productUrl,expectedUrl,"Test failed because url doesn't matched");

        System.out.println("Url was as expected...verification successful");

    }

     @AfterTest
    public void closeBrowser(){
        driver.quit();


    }

}
