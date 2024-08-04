package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import authanticate.actionadriver.userActions;
import authenticate.base.projectBaseClass;
import authenticate.utility.logger;

public class HomeAndSearchPage extends projectBaseClass {
	userActions action;
	
	public HomeAndSearchPage() {
		action = new userActions();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']") WebElement searchBar;
	@FindBy(xpath = "//input[@id = 'nav-search-submit-button']") WebElement searchIConButton ;
	@FindBy(xpath = "//div[@class='nav-line-1-container']")WebElement UserName;
	@FindBy(xpath = "//img[@alt='Sponsored Ad - Apple iPhone 15 (128 GB) - Black']") WebElement selectProduct;
	
	
	
	public void SearchProduct(String productname) throws InterruptedException {
		action.type(searchBar, productname);
		action.click(getDriver(), searchIConButton);
		Thread.sleep(1000);
		
	}
	
	public ProductDetailsPage SelectTheProductFromSearch() throws InterruptedException {
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(getDriver(), selectProduct);
		logger.info("Selected Product");
		Thread.sleep(1000);
		action.click(getDriver(), selectProduct);
		Thread.sleep(5000);
		action.switchToNewWindow(getDriver());
		return new ProductDetailsPage();		
	}
	
	
}
