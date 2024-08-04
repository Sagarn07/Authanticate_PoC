package authenticate.utility;

import java.io.IOException;

import com.aventstack.extentreports.reporter.ExtentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExcentReports {

	public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    public static void setExtent() throws IOException {
        // Use the correct class for HTML reporter
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/" + "TestReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        
        // Uncomment and configure as needed
        // htmlReporter.config().setDocumentTitle("Automation Test Report");
        // htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
        // htmlReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyStoreProject");
        extent.setSystemInfo("Tester", "Sagar N");
       // extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush();
    }
}