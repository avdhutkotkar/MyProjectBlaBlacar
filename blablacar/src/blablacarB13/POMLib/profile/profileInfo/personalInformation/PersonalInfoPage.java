package blablacarB13.POMLib.profile.profileInfo.personalInformation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import blablacarB13.POMLib.profile.ProfilePage;
import blablacarB13.utilities.ListBoxUtil;

public class PersonalInfoPage extends ProfilePage {
	
	//Page HardCoded Elements
	String personalInfoHeaderLoc = "//div/h1";
	String genderFieldLoc = "//fieldset/section[@class='civility-container']/div[1]/div[1]";
	
	String firstNameFieldLoc = "//fieldset/section[@class='civility-container']/div[2]/label";
	String lastNameFieldLoc = "//fieldset/section[@class='civility-container']/div[3]/label";
	String emailFieldLoc = "//fieldset/section[@class='contact-container']/div[1]/label";
	String mobileNoFieldLoc = "//fieldset/section[@class='contact-container']/div[2]/label";
	
	// User specific values
	
	String userGenderTypeLoc = "//section[@class='civility-container']/div[1]/div[2]";
	String userFirstNameValueLoc = "//section[@class='civility-container']//input[@id='profile_general_firstname']";
	String userLastNameValueLoc = "//section[@class='civility-container']//input[@id='profile_general_lastname']";
	String userEmailValueLoc = "//section[@class='contact-container']/div//input[@type='email']";
	String userMobileNoValueLoc = "//section[@class='contact-container']/div//input[@id='profile_general_phone_rawInput']";

	String countryCodeListBoxLoc = "//select[@id='profile_general_phone_regionCode']";
	String birthYearListBoxLoc ="//select[@id='profile_general_birthYear']";
	
	// Methods targeting UI Hard coded values 

	public String getPersonalInfoHeaderText (WebDriver driver){
		Reporter.log("Returning Header Text");
		return driver.findElement(By.xpath(personalInfoHeaderLoc)).getText();
	}
	
	public String getGenderFieldText (WebDriver driver){
		Reporter.log("Returning Gender Field Text");
		return driver.findElement(By.xpath(genderFieldLoc)).getText();
	}
		
	public String getFirstNameFieldText (WebDriver driver){
		Reporter.log("Returning First Name Field Text");
		return driver.findElement(By.xpath(firstNameFieldLoc)).getText();
	}
	
	public String getLastNameFieldText (WebDriver driver){
		Reporter.log("Returning Last Name Field Text");
		return driver.findElement(By.xpath(lastNameFieldLoc)).getText();
	}	
	public String getEmailFieldText (WebDriver driver){
		Reporter.log("Returning Email Field Text");
		return driver.findElement(By.xpath(emailFieldLoc)).getText();
	}	
	public String getMobNoFieldText (WebDriver driver){
		Reporter.log("Returning Mobile Number Field Text");
		return driver.findElement(By.xpath(mobileNoFieldLoc)).getText();
	}	
	
	// GET methods
	//methods interacting with elements to get values which are User specific details
	
	public String getUserGenderTypeValue (WebDriver driver){
		Reporter.log("Returning Current User's Gender Type");
		return driver.findElement(By.xpath(userGenderTypeLoc)).getText();
	}
	
	public String getUserFirstNameValue (WebDriver driver){
		Reporter.log("Returning Current User's First Name ");
		return driver.findElement(By.xpath(userFirstNameValueLoc)).getAttribute("value");
	}
	
	public String getUserLastNameValue (WebDriver driver){
		Reporter.log("Returning Current User's Last Name ");
		return driver.findElement(By.xpath(userLastNameValueLoc)).getAttribute("value");
	}
	
	public String getUserEmailValue (WebDriver driver){
		Reporter.log("Returning Current User's Email");
		return driver.findElement(By.xpath(userEmailValueLoc)).getAttribute("value");
	}
	
	public String getUserMobileNoValue (WebDriver driver){
		Reporter.log("Returning Current User's Mobile No. ");
		return driver.findElement(By.xpath(userMobileNoValueLoc)).getAttribute("value");
	}
	
	//list box
	public String getCountryCodeSelectedInListBox (WebDriver driver){
		
		ListBoxUtil LbUtil = new ListBoxUtil();
		return LbUtil.getSelectedOptionInListBox(driver,countryCodeListBoxLoc);
		
	}
	
	//SET Methods
	//methods interacting with elements to Set values which are User specific details
	
	public void setUserFirstNameValue (WebDriver driver,String firstName){
		Reporter.log("Setting value in First Name textbox ");
		driver.findElement(By.xpath(userFirstNameValueLoc)).sendKeys(firstName);
	}
	
	public void setUserLastNameValue (WebDriver driver,String lastName){
		Reporter.log("Setting value in Last Name textbox ");
		driver.findElement(By.xpath(userLastNameValueLoc)).sendKeys(lastName);
	}
	
	public void setUserEmailValue (WebDriver driver,String email){
		Reporter.log("Setting value in Email textbox ");
		driver.findElement(By.xpath(userEmailValueLoc)).sendKeys(email);
	}
	
	public void setUserMobileNoValue (WebDriver driver,String mobileNo){
		Reporter.log("Setting value in Mobile No textbox ");
		driver.findElement(By.xpath(userMobileNoValueLoc)).sendKeys(mobileNo);
	}	
	
	
	
	
	
}
