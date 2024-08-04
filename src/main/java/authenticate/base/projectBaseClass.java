package authenticate.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.ExtentReporter;

import authenticate.utility.ExcentReports;
import authenticate.utility.logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class projectBaseClass {
	public static Properties prop;

	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	@BeforeSuite(groups = { "SmokeTest", "RegressionTest", "SanityTest" })

	
	public void loadConfig() throws IOException {
        Configurator.initialize(null, "log4j.xml");
        ExcentReports.setExtent();
    
		try {
			prop = new Properties();
			FileInputStream confiFile = new FileInputStream(
					System.getProperty("user.dir") + "\\ConfigProperty.properties\\ProjectProperty.Properties");
			prop.load(confiFile);
			
			}catch(Exception exp) {
				System.out.println(exp.getMessage());
				exp.printStackTrace();
			}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	

	
	public  void lunchBrowerserAndMaximize(String browser) {
		WebDriverManager.chromedriver().setup();
		String url = prop.getProperty("ProjectUrl");
		
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}else if (browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			
		}
		getDriver().manage().window().maximize();
		getDriver().get(url);
		
	}
	
	@AfterSuite
	public void Aftersuit() {
		ExcentReports.endReport();
	}
 
	
}
