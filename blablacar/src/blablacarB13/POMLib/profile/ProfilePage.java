package blablacarB13.POMLib.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import blablacarB13.POMLib.common.UserPages;

public class ProfilePage extends UserPages {
	String personalInfoCatLoc = "//li/a[contains(text(),'Personal information')]";
	String carCatLoc = "//li/a[contains(text(),'Car')]";
	
	
	public void ClickOnPersonalInfoCat(WebDriver driver){
		driver.findElement(By.xpath(personalInfoCatLoc)).click();
	}
	
	public void ClickOnCarCat(WebDriver driver){
		driver.findElement(By.xpath(carCatLoc)).click();
	}
	
}
