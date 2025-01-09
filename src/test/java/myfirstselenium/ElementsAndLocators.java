package myfirstselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ElementsAndLocators {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }


    @Test
    public void LocatorsTests(){

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


        // 1. Handle Input Field
        WebElement nameField = driver.findElement(By.id("field1"));
        nameField.clear();
        nameField.sendKeys("Test Automation");

        // 2. Click Button
        WebElement copyButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        copyButton.click();

        // 3. Interact with Dropdown
        WebElement dropdown = driver.findElement(By.id("animals"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText("Baby Cat");

        // 4. Handle Alert
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'Click Me')]"));
        alertButton.click();
        driver.switchTo().alert().accept();


        // 5. Handle Date Picker
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.click();
        WebElement date = driver.findElement(By.xpath("//a[text()='15']")); // Select the 15th
        date.click();

        // 6. Interact with Table
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        for (WebElement row : tableRows) {
            System.out.println(row.getText());
        }

        // 7. Handle Frames
        driver.switchTo().frame("frame-one1434677811");
        WebElement frameInput = driver.findElement(By.id("RESULT_TextField-1"));
        frameInput.sendKeys("Frame Input");
        driver.switchTo().defaultContent();

        // 8. Double Click Action
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        driver.switchTo().alert().accept();

        // 9. Drag and Drop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();

        // 10. Handle Radio Button
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
        radioButton.click();

        // 11. Handle Checkboxes
        WebElement checkBox1 = driver.findElement(By.xpath("//label[text()='Automation']//preceding-sibling::input"));
        WebElement checkBox2 = driver.findElement(By.xpath("//label[text()='Performance']//preceding-sibling::input"));
        checkBox1.click();
        checkBox2.click();

        // Print success message
        System.out.println("All elements interacted successfully!");

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }








}
