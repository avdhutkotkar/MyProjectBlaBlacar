package blablacarB13.POMLib.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class UserPages extends CommonElementsFromAllPages {
	
	String dashboardTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Dashboard')]";
	String ridesOfferedTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Rides offered')]";
	String bookingsTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Bookings')]";
	String messagesTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Messages')]";
	String rideAlertsTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Ride alerts')]";
	String profileTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Profile')]";
	
	public void clickOnDashboardTab(WebDriver driver){
		Reporter.log("Clicking On Dashboard Tab");
		driver.findElement(By.xpath(dashboardTabLoc)).click();
	}
	public void clickOnRidesOfferedTab(WebDriver driver){
		Reporter.log("Clicking On Rides Offered Tab");
		driver.findElement(By.xpath(ridesOfferedTabLoc)).click();
	}
	public void clickOnBookingsTab(WebDriver driver){
		Reporter.log("Clicking On Bookings Tab");
		driver.findElement(By.xpath(bookingsTabLoc)).click();
	}
	public void clickOnMessagesTab(WebDriver driver){
		Reporter.log("Clicking On Messages Tab");
		driver.findElement(By.xpath(messagesTabLoc)).click();
	}
	public void clickOnRideAlertTab(WebDriver driver){
		Reporter.log("Clicking On Ride Alerts Tab");
		driver.findElement(By.xpath(rideAlertsTabLoc)).click();
	}
	public void clickOnProfileTab(WebDriver driver){
		Reporter.log("Clicking On Profile Tab");
		driver.findElement(By.xpath(profileTabLoc)).click();
	}
}
