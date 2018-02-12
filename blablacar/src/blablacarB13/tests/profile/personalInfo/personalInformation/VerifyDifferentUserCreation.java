package blablacarB13.tests.profile.personalInfo.personalInformation;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import blablacarB13.POMLib.common.HeaderPage;
import blablacarB13.POMLib.common.LoginPage;
import blablacarB13.POMLib.profile.profileInfo.PersonalInfoPage;
import blablacarB13.utilities.PropertiesOperation;
import blablacarB13.utilities.ReadExcelSheet;
import blablacarB13.utilities.ScreenShotUtil;


public class VerifyDifferentUserCreation {
	WebDriver driver;
	
	@BeforeMethod
	public void LuanchBrowser(){ 
		PropertiesOperation config = new PropertiesOperation();
		System.setProperty(config.getRadicalValueBykey("geckoDriver"), config.getRadicalValueBykey("geckoloc"));
		driver = new FirefoxDriver();
		driver.get(config.getRadicalValueBykey("hostURL"));
	}
	@AfterMethod
	public void CloseBrowser(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@DataProvider (name="userDetails")
	public Object[][] userdetails1(){
		ReadExcelSheet readExcel = new ReadExcelSheet("D:\\Eclipse_WorkSpace\\blablacar\\src\\blablacarB13\\testdata\\profile\\profileInfo\\personalInformation\\VerifyDifferentUserCreation.xlsx");
		int rowCount = readExcel.getRowCount(0);
		int columnCount = readExcel.getColumnCount(0);
		Object[][] obj = new Object[rowCount][columnCount];
		
		// Getting data and storing in the Array
		for (int i = 0; i < rowCount ; i++) {
			for (int j = 0; j < columnCount; j++) {
				obj[i][j]= readExcel.getCellData(0, i, j);
			}
		}
		return obj;
	}
	
	@Test (dataProvider="userDetails")
	public void testUserDetailsOnForm(String userName , String pass , String gender, String firstName , String lastName, String email,String mobileNo){
		// Log in to the Application
		LoginPage log = new LoginPage();
		log.loginWithEmail(driver, userName, pass);
		
		PersonalInfoPage PIpage = new PersonalInfoPage();
		SoftAssert soft = new SoftAssert();
		
		// Verify Logged in User's Details from Excel Sheet Data
		try{
			HeaderPage hpage = new HeaderPage();
			hpage.navigateToProfile(driver);
			
			//PIpage.clickOnProfileTab(driver);
			soft.assertTrue(PIpage.getUserGenderTypeValue(driver).equals(gender),"Gender is not as expected : ");
			soft.assertTrue(PIpage.getUserFirstNameValue(driver).equals(firstName),"First Name is not as expected : ");
			soft.assertTrue(PIpage.getUserLastNameValue(driver).equals(lastName),"last Name is not as expected : ");
			soft.assertTrue(PIpage.getUserEmailValue(driver).equals(email),"mail ID is not as expected : ");
			soft.assertTrue(PIpage.getUserMobileNoValue(driver).equals(mobileNo),"Mobile Number is not as expected : ");
			String ExpectedCountryCode ="India (+91)";
			soft.assertTrue(PIpage.getCountryCodeSelectedInListBox(driver).equals(ExpectedCountryCode),"Country code is not as expected"); ;
			
		}catch(Exception e){
			Reporter.log("Exception observed"+ e);
			soft.assertTrue(false);  // Mark Test Case Failed as there is an Exception
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
		}
		
		soft.assertAll();  // making status pass or fail with consolidated status
		
	}
}
