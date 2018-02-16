package blablacarB13.POMLib.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import blablacarB13.POMLib.dashboard.DashBoardPage;
import blablacarB13.utilities.WindowOperations;

public class LoginPage {
	
	String userNameLoc = "//input[@type='email']";
	String userPwdLoc = "//input[@type='password']";
	String loginBtnLoc = "//button[@type='submit']";
	String continueWithFaceBookBtnLoc = "//span[contains(text(),'Continue with Facebook')]";
	String continueWithEmailBtnLoc ="//span[contains(text(),'Continue with email')]";
	String FbLoginError = "//div/div[contains(text(),'Incorrect email address or phone number')]";
	
	
	//Login With FB UI Elements
	String FbUsreNameloc = "//input[@id='email']";
	String FbPwdloc = "//input[@id='pass']";
	String FbLoginBtnLoc = "//input[@name='login']";
	
	public void clickUserName(WebDriver driver){
		Reporter.log("Clicking on UserName TextBox");
		driver.findElement(By.xpath(userNameLoc)).click();
	}
	public void clearTextUserName(WebDriver driver){
		Reporter.log("Clearing UserName TextBox Content");
		driver.findElement(By.xpath(userNameLoc)).clear();
	}
	public void enterTextUserName(WebDriver driver, String userName){
		Reporter.log("Entering in UserName TextBox");
		driver.findElement(By.xpath(userNameLoc)).sendKeys(userName);
	}
	public boolean isPresentUserName(WebDriver driver){
		return driver.findElement(By.xpath(userNameLoc)).isDisplayed();
	}
	public void enterTextUserPwd(WebDriver driver, String userPwd){
		Reporter.log("Entering in UserPassword TextBox");
		driver.findElement(By.xpath(userPwdLoc)).sendKeys(userPwd);
	}
	
	public void clickLoginBtn(WebDriver driver){
		Reporter.log("Clicking on Login Button on Login Form");
		driver.findElement(By.xpath(loginBtnLoc)).click();
	}
	
	public void clickfaceBookBtnLoc(WebDriver driver){
		Reporter.log("Clicking on Connect With FaceBook on Login Form");
		driver.findElement(By.xpath(continueWithFaceBookBtnLoc)).click();
	}

	public boolean isFaceBookBtnLocVisible(WebDriver driver){
		Reporter.log("checking if Connect With FaceBook is present on Login Form");
		return driver.findElement(By.xpath(continueWithFaceBookBtnLoc)).isDisplayed();
	}
	
	public void clickContinueWithEmail(WebDriver driver){
		Reporter.log("Clicking on Continue with Email on Login Page");
		driver.findElement(By.xpath(continueWithEmailBtnLoc)).click();
	}
	
	public void WaitUntilFBLoginWindowLoaded(WebDriver driver){
		Reporter.log("Waiting Until FB Window loaded");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FbUsreNameloc)));		
	}
	
	public void enterTextFbUserName(WebDriver driver, String fbUserName){
		Reporter.log("Entering in FB UserName TextBox");
		driver.findElement(By.xpath(FbUsreNameloc)).sendKeys(fbUserName);
	}
	
	
	public void enterTextFbUserPwd(WebDriver driver, String fbUserpwd){
		Reporter.log("Entering in FB UserPwd TextBox");
		driver.findElement(By.xpath(FbPwdloc)).sendKeys(fbUserpwd);
	}
	
	public void clickFBLoginBtn(WebDriver driver){
		Reporter.log("Clicking on Login button on FB Login Window");
		driver.findElement(By.xpath(FbLoginBtnLoc)).click();
	}
	
	public boolean isFbLoginErrorVisible(WebDriver driver){
		Reporter.log("Checking Log in Failed Message");
		return driver.findElement(By.xpath(FbLoginError)).isDisplayed();
	}
	
	public void loginWithEmail(WebDriver driver, String userName, String userPwd){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
		HeaderPage headerObj = new HeaderPage();
		headerObj.clickOnSignIn(driver);
		clickContinueWithEmail(driver);
		enterTextUserName(driver, userName);
		enterTextUserPwd(driver, userPwd);
		clickLoginBtn(driver);
		try{
			headerObj.clickOnSignIn(driver);
		}catch(Exception e){
			Reporter.log("Log in Successfull");
		}
		
		}catch(Exception e){
			Reporter.log("Login Failed");
		}
	}
	
	public void LoginWithFB(WebDriver driver, String userName, String userPwd){
		
	}

	
	
}
