package blablacarB13.POMLib.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HeaderPage {
	String LogInButtonLoc = "//a[contains(text(),'Log in')]";
	String dropDownActions = "//span[@class='dropdown-icon']";
	String dropDownMenuOptions = "//div[@class='Dropdown Dropdown--userMenu dropdown-menu']";
	
	// menu Options on Drop Down Options
	String profileOp = "//li/a[@class='profile']";
	
	
	public void clickOnSignIn (WebDriver driver){
		Reporter.log("Click on Log in Button on Header Page");
		driver.findElement(By.xpath(LogInButtonLoc)).click();
	}
	
	public void clickOnDropDownActions(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver,2);
		Reporter.log("Clicking on Drop Drown for more Actions");
		driver.findElement(By.xpath(dropDownActions)).click();
		// Waits for Drop Down to be displayed
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDownMenuOptions)));
	}
	
	public void navigateToProfile(WebDriver driver){
		clickOnDropDownActions(driver);
		driver.findElement(By.xpath(profileOp)).click();
	}		
}
