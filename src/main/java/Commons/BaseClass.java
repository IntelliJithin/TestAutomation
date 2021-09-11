package Commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import Utilities.ConfigFileReader;

public class BaseClass {

    public static WebDriver driver=null;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test=null;
    public static ConfigFileReader configFileReader;

    static {
        try {
            configFileReader = ConfigFileReader.ConfigReturn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beginReport() throws UnknownHostException {
        htmlReporter = new ExtentHtmlReporter("Reports//report.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Hostname", InetAddress.getLocalHost().getHostName());
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("Tester", "Jithin");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @BeforeMethod
    public static WebDriver openBrowser() {
        String url = configFileReader.get("URL3");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        return driver;

    }

    public static String takeScreenshot(WebDriver driver, String name) throws IOException, IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        String file = "image"+random.nextInt(1000)+".png";
        String filename = System.getProperty("user.dir")+"\\Reports\\" +file;
        FileUtils.copyFile(image, new File(filename));
        return file;
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }

    @AfterSuite
    public void endReport()
    {
        extent.flush();
    }

}
