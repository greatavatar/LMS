package variables;

import org.json.JSONException;
import org.json.JSONObject;

public class ESFreeTimeObject {

	 private String holidays = "";

	 ESFreeTimeObject() {
		 
	 }
	  ESFreeTimeObject(JSONObject jsonObj) throws JSONException {
		  if(jsonObj.has("holidays")) {
			  this.holidays = jsonObj.getString("holidays");
		  }
		  
	    
	  }
	  
	  public String getHoliday()
	  {
		  return this.holidays;
	  }
	  
	  
	  
}

