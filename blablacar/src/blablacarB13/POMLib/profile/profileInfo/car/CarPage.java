package blablacarB13.POMLib.profile.profileInfo.car;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import blablacarB13.utilities.ListBoxUtil;
import blablacarB13.utilities.WebElementUtil;

public class CarPage {
	WebElementUtil webUtil = new WebElementUtil();
	WebDriverWait wait;
	
	//Common Controls on all Car Page contents
	String headerTitlecontentLoc = "//div/h1";
	String backButtonLoc = "//div/a[@class='js-step-prev']";
	
	//Number Plate Page
	String countryListBoxLoc ="//select[@id='vehicle_vehicle_license_plate_country_code']";
	String numberPlateTextBoxLoc ="//input[@id='vehicle_vehicle_license_plate_number']";
	String skiptNumberPlateButtonLoc ="//label[@for='skip-license-plate']";
	String continueButton = "//button[contains(text(),'Continue')]";
	String addNewCarbtnloc = "//a[contains(text(),'Add a car')]";
	
	//	//Car Maker add Page
	String searchBoxCarMaker = "//div/label[@for='searchMakes' and @class='c-input-field']";
	
	//Car Model add page
	String searchBoxCarModel = "//div/label[@for='searchModels' and @class='c-input-field']";
	
	//Car Type Page	
	private String carTypeLocGenerator(String carType){
		return "//fieldset[@id='step_vehicle_type']//span[contains(text(),'"+carType+"')]";
	}
	//Car Color Page
	private String carColorLocGenerator(String carColor){
		return "//fieldset[@id='step_vehicle_color']//span[contains(text(),'"+carColor+"')]";
	}
	//generated using private methods and Xpath is embedded here..
	
	//Manfacturing year details page
	String MnaufacturingYearTextBoxLoc = "//input[@id='vehicle_vehicle_registration_year']";
	String submitBtnLoc = "//button[@id='vehicle_vehicle_submit']";
	
// All Methods for Car Pages
	
	public String getHeaderContent (WebDriver driver){
		Reporter.log("Returning Car Page header Content");
		return driver.findElement(By.xpath(headerTitlecontentLoc)).getText();
	}

	public void clickOnBackButton (WebDriver driver){		
		Reporter.log("Clicking on Back button of Car Page");
		driver.findElement(By.xpath(backButtonLoc)).click();
		Reporter.log("Waiting for the page to load...");
	}
	
	public String getCountryNameSelectedInListBox (WebDriver driver){
		
		ListBoxUtil LbUtil = new ListBoxUtil();
		return LbUtil.getSelectedOptionInListBox(driver,countryListBoxLoc);
	}
	
	public void setCountryInListBox (WebDriver driver,String ValueTosetInListBox){
		Reporter.log("Setting Country List Box value as "+ValueTosetInListBox);
		ListBoxUtil LbUtil = new ListBoxUtil();
		LbUtil.setSingleValueInListBox(driver,ValueTosetInListBox,countryListBoxLoc);
	}
	
	public void setNumberPlateTextBoxValue (WebDriver driver,String numberPlateValue){
		Reporter.log("Waiting for Number Plate Textbox...");
		
		webUtil.waitUntilElementisVisible(driver, numberPlateTextBoxLoc);
		Reporter.log("Setting value in Number Plate Textbox..");
		driver.findElement(By.xpath(numberPlateTextBoxLoc)).sendKeys(numberPlateValue);
	}
	
	public void clearNumberPlateTextBoxValue (WebDriver driver){
		
		Reporter.log("Clearing value in Number Plate Textbox..");
		driver.findElement(By.xpath(numberPlateTextBoxLoc)).clear();
	}
	
	public void clickOnContinueBtn (WebDriver driver){
		//Wait until Continue button is interactable..
		webUtil.waitUntilElementisVisible(driver, continueButton);
		//Waiting until Continue Button is not getting enabled
		webUtil.waitUntilElementisClickable(driver, continueButton);
		
		Reporter.log("Clicking on Continue Button on Add Number Plate Page");
		driver.findElement(By.xpath(continueButton)).click();
	}
	
	public boolean isContinueBtnEnabled (WebDriver driver){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(continueButton)).isEnabled();
	}
	
	
	//Skip Hyperlink methods
	
	public void clickOnSkipNumberPlateHyperlink (WebDriver driver){		
		Reporter.log("Clicking on Skip/No Thanks Hyperlink of Car Page");
		driver.findElement(By.xpath(skiptNumberPlateButtonLoc)).click();
	}
	
	public String getSkipHyperlinkText (WebDriver driver){
		Reporter.log("Returning Car Page NumberPlate Skip Hyperlink Text");
		return driver.findElement(By.xpath(skiptNumberPlateButtonLoc)).getText();
	}
	

	
    private String carMakerLocatorCreator(String carMaker){
    	return "//li/a/div[contains(text(),\""+carMaker+" \")]";
    }
    
	public void selectCarMaker (WebDriver driver, String carMakerName){
		
		Reporter.log("Selecting Car Model "+carMakerName );
		//creating run time Xpath for the result of searchbox
		String carMakersloc = this.carMakerLocatorCreator(carMakerName);
		// Waiting for the objects to be interactable and after that clicking on it
		webUtil.waitUntilElementisVisible(driver, carMakersloc);
		driver.findElement(By.xpath(carMakersloc)).click();
	}
	
	public void enterValueInSearchBoxCarMaker (WebDriver driver,String carMakerName){
		//Waiting for Search box to be interactable...
		webUtil.waitUntilElementisVisible(driver, searchBoxCarMaker);
		Reporter.log("Entering Car Model value in search box");
		driver.findElement(By.xpath(searchBoxCarMaker)).sendKeys(carMakerName);
	}

	// Car Model add Page Methods
	
	public void enterValueInSearchBoxCarModel (WebDriver driver,String carModelName){
		//Waiting for Search box to be interactable...
		webUtil.waitUntilElementisVisible(driver, searchBoxCarModel);
		Reporter.log("Entering Car Model value in search box");
		driver.findElement(By.xpath(searchBoxCarModel)).sendKeys(carModelName);
	}
	
	private String carModelLocatorCreator(String carModel){
    	return "//li/a/div[contains(text(),\""+carModel+" \")]";
    }
	
	public void selectCarModel (WebDriver driver, String carModelName){
		Reporter.log("Selecting Car Model "+carModelName );
		//creating run time Xpath for the result of searchbox
		String carModelsloc = this.carModelLocatorCreator(carModelName);
		// Waiting for the objects to be interactable and after that clicking on it
		webUtil.waitUntilElementisVisible(driver, carModelsloc);
		driver.findElement(By.xpath(carModelsloc)).click();
	}
		
	public void selectCarType (WebDriver driver, String carType){
		String carTypeloc = carTypeLocGenerator(carType);
		Reporter.log("Selecting Car Type "+carType );
		driver.findElement(By.xpath(carTypeloc)).click();
	}
	
	public void selectCarColor (WebDriver driver, String carColor){
		String carColorloc = carColorLocGenerator(carColor);
		Reporter.log("Selecting Car Color  "+carColor );
		driver.findElement(By.xpath(carColorloc)).click();
	}
	
	public void enterManufacturingYear (WebDriver driver, String manufacturingYear){
		webUtil.waitUntilElementisVisible(driver, MnaufacturingYearTextBoxLoc);
		
		Reporter.log("Entering Manufacturing Year : "+manufacturingYear );
		driver.findElement(By.xpath(MnaufacturingYearTextBoxLoc)).sendKeys(manufacturingYear);
	}
	
	public void clickOnSubmitBtn(WebDriver driver){
		Reporter.log("Waiting For Submit Button to get Enabled!" );
		webUtil.waitUntilElementisClickable(driver, submitBtnLoc);
		Reporter.log("Clicking on Submit Button.." );
		driver.findElement(By.xpath(submitBtnLoc)).click();
	}
	
	public void clickOnAddNewCarBtn(WebDriver driver){
		
		Reporter.log("Clicking on Add New Car Button" );
		driver.findElement(By.xpath(addNewCarbtnloc)).click();
	}
	
	public boolean isAddNewCarBtnVisible(WebDriver driver){
		return driver.findElement(By.xpath(addNewCarbtnloc)).isDisplayed();
	}
	
	
}
