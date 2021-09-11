package PageObjects;

import Commons.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

public class TablesPage extends BaseClass {

    @FindBy(xpath = "//table[@id=\"table1\"]//tr[3]//td[4]")
    private WebElement Tables_DataTable_Table;

    public TablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getTableData(){
        System.out.println(Tables_DataTable_Table.getText());
    }

}
