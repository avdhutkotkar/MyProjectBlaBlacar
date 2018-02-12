package blablacarB13.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Reporter;

import blablacarB13.utilities.PropertiesOperation;

public class JavaDatabaseConnectionUtil {
	public static String JDBC_URL = null;
	public static Connection connection =null;
	public static String JDBC_Driver = null;
	public static Statement statement = null;
	
	JavaDatabaseConnectionUtil (){
	PropertiesOperation prop = new PropertiesOperation();
	JDBC_URL = prop.getRadicalValueBykey("JDBC_URL");
	JDBC_Driver = prop.getRadicalValueBykey("JDBC_Driver");
	}

	public void connectToDatabase(){
		try{
		Class.forName(JDBC_Driver);
		connection = DriverManager.getConnection(JDBC_URL);
		}catch (Exception e){
			Reporter.log("database connection problem... Please check the configuration");
			e.printStackTrace();
		}
	}
	
	public void closeConnection(){
		try{
		connection.close();
		}catch(Exception e){
			Reporter.log("Couldn't close the established connection...");
			e.printStackTrace();
		}
	}
	
	public Statement createStatement(){
		try{
		statement = connection.createStatement();
		}catch (Exception e){
			Reporter.log("Statement creation failed..");
			e.printStackTrace();
		}
		return statement;
	}
	
	public static void main (String a[]){
		JavaDatabaseConnectionUtil database = new JavaDatabaseConnectionUtil();
		database.connectToDatabase();
		try{
		ResultSet res =database.createStatement().executeQuery("select * from EMP");
		
		while(res.next()){
			String empID = res.getString("empID");
			int row = res.getRow();
			System.out.println("Emp ID is : "+empID +" Row number is : "+row);

		}
		
		
		
		}catch (Exception e){
			Reporter.log("SQL Exception occured..");
		}
		
		
	}
	
}
