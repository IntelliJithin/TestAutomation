package PageObjects;

import Commons.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class EditorPage extends BaseClass {

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

    public String getText() {

        String text = driver.findElement(By.id("tinymce")).getText();
        return text;

    }
}
