package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import authanticate.actionadriver.userActions;
import authenticate.base.projectBaseClass;
import authenticate.utility.logger;

public class AmazonLoginPage extends projectBaseClass {
	userActions action;
	  
	  @FindBy(xpath = "//input[@name='email']") WebElement enterUsername;
	  @FindBy(id = "continue") WebElement countinueButton;
	  @FindBy(xpath = "//input[@name='password']") WebElement enterPassWord;
	  @FindBy(id = "signInSubmit") WebElement singnButton;
	  
	  
	  
	  public AmazonLoginPage () {
		 action = new userActions();
		  PageFactory.initElements(getDriver(), this);
		  
	  }
	  
	  
	  public void titele() {
		action.getTitle(getDriver());
		action.switchToNewWindow(getDriver());
		getDriver().get("www.Flipcart.com");
	}
	  
	  
	  public void loinwithCredentials(String Phonenumber, String passWord ) throws Throwable {
		  Thread.sleep(2000);
		  action.type(enterUsername, Phonenumber);
		  logger.info("Entered the Username");
		  Thread.sleep(2000);
		  action.click(getDriver(), countinueButton);
		  Thread.sleep(5000);
		  action.type(enterPassWord, passWord);
		  logger.info("Entered the Password");
		  Thread.sleep(5000);
		  action.click(getDriver(), singnButton);
		  logger.info("Clicked on SingIn Button");
		  
		  Thread.sleep(5000);
		 
		  

		  
	}
}
