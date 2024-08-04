package authenticate.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.github.dockerjava.api.model.Driver;

import authenticate.base.projectBaseClass;
import authenticate.utility.logger;
import dataProvider.InputTestDataFromExcel;
import io.reactivex.rxjava3.functions.Action;
import pageObjects.AmazonCheckoutPage;
import pageObjects.AmazonLoginPage;
import pageObjects.AmzonlaunchPage;
import pageObjects.FlipkartPage;

import pageObjects.HomeAndSearchPage;
import pageObjects.ProductDetailsPage;

public class AllTestCases extends projectBaseClass {
	AmzonlaunchPage lunchScreen;
	AmazonLoginPage homeScreen;
	HomeAndSearchPage searchScreen;
	ProductDetailsPage searchedProductPage;
	AmazonCheckoutPage CheckOut;
	FlipkartPage flipkart;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		lunchBrowerserAndMaximize(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
@Test (groups  = {"SmokeTest", "RegressionTest"}) // (dataProvider = "testdata" , dataProviderClass = InputTestDataFromExcel.class) (groups = "SmokeTest")
public void TC002_Login_to_Application() throws Throwable {
	logger.startTestCase("TC002_Login_to_Application");
	lunchScreen = new AmzonlaunchPage();
	logger.info("SuccessFully Clicked the the Url");
	homeScreen = lunchScreen.clickOnsingIn();
	homeScreen.loinwithCredentials("9066353121","Sagar@2508");
	logger.info("Sucessfully loggedIn with valid credentilas");
	logger.endTestCase("TC002_Login_to_Application");
	 }
@Test (groups = {"SmokeTest", "SanityTest" })	
public void TC01_Verify_Tittle_Onlaunch() {
	logger.startTestCase("TC01_Verify_Tittle_Onlaunch");
	lunchScreen = new AmzonlaunchPage();
	logger.info("Successfuly lunched the Page");
	String resultTittle = lunchScreen.applicationTittle();
	assertEquals(resultTittle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon");
	logger.endTestCase("TC01_Verify_Tittle_Onlaunch");
}

@Test (groups = "RegressionTest")
public void TC03_SearchProduct() throws Throwable {
	logger.startTestCase("TC03_SearchProduct");
	TC002_Login_to_Application();
	Thread.sleep(5000);
	searchScreen = new HomeAndSearchPage();
	searchScreen.SearchProduct("iphone 15");
	searchScreen.SelectTheProductFromSearch();
	logger.endTestCase("TC03_SearchProduct");
}

@Test (groups = "RegressionTest")
public void TC04_VerifytheProductDetails() throws Throwable {
	logger.startTestCase("TC04_VerifytheProductDetails");
	TC002_Login_to_Application();
	Thread.sleep(5000);
	searchScreen = new HomeAndSearchPage();
	searchScreen.SearchProduct("iphone 15");
	searchScreen.SelectTheProductFromSearch();
	searchedProductPage = new  ProductDetailsPage();
	String ecxproductPrice = searchedProductPage.extractThePrice();
	String ecxproductTittle = searchedProductPage.extractTheProductname();
	System.out.println("Product Price :-" +ecxproductPrice);
	System.out.println("Product Name :-"+ecxproductTittle);
	logger.endTestCase("TC04_VerifytheProductDetails");

}

@Test (groups = {"RegressionTest","SmokeTest"})
public void TC05_endtoend_login_To_PaymentMethod() throws Throwable{
	logger.startTestCase("TC05_endtoend_login_To_PaymentMethod");
	TC002_Login_to_Application();
	Thread.sleep(5000);
	searchScreen = new HomeAndSearchPage();
	searchScreen.SearchProduct("iphone 15");
	searchScreen.SelectTheProductFromSearch();
	searchedProductPage = new  ProductDetailsPage();
	searchedProductPage.clickOnaddToCart();
	Thread.sleep(5000);
	searchedProductPage.clickOnCheckOutButton();
	Thread.sleep(5000);
	CheckOut = new AmazonCheckoutPage();
	CheckOut.AdressSelction();
	Thread.sleep(2000);
	CheckOut.cardOption();
	logger.endTestCase("TC05_endtoend_login_To_PaymentMethod");
	
	
}

@Test (groups = "RegressionTest")
public void amzProductComparewithFlipkart() throws Throwable {
	TC002_Login_to_Application();
	logger.startTestCase("amzProductComparewithFlipkart");
	Thread.sleep(10000);
	searchScreen = new HomeAndSearchPage();
	searchScreen.SearchProduct("iphone 15");
	searchScreen.SelectTheProductFromSearch();
	searchedProductPage = new  ProductDetailsPage();
	String AmazonProductPrice = searchedProductPage.extractThePrice();
	String AmazonproductTittle = searchedProductPage.extractTheProductname();
	System.out.println("Amazon Product Price :-  " +AmazonProductPrice);
	System.out.println("Amazon Product Name :-  "+ AmazonproductTittle);
	flipkart = new FlipkartPage();
	flipkart.lanuchFlipKartAndSearchTheProduct();
	String FlipkartProductPrice = flipkart.getTheFlipKartPrice();
	String FlipkartProductTittle = flipkart.getTheFlipKartProductName();
	System.out.println("FlipKart Product Price :-  " +FlipkartProductPrice);
	System.out.println("FlipKart Product Name :-  "+ FlipkartProductTittle);
	
	String replacedFlipPrice = FlipkartProductPrice.replaceAll("[^\\d]", "");
	int newFlipkartPrice = Integer.parseInt(replacedFlipPrice);
	
	String replacedAmzPrice = AmazonProductPrice.replaceAll("[^\\d]", "");
	int newAmazonPrice = Integer.parseInt(replacedAmzPrice);
	

	if (newAmazonPrice < newFlipkartPrice ) {
		int DifPrice = newFlipkartPrice-newAmazonPrice;
		System.out.println("Selling Price of In Amazon is  ₹ " +DifPrice + " Lesser Than Flipkart");
	}else if (newAmazonPrice > newFlipkartPrice) {
		int DifPrice = newAmazonPrice-newFlipkartPrice;
		System.out.println("Selling Price of The Product In Flipkart is  ₹ " +DifPrice + " Lesser Than Amazon");
	}else {
		System.out.println("In Amazon and Flipkart Product Price is Same");
	}
	logger.endTestCase("amzProductComparewithFlipkart");

	
}
	
}
