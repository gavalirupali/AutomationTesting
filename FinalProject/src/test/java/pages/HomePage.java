package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.WebTestBase;
import utils.Utility;

public class HomePage extends WebTestBase {
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement dropDown;
	public HomePage() {
		
		 PageFactory.initElements(driver, this);
		 
	}

	public void selecdropdown(String term, String value) {
		
		dropDown.click();
		Utility.selectValue(dropDown,term,value);	
		
	}

}
