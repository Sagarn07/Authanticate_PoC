package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import authanticate.actionadriver.userActions;
import authenticate.base.projectBaseClass;

public class ProductDetailsPage extends projectBaseClass {
	userActions action;

	public ProductDetailsPage() {
		action = new userActions();
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[@id='productTitle']") WebElement titeleOfTheProduct;
	@FindBy(xpath = "//body[1]/div[4]/div[1]/div[3]/div[11]/div[17]/div[1]/div[1]/div[4]/div[1]/span[3]/span[2]/span[2]") WebElement priceOfTheProduct;
	@FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']" )WebElement addToCartButton;
	@FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']") WebElement goCartButton;
	@FindBy(xpath = "//span[@id='attach-sidesheet-checkout-button']") WebElement ProceedToCheckOutButton;

	public String extractTheProductname() {
		action.scrollByVisibilityOfElement(getDriver(), titeleOfTheProduct);
		String productmane = titeleOfTheProduct.getText();
		return productmane;

	}


	public String extractThePrice() {
		String productselling = priceOfTheProduct.getText();
		return productselling;

	}

	public void clickOnaddToCart() {
		action.scrollByVisibilityOfElement(getDriver(), addToCartButton);
		action.click(getDriver(), addToCartButton);

	}

	public AmazonCheckoutPage clickOnCheckOutButton() throws InterruptedException {
		Thread.sleep(5000);
		action.scrollByVisibilityOfElement(getDriver(), ProceedToCheckOutButton);
		action.click(getDriver(), ProceedToCheckOutButton);
		return new AmazonCheckoutPage();
	}


}
