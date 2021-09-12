package PageObjects;

import Commons.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseClass {

    @FindBy(xpath = "//*[contains(text(), 'Click for JS Alert')]")
    private WebElement Alerts_JSAlert_Button;
    @FindBy(xpath = "//*[contains(text(), 'Click for JS Confirm')]")
    private WebElement Alerts_JSConfirm_Button;
    @FindBy(xpath = "//*[contains(text(), 'Click for JS Prompt')]")
    private WebElement Alerts_JSPrompt_Button;
    @FindBy(id = "result")
    private WebElement Alerts_JSAlert_Message_Text;
    @FindBy(id = "result")
    private WebElement Alerts_JSConfirm_Message_Text;
    @FindBy(id = "result")
    private WebElement Alerts_JSPrompt_Message_Text;

    public String getJSAlertMessage(){
        return Alerts_JSAlert_Message_Text.getText();
    }

    public String getJSConfirmMessage(){
        return Alerts_JSConfirm_Message_Text.getText();
    }

    public String getJSPromptMessage(){
        return Alerts_JSPrompt_Message_Text.getText();
    }

    public AlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickJSAlert() {
        Alerts_JSAlert_Button.click();
    }

    public void clickOK() {
        driver.switchTo().alert().accept();
    }

    public void clickJSConfirm() {
        Alerts_JSConfirm_Button.click();
    }

    public void clickCancel() {
        driver.switchTo().alert().dismiss();
    }

    public void clickJSPrompt() {
        Alerts_JSPrompt_Button.click();
    }

    public void enterInTheAlertBox() {
        driver.switchTo().alert().sendKeys("Adaptavist");
    }

}
