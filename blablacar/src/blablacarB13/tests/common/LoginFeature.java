package blablacarB13.tests.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import blablacarB13.POMLib.common.HeaderPage;
import blablacarB13.POMLib.common.LoginPage;
import blablacarB13.POMLib.dashboard.DashBoardPage;
import blablacarB13.utilities.PropertiesOperation;
import blablacarB13.utilities.ScreenShotUtil;
import blablacarB13.utilities.WindowOperations;

public class LoginFeature {
	WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser(){
		PropertiesOperation config = new PropertiesOperation();
		System.setProperty(config.getRadicalValueBykey("geckoDriver"), config.getRadicalValueBykey("geckoloc"));
		driver = new FirefoxDriver();
//		System.setProperty(config.getRadicalValueBykey("chromedriver"), config.getRadicalValueBykey("chromedriverloc"));
//		driver = new ChromeDriver();
		
		driver.get(config.getRadicalValueBykey("hostURL"));
	}

	@AfterMethod
	public void CloseBrowser(){
		driver.quit();
	}
	
	@Test(priority=1)
	public void logInwithFacebookValidDetails(){
		boolean testCaseRes = true;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		
		WindowOperations winOP = new WindowOperations();
		
		HeaderPage headerobj = new HeaderPage();
		//click on Login Button
		headerobj.clickOnSignIn(driver);
		LoginPage loginPopUpObj = new LoginPage();
		//Click on Facebook Button
		
		if(loginPopUpObj.isFaceBookBtnLocVisible(driver)){
			loginPopUpObj.clickfaceBookBtnLoc(driver);
		}

		// Set driver control to Child window
		String parentWin = driver.getWindowHandle();
		String childWin = winOP.getNewlyOpenedWinID(driver, parentWin);
		winOP.setCurrentWin(driver, childWin);
		
		//Entering FB Details
		loginPopUpObj.WaitUntilFBLoginWindowLoaded(driver);
		
		loginPopUpObj.enterTextFbUserName(driver, "avdhut.kotkar");
		loginPopUpObj.enterTextFbUserPwd(driver, "avdhut@1793");
		loginPopUpObj.clickFBLoginBtn(driver);
		
		winOP.setCurrentWin(driver, parentWin);
		
		DashBoardPage DashObj = new DashBoardPage();
		DashObj.isDashboardTabVisible(driver);
	
		}catch (Exception e){
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
			Reporter.log("Test Case Failed  because of : "+e);
			testCaseRes = false;
		}
		
		// reporting test case Passed or Failed
		Assert.assertTrue(testCaseRes);
	}
		
	@Test(priority=3)
	public void logInwithFacebookInvalidDetails(){

		boolean testCaseRes = true;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		
		WindowOperations winOP = new WindowOperations();
		
		HeaderPage headerobj = new HeaderPage();
		//click on Login Button
		headerobj.clickOnSignIn(driver);
		LoginPage loginPopUpObj = new LoginPage();
		//Click on Facebook Button
		
		if(loginPopUpObj.isFaceBookBtnLocVisible(driver)){
			loginPopUpObj.clickfaceBookBtnLoc(driver);
		}
		
		// Set driver control to Child window
		String parentWin = driver.getWindowHandle();
		String childWin = winOP.getNewlyOpenedWinID(driver, parentWin);
		winOP.setCurrentWin(driver, childWin);
		
		//Entering FB Details
		loginPopUpObj.WaitUntilFBLoginWindowLoaded(driver);
		
		loginPopUpObj.enterTextFbUserName(driver, "invalid");
		loginPopUpObj.enterTextFbUserPwd(driver, "avdhut@1793");
		loginPopUpObj.clickFBLoginBtn(driver);
		if (driver.getWindowHandles().size()>1){
			testCaseRes = loginPopUpObj.isFbLoginErrorVisible(driver);
		}else{
			winOP.setCurrentWin(driver, parentWin);
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
			testCaseRes = false;
		}
				
		}catch (Exception e){
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
			Reporter.log("Test Case Failed  because of : "+e);
			testCaseRes = false;
		}
		
		// reporting test case Passed or Failed
		Assert.assertTrue(testCaseRes);
		
	}
	
	@Test (priority=2)
	public void logInwithUserDetails(){
		boolean testCaseResult = true;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HeaderPage obj = new HeaderPage();
		obj.clickOnSignIn(driver);
		DashBoardPage dash = new DashBoardPage();
		try{
		LoginPage login = new LoginPage();
		login.enterTextUserName(driver, "avdhut.kotkar@yahoo.com");
		login.enterTextUserPwd(driver, "selenium@1793");
		login.clickLoginBtn(driver);
		
		}catch(Exception e){
			testCaseResult = false;
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
		}
		Assert.assertTrue(dash.isDashboardTabVisible(driver) && testCaseResult);
	}
}


