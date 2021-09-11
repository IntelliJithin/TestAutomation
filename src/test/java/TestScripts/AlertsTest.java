package TestScripts;

import Commons.BaseClass;
import PageObjects.AlertsPage;
import PageObjects.EditorPage;
import PageObjects.TablesPage;
import org.testng.annotations.Test;

public class AlertsTest extends BaseClass {

    @Test
    public void editTextBox() {

        EditorPage editorPage = new EditorPage(driver);

        test = extent.createTest("Enter values to the text box");

        editorPage.enterText();

    }

    @Test
    public void managingAlerts() {

        AlertsPage alertsPage = new AlertsPage(driver);

        test = extent.createTest("Managing a variety of alerts");

        alertsPage.clickJSAlert();
        alertsPage.clickOK();

        alertsPage.clickJSConfirm();
        alertsPage.clickOK();

        alertsPage.clickJSPrompt();
        alertsPage.enterInTheAlertBox();
        alertsPage.clickOK();

    }

    @Test
    public void dataTable(){

        TablesPage tablesPage = new TablesPage(driver);

        test = extent.createTest("Managing tables");

        tablesPage.getTableData();

    }

}
