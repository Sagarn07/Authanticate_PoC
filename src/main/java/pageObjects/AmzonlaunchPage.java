package pageObjects;

import java.sql.DriverAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import authanticate.actionadriver.userActions;
import authenticate.base.projectBaseClass;
import authenticate.utility.logger;
import freemarker.core.ReturnInstruction.Return;

public class AmzonlaunchPage extends projectBaseClass {
	userActions action;
	logger log;



	@FindBy(id = "nav-link-accountList") WebElement loginButton;



	public AmzonlaunchPage () {
		action = new userActions();
		PageFactory.initElements(getDriver(), this);
		log = new logger();
	}



	public String applicationTittle() {
		String pageTitle = action.getTitle(getDriver());
		return pageTitle;
		

	} 
	public AmazonLoginPage clickOnsingIn() throws InterruptedException {
		action.click(getDriver(), loginButton);
		Thread.sleep(2000);
		logger.info("Clicked On Singin Button");
		return new AmazonLoginPage();
	}
	
	public void lunchpflipkart() {
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		getDriver().get("https://www.flipkart.com/");
		
	
	}
	


}
