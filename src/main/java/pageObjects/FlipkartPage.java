package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import authanticate.actionadriver.userActions;
import authenticate.base.projectBaseClass;
import authenticate.utility.logger;

public class FlipkartPage extends projectBaseClass{
	userActions action;
	
	
	public FlipkartPage() {
		action = new userActions();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@title ='Search for Products, Brands and More']")WebElement flikartSearchBar;
	@FindBy(xpath = "//button[@title ='Search for Products, Brands and More']")WebElement flikartSearchSubmitButton;
	@FindBy(xpath = "//img[@class=\"DByuf4\"][@alt='Apple iPhone 15 (Black, 128 GB)']") WebElement flikartSlectProduct;
	@FindBy(xpath = "//div[contains(text(),'Apple iPhone 15 (Black, 128 GB)')]") WebElement flipkartdeviceName;
	@FindBy(xpath = "//div[@class='Nx9bqj _4b5DiR']") WebElement flipkartdevicePrice;
	
	
	public void lanuchFlipKartAndSearchTheProduct() throws InterruptedException {
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		getDriver().get("https://www.flipkart.com");
		Thread.sleep(1000);
		action.type(flikartSearchBar, "iPhone 15");
		Thread.sleep(1000);
		action.click(getDriver(), flikartSearchSubmitButton);
		action.scrollByVisibilityOfElement(getDriver(), flikartSlectProduct);
	}
	
	public void SelectTheProductFromList() throws InterruptedException {
		action.click(getDriver(), flikartSlectProduct);
		Thread.sleep(2000);
		action.switchToNewWindow(getDriver());
		Thread.sleep(2000);
		
	}
	
	public String getTheFlipKartPrice() throws InterruptedException {
		Thread.sleep(5000);
		action.scrollByVisibilityOfElement(getDriver(), flipkartdevicePrice);
		String PriceOftheDeviceInFlipkart = flipkartdevicePrice.getText();
		logger.info("Device Price is " + PriceOftheDeviceInFlipkart);
		return PriceOftheDeviceInFlipkart;
	}
	
	public String getTheFlipKartProductName() throws InterruptedException {
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(getDriver(), flipkartdeviceName);
		String NameOftheDeviceInFlipkart = flipkartdeviceName.getText();
		logger.info("Device Name is " + NameOftheDeviceInFlipkart);
		return NameOftheDeviceInFlipkart;
	}
	
}
