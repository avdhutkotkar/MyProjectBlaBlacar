package blablacarB13.utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class ListBoxUtil {
	public String getSelectedOptionInListBox (WebDriver driver, String listBoxLoc){
		String selectedOptionValue = null;
		try{
		WebElement listBox = driver.findElement(By.xpath(listBoxLoc)); 
		Select sel = new Select(listBox);
		
		WebElement selectedoption = sel.getFirstSelectedOption();
		
		selectedOptionValue = selectedoption.getText();
		
		}catch(Exception e){
			
			Reporter.log("Exception while getting Selected Option from List Box");
		}
		return selectedOptionValue;
	}
	
	public void setSingleValueInListBox (WebDriver driver,String OptionValue, String ListBoxLoc){
		try{
			WebElement listBox = driver.findElement(By.xpath(ListBoxLoc)); 
			Select sel = new Select(listBox);
			sel.selectByValue(OptionValue);
		}catch(Exception e){
			Reporter.log("Exception while setting value in List Box");
		}
	}
    

}
