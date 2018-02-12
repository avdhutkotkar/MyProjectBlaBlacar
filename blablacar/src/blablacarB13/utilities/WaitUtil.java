package blablacarB13.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WaitUtil {
	
	public boolean waitForJQueryandJSToLoad(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		ExpectedCondition<Boolean> waitForJQueryToload = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				try{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				Reporter.log("Executing Jquery Script....!");
				 return (long)(js.executeScript("return jQuery.Active", ""))== 0;
				}catch(Exception e){
					Reporter.log("Exception in Jquery Execution"+e);
					// jquery not present
					return true;
				}
			}
			};
		
			ExpectedCondition<Boolean> waitForJSToload = new ExpectedCondition<Boolean>() {
				
					@Override
					public Boolean apply(WebDriver driver) {
						Reporter.log("Executing Javascript Script....!");
						try{
						JavascriptExecutor js = (JavascriptExecutor)driver;	
						 return (js.executeScript("return document.readystate", "")).equals("complete");
						}catch(Exception e){
							Reporter.log("Exception in Java Scription Execution "+e);
							return true;
						}
						
						}
				};
				Reporter.log("Waiting to load....!");
			return wait.until(waitForJSToload) && wait.until(waitForJQueryToload);	
		 }
}
		
		
			