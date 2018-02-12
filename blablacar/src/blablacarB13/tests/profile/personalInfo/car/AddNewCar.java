package blablacarB13.tests.profile.personalInfo.car;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import blablacarB13.POMLib.common.HeaderPage;
import blablacarB13.POMLib.common.LoginPage;
import blablacarB13.POMLib.profile.ProfilePage;
import blablacarB13.POMLib.profile.profileInfo.car.CarPage;
import blablacarB13.utilities.PropertiesOperation;
import blablacarB13.utilities.ScreenShotUtil;
import blablacarB13.utilities.WaitUtil;

public class AddNewCar {
	WebDriver driver;
	@BeforeMethod
	public void LoginAndNavigateToCar(){
		PropertiesOperation prop = new PropertiesOperation();
		System.setProperty(prop.getRadicalValueBykey("geckoDriver"), prop.getRadicalValueBykey("geckoloc"));
		driver = new FirefoxDriver();
		driver.get(prop.getRadicalValueBykey("hostURL"));
		LoginPage logIn = new LoginPage();
		logIn.loginWithEmail(driver, "avdhut.kotkar@yahoo.com", "selenium@1793");
		HeaderPage header = new HeaderPage();
		header.navigateToProfile(driver);
		ProfilePage prof = new ProfilePage();
		prof.ClickOnCarCat(driver);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
	
	@Test
	public void addNewCarValidDetails() throws InterruptedException{
		boolean testcaseRes=true;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		CarPage car = new CarPage();
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		
		try{
			
			if(car.isAddNewCarBtnVisible(driver)){
				car.clickOnAddNewCarBtn(driver);
			}
			
			car.setNumberPlateTextBoxValue(driver, "MH 12 PC3640");
			car.clickOnContinueBtn(driver);
			
		    //Enter Car makerDetails
			car.enterValueInSearchBoxCarMaker(driver, "HYU");
			car.selectCarMaker(driver, "HYUNDAI");
			
			//Enter Car Model details
			car.enterValueInSearchBoxCarModel(driver, "Grand");
			car.selectCarModel(driver, "Grand i10");
			
			//Select Car Body Type
			car.selectCarType(driver, "Hatchback"); 
			
			//Select Car Color
			car.selectCarColor(driver, "Red");
			
			//Enter Manufacturing Year
			car.enterManufacturingYear(driver, "2017");
			
			//Submit
			car.clickOnSubmitBtn(driver);
			
		}catch(Exception e ){
			Thread.sleep(3000);
			testcaseRes= false;
			Reporter.log("Exception in test case..."+e);
			ScreenShotUtil src = new ScreenShotUtil();
			src.getMyScreenShot(driver);
		}
		Assert.assertTrue(testcaseRes);
	}
	
	public void deleteCar(){
		
	}
	

}
