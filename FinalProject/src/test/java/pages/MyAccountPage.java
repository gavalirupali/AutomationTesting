package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;
import utils.Utility;

public class MyAccountPage extends WebTestBase {
	
	@FindBy(xpath = "/html/body/footer/ul/li[3]")
    WebElement linkedinOption;
	
	public MyAccountPage () {
		PageFactory.initElements(driver, this);
	}
	

	public void scrollDownMethod() {
		// TODO Auto-generated method stub
		Utility.scrollDownByElement(driver,linkedinOption);
		linkedinOption.click();
		
	}	
	public void windowHandle(){
        Utility.scrollDownByElement(driver,linkedinOption);
        linkedinOption.sendKeys(Keys.ENTER);
        Utility.switchToWindows(driver);
    }
	public void getScreenshot() throws IOException {
		Utility.getScreenshot();
	}
	
	public void getBrokenLink() throws IOException {
		Utility.getBrokenLink();
	}
	
	public void getCookiesHandle() {
		// TODO Auto-generated method stub
		Utility.getCookies();
	}
}
