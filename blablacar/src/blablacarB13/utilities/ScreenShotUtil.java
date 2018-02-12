package blablacarB13.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ScreenShotUtil {
	
	// This Method Takes screenshot of the Current window which is in View..
    // File name has Details : Window Title + Time Stamp
	
	public void getMyScreenShot(WebDriver driver){
		try{
		Reporter.log("Taking ScreenShot....!");
		TakesScreenshot obj =  (TakesScreenshot) driver;
		File srcFile=  obj.getScreenshotAs(OutputType.FILE);
		String title = driver.getTitle();
		
		// To make Title special characters free as File cannot contain special characters in Name
		DataManipulationUtil dataManobj =new DataManipulationUtil();
		title =dataManobj.ReturnSpecialCharacterLessString(title);
		
		//Getting current timeStamp ....
		String myTimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(Calendar.getInstance().getTime());
		
		//Taking Folder location where Screenshots to be kept
		PropertiesOperation proOP = new PropertiesOperation();
		String location = proOP.getRadicalValueBykey("screeshotFilesLocation");
		
		//OverAll Screenshot Filename and Path 
		String fileName = location+"Project_"+title+"_"+myTimeStamp+".png";
		
		//Creating file at destination and copying the file from Taking screenshot to the specified location
		File destinationFile = new File(fileName);
		FileUtils.copyFile(srcFile, destinationFile);
		
		Reporter.log("Screenshot Taken. Find Details at :- "+fileName);

		}catch(Exception e){
			Reporter.log("Exception in Screenshot Method...");
		}
	
	}

}
