package PageObjects;

import Commons.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditorPage extends BaseClass {

    @FindBy(id = "//iframe[@id=\"mce_0_ifr\"]")
    private WebElement Editor_IFrame_TextBox;
    @FindBy(id = "//body[@id=\"tinymce\"]")
    private WebElement Editor_Body_TextBox;

    public EditorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterText() {
        driver.switchTo().frame(0);
        WebElement webElement = driver.switchTo().activeElement();
        new Actions(driver).moveToElement(webElement).perform();
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Adaptavist");
    }
}
