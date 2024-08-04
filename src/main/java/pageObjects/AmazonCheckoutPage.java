package pageObjects;

import org.apache.xmlbeans.impl.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import authanticate.actionadriver.userActions;
import authenticate.base.projectBaseClass;
import authenticate.utility.logger;

public class AmazonCheckoutPage extends projectBaseClass {
	userActions action;

	public AmazonCheckoutPage() {
		action = new userActions();
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id=\"shipToThisAddressButton\"]/span/input") WebElement useThisAdressButton;
	@FindBy(xpath = "//span[normalize-space()='Credit or debit card']") WebElement creditcardOpt;
	@FindBy(xpath = "/html/body/div[5]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[6]/div/div[3]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/div/div/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div/span/div/a") WebElement enroalCard;
	@FindBy(xpath = "//input[@name='addCreditCardNumber']") WebElement cardNumberinput;
	//@FindBy(xpath = "//input[@name='ppw-accountHolderName']") WebElement cardHolderName;
	@FindBy(xpath = "//select[@name='ppw-expirationDate_month']") WebElement cardMonthdropdown;
	@FindBy(xpath = "//select[@name='ppw-expirationDate_year']")WebElement cardYeardropdown;
	@FindBy(xpath ="//p[@class='a-spacing-small']") WebElement outSidedropdown;
	@FindBy(xpath = "//div[@class='a-row apx-add-card-buttons-in-popover apx-add-card-buttons-in-popover-align-right']") WebElement afterDetailsEnterButton;
	@FindBy(xpath = "Address_selectBillToThisAddress") WebElement saveadressPromt;
	@FindBy(xpath = "//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']") WebElement SavePaymentMethod;
	@FindBy(xpath = "/html/body/div[5]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[6]/div/div[3]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/div/div[1]/div[3]/div/div/div/div/div/div[2]/div[3]/div/div/div/div[1]/input[1]") WebElement cvvbox;
	@FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/span[2]/span")WebElement SavecardandCountinueButton;
	
	
	public void AdressSelction() throws InterruptedException {
		Thread.sleep(1000);
		action.click(getDriver(), useThisAdressButton);
		Thread.sleep(1000);
		action.switchToNewWindow(getDriver());
	}
	
	public void cardOption() throws InterruptedException {
		Thread.sleep(5000);
		action.scrollByVisibilityOfElement(getDriver(), creditcardOpt);
		
		action.click(getDriver(),creditcardOpt);
		logger.info("Click On CreditCardOpt");
		Thread.sleep(2000);
		action.click(getDriver(), enroalCard);
		logger.info("Click On Enroal Card");
		Thread.sleep(3000);
		action.switchToFrameByName(getDriver(), "ApxSecureIframe");
		//getDriver().switchTo().frame("ApxSecureIframe");
		Thread.sleep(2000);
		action.type(cardNumberinput, "4000000000001000");
		Thread.sleep(10000);
		WebElement cardHolderName = getDriver().findElement(By.xpath("//input[@name='ppw-accountHolderName']"));
		cardHolderName.clear();
		cardHolderName.sendKeys("your Name");
		Thread.sleep(2000);
		action.selectByValue(cardMonthdropdown, "4");
		action.click1(cardMonthdropdown, "4");
		Thread.sleep(2000);
		action.selectByValue(cardYeardropdown, "2026");
		action.click1(cardYeardropdown, "2026");
		logger.info("Filled the Card Details and Saved");
		Thread.sleep(2000);
		action.switchToDefaultFrame(getDriver());
		
		
	}
	
	
	
}
