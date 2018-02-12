package blablacarB13.utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowOperations {
	
	public String getNewlyOpenedWinID(WebDriver driver, String parentWin){
		Set<String> windows = driver.getWindowHandles();
		String childWindow= null;

		if(windows.size()>1){
		for (String win : windows){
			if(!parentWin.equals(win)){
				childWindow= win;
			}
		}
		return childWindow;
		}
		System.out.println("No New Window Opened");
		return driver.getWindowHandle();
	}
		
	public String getNewlyOpenedWinID(WebDriver driver, String parentWin , String childWin){
		Set<String> windows = driver.getWindowHandles();
		String grandChildWindow= null;
		if(windows.size()>2){
			for (String win : windows){
				if(!parentWin.equals(win) && !childWin.equals(win)  ){
					grandChildWindow= win;
				}
			}
			return grandChildWindow;
		}
		System.out.println("No New Window Opened");
		return driver.getWindowHandle();
	}
	
	public void setCurrentWin(WebDriver driver,String windowID){
		driver.switchTo().window(windowID);
	}
	
}
