package PageObjects;

import Commons.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablesPage extends BaseClass {

    @FindBy(xpath = "//table[@id=\"table1\"]//thead//tr//th[1]")
    private WebElement DataTable_Table1_LastNameHeader_SortableTable;
    @FindBy(xpath = "//table[@id=\"table1\"]//tbody//td[1]")
    private List<WebElement> DataTable_Table1_LastNameList_SortableTable;

    public TablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTableHeader() {
        DataTable_Table1_LastNameHeader_SortableTable.click();
    }

    public ArrayList<String> getTableData() {

        List<WebElement> LastNameList = DataTable_Table1_LastNameList_SortableTable;
        ArrayList<String> tableValues = new ArrayList<>();
        for (int i = 0; i < LastNameList.size(); i++) {
            String str = LastNameList.get(i).getText();
            tableValues.add(str);
        }

        return tableValues;
    }
}
