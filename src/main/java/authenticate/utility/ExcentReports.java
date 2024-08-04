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
      
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/" + "TestReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
       // extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "AuthanticatePoc");
        extent.setSystemInfo("Tester", "Sagar N");
       // extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush();
    }
}