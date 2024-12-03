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

public class AutoTestingPractiseBlog {

    // Instantiate my webdriver and create an instance of the driver

    WebDriver driver;

    // Setup the browser

    @BeforeTest
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    // Create the test, the test is the main focus
    // We use the webdriverManager to manage the webdriver

    @Test
    public void demoAutoTesting() {

        System.out.println("This step1 opens our application to https://testautomationpractice.blogspot.com/");
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60));

        // Create a variable of the Webdrive as the functions of the webpage
        // Interract with the elements of the webpage using the webElement command

        // Testing the Page title element
        WebElement pageTitle = driver.findElement(By.tagName("title"));
        String titleText = pageTitle.getAttribute("textContent");
        System.out.println("Page title: " + titleText);

        //Testing the Page header element
        WebElement spanElement = driver.findElement(By.xpath("//span[text()='For Selenium, Cypress & Playwright']"));
        String spanText = spanElement.getText();
        System.out.println("Span Text: " + spanText);
        if (spanElement.isDisplayed()) {
            System.out.println("The span element is visible on the page.");
        }

        // Testing Entry title
        WebElement entryTitle = driver.findElement(By.linkText("GUI Elements"));
        entryTitle.click();
        String productUrl = driver.getCurrentUrl();
        String expectedUrl = "https://testautomationpractice.blogspot.com/2018/09/automation-form.html";

        Assert.assertEquals(productUrl,expectedUrl,"Test failed because Url doesn't matched");
        System.out.println("Url was as expected...Verification successful");

        // Testing the Name Field functionality
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys("John Doe");

        // Testing the Email Field
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys("automationpracticeblog@gmail.com");

        // Testing the Phone Number Field
        WebElement phoneNumberField = driver.findElement(By.id("phone"));
        phoneNumberField.clear();
        phoneNumberField.sendKeys("0123456789");

        // Testing the Address Field
        WebElement addressField = driver.findElement(By.id("textarea"));
        addressField.clear();
        addressField.sendKeys("1 United Kingdom Street, UT1 2KD");

        // Gender Select Radio Button Options
        // Male Radio Button
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='male']"));
        maleRadioButton.click();

        // Female Radio Button
        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='female']"));
        femaleRadioButton.click();

        // Days Check Box
        //Sunday
        WebElement sunday = driver.findElement(By.xpath("//input[@id='sunday']"));
        sunday.click();

        WebElement wednesday = driver.findElement(By.xpath("//input[@id='wednesday']"));
        wednesday.click();

        WebElement friday = driver.findElement(By.xpath("//input[@id='friday']"));
        friday.click();


    }

        @AfterTest
        public void closeBrowser() {
            driver.quit();
        }



}
