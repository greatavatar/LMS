package tests.sandbox;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class ESUser {

	private String user_id;
	private FreeTimeObject freetimeObj;
	private String Gender;
	private String Country;
	private String Gender_Search;
	private String Income;
	private String Age;

	  ESUser(JSONObject jsonObj) throws JSONException {
		  this.user_id = jsonObj.getString("user_id");
		  this.freetimeObj = new FreeTimeObject(jsonObj.getJSONObject("free_time_and_sport_object"));
		  
		  
		  
		  //Gson  gson = new Gson();
			 //this.freetimeObj = gson.fromJson(jsonObj.getString("free_time_and_sport_object"), FreeTimeObject.class);
	  }
	  
	 public String getUserId()
	 {
		 return this.user_id;
	 }
	 
	 public FreeTimeObject getFreeTime()
	 {
		 
		 return this.freetimeObj;
	 }
	  
}

