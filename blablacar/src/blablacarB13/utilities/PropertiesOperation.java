package blablacarB13.utilities;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
@SuppressWarnings("unused")
public class PropertiesOperation {

	/**
	 * Generic values will be handled in this class
	 */
	static String basePath = new File("").getAbsolutePath();
	//gets absolute path till the project
	
	public static String filename1 = basePath.concat("/src/blablacarB13/utilities/config.properties");
	
//	public static String filename1= "D:/Eclipse_WorkSpace/blablacar/src/blablacarB13/utilities/config.properties";
	
	public String getRadicalValueBykey(String key){
		String value="";
		try{
			FileInputStream inputFile = new FileInputStream(filename1);
			Properties properties = new Properties();
			properties.load(inputFile);
			inputFile.close();
			value = properties.getProperty(key);
			if(value == null || value.equals("")){
				System.out.println("The value for key: " +  key + " doesn't exist.");
				System.out.println("Please check the content of the properties file.");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return value;
	}
	
	public static void main(String[] args) throws IOException {
		
	}

}
