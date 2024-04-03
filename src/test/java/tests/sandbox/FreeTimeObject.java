package tests.sandbox;

import org.json.JSONException;
import org.json.JSONObject;

public class FreeTimeObject {

	 private String holidays = "";

	 FreeTimeObject() {
		 
	 }
	  FreeTimeObject(JSONObject jsonObj) throws JSONException {
		  if(jsonObj.has("holidays")) {
			  this.holidays = jsonObj.getString("holidays");
		  }
		  
	    
	  }
	  
	  public String getHoliday()
	  {
		  return this.holidays;
	  }
	  
	  
	  
}

