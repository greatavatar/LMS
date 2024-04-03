package functions;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import functions.generalFunctions;
import interfaces.I_VisitProfile_Dashboard;
import variables.ConstantLib.Constants;

public class F_Hello {

	/**
	 * Update the date of Complete_Profile_2 in Database
	 * @param pValue
	 *            Value to set say_hello_status column: 0,1,2
	 * 	               
	 */
	public static void DS_SetStatusOfHello(String pUserCode,String pValue) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		String query = "";
		try 
		{
			con = generalFunctions.ConnectDataBase();
			query = "Update fos_user set `say_hello_status` = '"+ pValue +"' where user_code = '" + pUserCode + "'";
			
			//System.out.println("Query is: " + query + "\r\n");
			stmt = con.createStatement();
    			stmt.executeUpdate(query);    
	     }
		catch(SQLException ex)
		{
			// handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }	
		}
	}
	
	/**
	 * Close Hello PopUp
	 *            
	 */
	public static void CloseHelloPopUp() {
		
		generalFunctions.click(By.xpath("//div[@id='say-hello-modal'][@class='modal fade in']//div[contains(text(),'Jetzt nicht')]"));
	}
	
}
