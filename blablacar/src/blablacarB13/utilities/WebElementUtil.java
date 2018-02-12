package blablacarB13.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtil {
	WebDriverWait wait;
	
	public void waitUntilElementisVisible(WebDriver driver, String ElementLoc){
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementLoc)));
	}
	
	public void waitUntilElementisClickable(WebDriver driver, String ElementLoc){
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementLoc)));
	}
	
}
