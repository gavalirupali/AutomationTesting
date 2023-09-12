package utils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import javax.net.ssl.HttpsURLConnection;

import testBase.WebTestBase;
import java.net.URL;

public class Utility  extends WebTestBase{
	public Utility() {
		PageFactory.initElements(driver, this);
	}

	public static void selectValue(WebElement Element, String term, String value) {
		// TODO Auto-generated method stub
		Select dropDown = new Select(Element);
		if(term.equalsIgnoreCase("byValue")) //ignore letter cases 
		{
            dropDown.selectByValue(value);
            
        }else if(term.equalsIgnoreCase("byIndex"))
        {
            dropDown.selectByIndex(Integer.parseInt(value));
            
        }else if(term.equalsIgnoreCase("byVisibleText"))
        {
            dropDown.selectByVisibleText(value);
            
        }else
        {
            System.out.println("Please select the correct value");
        }
	}
	

	public static void getScreenshot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		//taking screenshot and storing it in the temporary file
		File source=tk.getScreenshotAs(OutputType.FILE);
		//creating destination file
		//File des=new File("D:/nurserylive.png");"./screenshots/" + fileName
		File des=new File("./screenshot/saucedemo.png");
		//moving the file from source to destination
		FileUtils.copyFile(source,des);
		
	}
	public static void scrollDownByElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
	
	public static void scrollUp(WebDriver driver) {
		
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(0,800)");
		javascriptExecutor.executeScript("window.scrollBy(0,-800)");
	}
	
	public static void switchToWindows(WebDriver driver) {
        String parentWindows = driver.getWindowHandle();//parent Id==1
        Set<String> allWindow = driver.getWindowHandles();//Parent+child<1,2>
        for (String s : allWindow) {
        	//child Id
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
                driver.close();
            }
           
        }
        driver.switchTo().window(parentWindows);
    }
	
	public static void getBrokenLink() throws IOException {
		URL url=new URL("https://www.saucedemo.com/v1/");
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		
		int code=con.getResponseCode();
		System.out.println(code);
		
		String msg=con.getResponseMessage();
		System.out.println(msg);
	}
public static void getCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies){
            System.out.println(c);
        }
    }
}
