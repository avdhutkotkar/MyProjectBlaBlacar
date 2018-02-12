package blablacarB13.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelSheet {
	
	
	XSSFWorkbook wb;
	//HSSFWorkbook wb1;
	XSSFSheet sheet ;
	
	
	public ReadExcelSheet(String excelPath){
		try{
		File srcFile = new File(excelPath);
		FileInputStream fis = new FileInputStream(srcFile);
		//Read excel file
		wb = new XSSFWorkbook(fis);
		//wb1 = new HSSFWorkbook(fis);
		//get sheet
		sheet = wb.getSheetAt(0);
		wb.close();
		}catch(Exception e){
			System.out.println("Exception while reading the excel sheet..");
		}
	}
	
	
	public Object getCellData(int sheetNumber, int row, int column){
		
		//sheet =wb.getSheetAt(sheetNumber);
		Object data0;
		try{
			data0 = sheet.getRow(row).getCell(column).getStringCellValue();
			//data0 = sheet.getRow(row).getCell(column).toString();  
		}catch(IllegalStateException e1){
			data0 = sheet.getRow(row).getCell(column).getRawValue();  // Gets anytype of cell value
		}
		catch(Exception e){
			data0 = "";
		}
		return data0;
	}
	
	public int getRowCount(int sheetIndex){
		
		int rowCNT = wb.getSheetAt(sheetIndex).getLastRowNum();
		return rowCNT+1;
			
	}
	
	public int getColumnCount (int sheetIndex){
		int rowCNT = getRowCount(sheetIndex);
		
		int MaxcolumnCNT=0;
		for (int i = 0; i < rowCNT; i++) {
			int CurrentRowcolumnCNT = wb.getSheetAt(sheetIndex).getRow(i).getLastCellNum();
			if(CurrentRowcolumnCNT>MaxcolumnCNT){
				MaxcolumnCNT=CurrentRowcolumnCNT;
			}
		}
		return MaxcolumnCNT;
	}		
}
