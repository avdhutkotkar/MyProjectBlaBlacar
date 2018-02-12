package blablacarB13.POMLib.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonElementsFromAllPages {
	String saveBtn = "//button[contains(text(),'Save')]";
	
	public void ClickOnSaveBtn(WebDriver driver){
		driver.findElement(By.xpath(saveBtn)).click();
	}
}
