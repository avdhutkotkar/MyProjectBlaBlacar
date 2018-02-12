package blablacarB13.utilities;

public class UserDetails {
	private boolean gender;
	private String firstName;
	private String lastName;
	private String userNameID;
	private String userPass;
	private int birthYear;
	
	public void setGender(String gender){
		if(gender.equals("Male")){
			this.gender=true;
		}else{
			this.gender=false;
		}
	}
	
	public String getGender(){
		if(this.gender==true)
			return "Male";
		else
			return "Female";
	}
	
	public void setFirstName (String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName (){
		return this.firstName;
	}
	
}
