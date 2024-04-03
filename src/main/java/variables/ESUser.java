package variables;

import org.json.JSONException;
import org.json.JSONObject;


public class ESUser {
	
	private String ES_UserId;
	private String ES_Gender;
	private String ES_Country;
	private String ES_GenderSearch;
	private String ES_IncomeFrom;
	private String ES_IncomeTo;
	private String ES_Age;
	private String ES_Education;
	private ESFreeTimeObject ESfreetimeObj;

	  
	public ESUser(JSONObject pJsonObj) throws JSONException {
		
		this.ESfreetimeObj = new ESFreeTimeObject(pJsonObj.getJSONObject("free_time_and_sport_object"));
		  
		  //Gson  gson = new Gson();
		//this.freetimeObj = gson.fromJson(jsonObj.getString("free_time_and_sport_object"), FreeTimeObject.class);
	}
	
	public ESUser() {
	}
	

	//-------------ES value-------------------------------------------
	
	public String getES_UserId() {
		if ( (this.ES_UserId == null) || (this.ES_UserId.equals("")) )
		{
			return "empty";
		}
		else return this.ES_UserId;
	} 
	
	public String getES_Gender() {
		if( (this.ES_Gender == null) || (this.ES_Gender.equals("")) )
		{
			return "empty";
		}
		else return this.ES_Gender;	
	} 
	
	public String getES_Country() {
		if( (this.ES_Country == null) || (this.ES_Country.equals("")) )
		{
			return "empty";
		}
		else return this.ES_Country;
	} 
	
	public String getES_GenderSearch() {
		if( (this.ES_Gender == null) || (this.ES_Gender.equals("")) )
		{
			return "empty";
		}
		else 
		{
			if (this.ES_Gender.toString().equals("male"))
				return "female";
			else return "male";
		}
		
	} 
	
	public String getES_IncomeFrom() {
		if( (this.ES_IncomeFrom == null) || (this.ES_IncomeFrom.equals("")) || (this.ES_IncomeFrom.toString().equals("0")))
		{
			return "empty";
		}
		else return this.ES_IncomeFrom;
		
	} 
	
	public String getES_IncomeTo() {
		if( (this.ES_IncomeTo == null) || (this.ES_IncomeTo.equals("")) || (this.ES_IncomeTo.toString().equals("0")))
		{
			return "empty";
		}
		else return this.ES_IncomeTo;
	} 
	
	public String getES_Age() {
		if( (this.ES_Age == null) || (this.ES_Age.equals("")) )
		{
			return "empty";
		}
		else 
		{
			if(this.ES_Age != null)
				return this.ES_Age.split("T")[0].toString();
			else return null;
		}
			
	} 
	 
	public String getES_Education() {
		if( (this.ES_Education == null) || (this.ES_Education.equals("")))
		{
			return "empty";
		}
		else 
		{
			if (this.ES_Education.equals("completed_study"))
				this.ES_Education = "Abgeschlossenes Studium";
			else if (this.ES_Education.equals("still_studying"))
				this.ES_Education = "Noch im Studium";
			else if (this.ES_Education.equals("some_semesters_studied"))
				this.ES_Education = "Einige Semester studiert (z.Z. nicht aktiv)";
			else if (this.ES_Education.equals("high_school"))
				this.ES_Education = "Abitur";
			else if (this.ES_Education.equals("real_handels_fachschulabschluss"))
				this.ES_Education = "Real-/Handels-/Fachschulabschluss";
			else if (this.ES_Education.equals("hauptschulabschluss"))
				this.ES_Education = "Hauptschulabschluss";
			else if (this.ES_Education.equals("lower_education"))
				this.ES_Education = "Niedrigerer Abschluss";
	
			return this.ES_Education;
		}
				
	} 
	
	public ESFreeTimeObject getESFreeTime()
	{
		 
		return this.ESfreetimeObj;
	}
	
	//-------------------------------------------------------------------
	
	public void setES_UserId ( JSONObject pJsonObj){
		try
		{
			//int ES_UserId = pJsonObj.getInt("user_id");
			this.ES_UserId = Integer.toString(pJsonObj.getInt("user_id"));
		}
		catch(Exception e)
		{
			this.ES_UserId = null;
		}
	}
	
	public void setES_Gender ( JSONObject pJsonObj ){
		try
		{
			this.ES_Gender = pJsonObj.getString("gender");
		}
		catch(Exception e)
		{
			this.ES_Gender = null;
		}
		
	}
	
	public void setES_Country ( JSONObject pJsonObj ){
		try
		{
			this.ES_Country = pJsonObj.getString("country");
		}
		catch(Exception e)
		{
			this.ES_Country = null;
		}
		
	}

	public void setES_GenderSearch () {
		try
		{
			if (this.ES_Gender.toString().equals("male"))
				this.ES_GenderSearch =  "female";
			else this.ES_GenderSearch =  "male";
		}
		catch(Exception e)
		{
			this.ES_GenderSearch = null;
		}
	}	
	
	public void setES_IncomeFrom ( JSONObject pJsonObj ){
		try
		{
			JSONObject IncomeObject = pJsonObj.getJSONObject("income_object");
			this.ES_IncomeFrom =  Integer.toString(IncomeObject.getInt("from"));
		}
		catch(Exception e)
		{
			this.ES_IncomeFrom = null;
		}
	}
	
	public void setES_IncomeTo ( JSONObject pJsonObj ){
		try
		{
			JSONObject IncomeObject = pJsonObj.getJSONObject("income_object");
			this.ES_IncomeTo = Integer.toString(IncomeObject.getInt("to"));
		}
		catch(Exception e)
		{
			this.ES_IncomeTo = null;
		}
	}
	
	public void setES_Age ( JSONObject pJsonObj ) {
		try
		{
			this.ES_Age = pJsonObj.getString("dob");
		}
		catch(JSONException e)
		{
			//System.out.println(e.toString());
			//System.out.println("UserID: " + this.getSQL_UserId() + " - Error when getting data of MySql DOB \r\n");
			this.ES_Age = null;
		
		}
		
	}
	
	public void setES_Education ( JSONObject pJsonObj ){
		try
		{
			JSONObject EducationObject = pJsonObj.getJSONObject("education_object");
			this.ES_Education =  EducationObject.getString("highest_degree");
		}
		catch(Exception e)
		{
			this.ES_Education = null;
		}
	}
	
	
}

