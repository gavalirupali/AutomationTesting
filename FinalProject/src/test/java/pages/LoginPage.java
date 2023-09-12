package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;

public class LoginPage extends WebTestBase {
	
	@FindBy(xpath="//*[@id=\"user-name\"]")
	WebElement username ;

	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password ;
	
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement loginbutton ;
	

public LoginPage() {
    PageFactory.initElements(driver, this);
	
}
public void Login(String un , String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbutton.click();
	
	
	
}
}

