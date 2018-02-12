package blablacarB13.tests.profile.personalInfo.personalInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import blablacarB13.POMLib.common.LoginPage;
import blablacarB13.POMLib.profile.profileInfo.PersonalInfoPage;
import blablacarB13.utilities.PropertiesOperation;
import blablacarB13.utilities.ScreenShotUtil;
import blablacarB13.utilities.UserDetails;

public class VerifyPersonalInfoPageDetails {
	WebDriver driver;
	
	// Launches Browser and logs into the application
	@BeforeMethod
	public void LaunchBrowserLogin(){
		PropertiesOperation config = new PropertiesOperation();
		System.setProperty(config.getRadicalValueBykey("geckoDriver"), config.getRadicalValueBykey("geckoloc"));
		driver = new FirefoxDriver();
		driver.get(config.getRadicalValueBykey("hostURL"));
		
		LoginPage login = new LoginPage();
		login.loginWithEmail(driver, "avdhut.kotkar@yahoo.com", "selenium@1793");
		
	}
	// Closes the browser
	@AfterMethod
	public void CloseBrowser(){
		driver.quit();
	}
	
	@Test (testName="Verify UI Elements on form")
	public void testPersonalInfoUI(){
		
		SoftAssert soft = new SoftAssert();
		PersonalInfoPage PersonalinfoPageObj = new PersonalInfoPage();
		LoginPage login = new LoginPage();
		login.loginWithEmail(driver, "avdhut.kotkar@yahoo.com", "selenium@1793");
		// 
		try{
		PersonalinfoPageObj.clickOnProfileTab(driver);
		//Verify UI Elements on Personal Info Tab
		soft.assertTrue(PersonalinfoPageObj.getPersonalInfoHeaderText(driver).equals("Your personal information"),"Header Field Content Not matching");
		
		soft.assertTrue(PersonalinfoPageObj.getUserGenderTypeValue(driver).equals("Male"),"Gender Field Text not matching..");
		soft.assertTrue(PersonalinfoPageObj.getFirstNameFieldText(driver).equals("First name"),"First Name Field Text not matching..");
		soft.assertTrue(PersonalinfoPageObj.getLastNameFieldText(driver).equals("Last name"),"Last Name Field Text not matching..");
		soft.assertTrue(PersonalinfoPageObj.getEmailFieldText(driver).equals("Email"),"Email field text not matching");
		soft.assertTrue(PersonalinfoPageObj.getMobNoFieldText(driver).equals("Mobile phone"),"Mobile Number field text not matching...");
		// Some of the Elements are pending
		}catch(Exception e){
			
			Reporter.log("Exception observed"+ e);
			soft.assertTrue(false);  // Mark Test Case Failed as there is exception
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
		}
		//Verifying All the asserts results and Sending Consolidated result
		soft.assertAll();
	}
			
}
