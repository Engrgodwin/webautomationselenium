package myfirstselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumPractice {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void practiseTesting(){

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60));

        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //Assertions and verification

        String productUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(productUrl,expectedUrl, "Test failed because Url doesn't matched");

        System.out.println("Test Passed....Verification successful");

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();

    }

}
