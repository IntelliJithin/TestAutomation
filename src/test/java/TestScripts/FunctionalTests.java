package TestScripts;

import Commons.BaseClass;
import PageObjects.AlertsPage;
import PageObjects.EditorPage;
import PageObjects.TablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FunctionalTests extends BaseClass {

    @Test
    public void editTextBox() {

        EditorPage editorPage = new EditorPage(driver);

        test = extent.createTest("Enter values to the text box");

        editorPage.enterText();
        Assert.assertTrue(editorPage.getText().contains("Adaptavist"));

    }

    @Test
    public void managingAlerts() {

        AlertsPage alertsPage = new AlertsPage(driver);

        test = extent.createTest("Managing a variety of alerts");

        alertsPage.clickJSAlert();
        alertsPage.clickOK();
        Assert.assertTrue(alertsPage.getJSAlertMessage().contains("You successfully clicked an alert"));

        alertsPage.clickJSConfirm();
        alertsPage.clickOK();
        Assert.assertTrue(alertsPage.getJSAlertMessage().contains("You clicked: Ok"));

        alertsPage.clickJSPrompt();
        alertsPage.enterInTheAlertBox();
        alertsPage.clickOK();
        Assert.assertTrue(alertsPage.getJSAlertMessage().contains("You entered: Adaptavist"));

    }

    @Test
    public void dataTable() {

        TablesPage tablesPage = new TablesPage(driver);

        test = extent.createTest("Sortable tables");

        ArrayList<String> initialList = tablesPage.getTableData();
        System.out.println(initialList);
        tablesPage.clickTableHeader();
        ArrayList<String> sortedList = tablesPage.getTableData();
        System.out.println(sortedList);

        Assert.assertNotSame(initialList, sortedList);


    }

}
