package testCase;

import pages.HomePage;

import pages.LoginPage;
import pages.MyAccountPage;
import testBase.WebTestBase;

import java.io.IOException;

import org.testng.annotations.*;
import org.testng.asserts.*;
import org.openqa.selenium.JavascriptExecutor;


public class TC01 extends WebTestBase{
	LoginPage loginpage;
	HomePage  homepage;
	MyAccountPage myaccountpage;
	
public TC01() {
	super();
	
}
@BeforeMethod
public void BeforeMethod() {
	initialization();
	loginpage=new LoginPage();
	homepage =new HomePage();
	myaccountpage =new MyAccountPage();

}

@Test (priority=1)
public void consolePrint()
{
	System.out.println("This is Automation Testing Project");
}

@Test(priority=2)
public void verifylogin() {
	SoftAssert softAssert = new SoftAssert();
	loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
    softAssert.assertAll();

}


@Test(priority=3)
public void dropdownmethod() {
	SoftAssert softAssert = new SoftAssert();
	loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	homepage.selecdropdown("byVisibleText", "Price (low to high)");
	softAssert.assertAll();
	}

@Test(priority=4)
public void verifyScrollDown() {
	JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
	javascriptExecutor.executeScript("window.scrollBy(0,2000)");
}
@Test(priority=5)
public void verifyScrollup() {
	JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
	javascriptExecutor.executeScript("window.scrollBy(0,2000)");
}
@Test(priority=6)
 public void verifyScreenshot() throws IOException{
     SoftAssert softAssert = new SoftAssert();
     myaccountpage.getScreenshot();
     softAssert.assertAll();
 }
//@Test(priority=7)  
// public void verifyGetWindowHandle(){
//     SoftAssert softAssert = new SoftAssert();
//     myaccountpage.windowHandle();
//     softAssert.assertAll();
// }

@Test(priority=7)  
public void verifyCookiesHandle(){
     SoftAssert softAssert = new SoftAssert();
     myaccountpage .getCookiesHandle();
     softAssert.assertAll();
 }
@Test(priority=8)
 public void verifyBrokenLink() throws IOException{
     SoftAssert softAssert = new SoftAssert();
     myaccountpage.getBrokenLink();
     softAssert.assertAll();
 }


@AfterMethod
public void AfterMethod() {
	driver.close();
}


}
