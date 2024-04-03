package variables;

import org.json.JSONException;
import org.json.JSONObject;


public class SQLUser {
	
	private String SQL_Password;
	private String SQL_UserName;
	private String SQL_UserId;
	private String SQL_Gender;
	private String SQL_Country;
	private String SQL_GenderSearch;
	private String SQL_IncomeFrom;
	private String SQL_IncomeTo;
	private String SQL_Age;
	private String SQL_Education;
	  
	
	public SQLUser() {
	}
	
	//-------------SQL value-------------------------------------------
	public void setSQL_UserId ( String pId ) {
		this.SQL_UserId = pId;
	}

	public String getSQL_UserId() {
		if((this.SQL_UserId == null) || (this.SQL_UserId.equals("")) )
			return "empty";
		else return this.SQL_UserId;
	} 
	
	public void setSQL_Gender ( String gGender ) {
		this.SQL_Gender = gGender;
	}

	public String getSQL_Gender() {
		if( (this.SQL_Gender == null) || (this.SQL_Gender.equals("")) )
		{
			return "empty";
		}
		else 
		{
			if (this.SQL_Gender.toString().equals("1"))
				return "male";
			else return "female";
		}
		
	} 
	
	public void setSQL_Country ( String pCountry ) {
		this.SQL_Country = pCountry;
	}

	public String getSQL_Country() {
		if( (this.SQL_Country==null) || (this.SQL_Country.equals("")) )
		{
			return "empty";
		}
		else return this.SQL_Country;
	} 
	
	public void setSQL_GenderSearch ( String pGenderSearch ) {
		this.SQL_GenderSearch = pGenderSearch;
	}

	public String getSQL_GenderSearch() {
		if ( (this.SQL_GenderSearch == null) || (this.SQL_GenderSearch.equals("")) )
		{
			return "empty";
		}
		else
		{
			if (this.SQL_GenderSearch.toString().equals("1"))
				return "male";
			else return "female";
		}
		
	} 
	
	public void setSQL_IncomeFrom ( String pIncomeFrom ) {
		this.SQL_IncomeFrom = pIncomeFrom;
	}
	
	public String getSQL_IncomeFrom() {
		if ( (this.SQL_IncomeFrom == null) || (this.SQL_IncomeFrom.equals("")) || (this.SQL_IncomeFrom.toString().equals("0")))
		{
			return "empty";
		}
		else return this.SQL_IncomeFrom;
	} 
	
	public void setSQL_IncomeTo ( String pIncomeTo ) {
		this.SQL_IncomeTo = pIncomeTo;
	}
	
	public String getSQL_IncomeTo() {
		if ( (this.SQL_IncomeTo == null) || (this.SQL_IncomeTo.equals("")) || (this.SQL_IncomeTo.toString().equals("0")))
		{
			return "empty";
		}
		else return this.SQL_IncomeTo;
	} 
	
	public void setSQL_Age ( String pAge ) {
		this.SQL_Age = pAge;
	}
	
	public String getSQL_Age() {
		if ( (this.SQL_Age == null) || (this.SQL_Age.equals("")) )
		{
			return "empty";
		}
		else return this.SQL_Age;
	} 
	

	public void setSQL_Education ( String pEducation ) {
		this.SQL_Education = pEducation;
	}
	
	public String getSQL_Education() {
		if ( (this.SQL_Education == null) || (this.SQL_Education.equals("")) )
		{
			return "empty";
		}
		else return this.SQL_Education;
	}

	public void setSQL_UserName ( String pUserName ) {
		this.SQL_UserName = pUserName;
	}
	
	public String getSQL_UserName() {
		if ( (this.SQL_UserName == null) || (this.SQL_UserName.equals("")) )
		{
			return "empty";
		}
		else return this.SQL_UserName;
	} 
	
	public void setSQL_Password ( String pPassword ) {
		this.SQL_Password = pPassword;
	}
	
	public String getSQL_Password() {
		if ( (this.SQL_Password == null) || (this.SQL_Password.equals("")) )
		{
			return "empty";
		}
		else return this.SQL_Password;
	} 
		
}

