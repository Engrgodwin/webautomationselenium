package myfirstselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class SeleniumLesson1 {

    // Import my webdriver or instantiate webdriver
    // Create a variable of a driver

    WebDriver driver;


    // Setup the browser
    @BeforeTest
    public void setupBrowser(){
   // Test is the main focus
    // We use webdriver manager, because it help us to manage the webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void demoTesting() {
        System.out.println("This step1 opens our test application to the Saucedemo.com");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // To interract with elements on the webpage, we have to use webelement command

        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login Successful!");

        //Verification and assertion
        String productUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(productUrl, expectedUrl, "Test failed because url doesn't matched");

        System.out.println("Url was as expected...verification successful");

        WebElement logo = driver.findElement(By.className("app_logo"));
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);

        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        WebElement entryTitle = driver.findElement(By.linkText("About"));
        entryTitle.click();
        String aboutUrl = driver.getCurrentUrl();
        String targetUrl = "https://saucelabs.com/";

        Assert.assertEquals(aboutUrl, targetUrl, "Test failed because Url doesn't matched");
        System.out.println("Url was as expected...Verification successful");

        driver.navigate().back();

        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText("Name (Z to A)");

        WebElement closeBurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        closeBurgerMenu.click();

        WebElement item0 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCartButton.click();
        System.out.println("Product added to Cart!");

        WebElement shoppingCartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        shoppingCartLink.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Doe");

        WebElement postcodeField = driver.findElement(By.id("postal-code"));
        postcodeField.sendKeys("EC1 2HR");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        finishButton.click();
        System.out.println("Checkout completed successfully!");

        WebElement confirmationMessage = wait.until(ExpectedConditions.elementToBeClickable(By.className("complete-header")));

        if (confirmationMessage.getText().equals("Thank you for your order!")) {

            System.out.println("Order Confirmed!");
        }



    }

     @AfterTest
    public void closeBrowser(){
        driver.quit();


    }

}
