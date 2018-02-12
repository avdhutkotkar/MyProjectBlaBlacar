package blablacarB13.utilities;

public class DataManipulationUtil {
	
	// Removes all the special Characters and replaced them with "_" underscore
	public String ReturnSpecialCharacterLessString(String InputString){
		return InputString.replaceAll("[^a-zA-Z0-9]", "_");		 // Replaces characters not present in a-z A-Z 0-9 with "_" 
	}
		
}
