package blablacarB13.POMLib.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import blablacarB13.POMLib.common.UserPages;

public class DashBoardPage extends UserPages {
	
	String dashboardTabLoc = "//ul[@id='myTab']/li/a[contains(text(),'Dashboard')]";
			
	public boolean isDashboardTabVisible (WebDriver driver){
		Reporter.log("Checking If Dashboard Tab present ");
		return driver.findElement(By.xpath(dashboardTabLoc)).isDisplayed();
	}
			
}
