package verificationFunctions;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;

import functions.F_Account;
import functions.F_Payment;

//import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.yaml.snakeyaml.scanner.Constant;

import functions.generalFunctions;
import interfaces.I_DashboardPage;
import interfaces.I_HomePage;
//import variables.ConstantLib.Constants;
import variables.TCResult;

public class F_PaymentVerification {

	
	/**
	 * Verify Page is navigated to Dashboard page after buying sucessfully
	 * 
	 */
	public static void Verify_Page_Redirect_To_Dashboard_After_Buying(TCResult pResult) {
		
		generalVerification.verifyElementVisible(I_DashboardPage.img_MyAvatar, "Avatar Picture in DashBoard Page", pResult);     
	}
	
	/**
	 * Verify Order ID is existed for a user
	 * 
	 * @param pUserCode
	 * 			UserCode of a user
	 * @param pResult
	 *     		Result of the test case
	 */
	public static void DS_Verify_OrderID_Exist(String pUserCode, TCResult pResult) {
		
		if(F_Payment.DS_GetOrderID(pUserCode) == -1)
		{
			pResult.SetResult(false);
			pResult.SetMessage("\r\n There is no Payment is ordered");
		}      
	}
	
	/**
	 * Verify Order ID is existed for a user
	 * 
	 * @param pUserCode
	 * 			UserCode of a user
	 * @param pBundle
	 *     		Bundle of payment: BASIC, SMART, COMFORT
	 * @param pFrequency
	 *      		Frequency of payment: Monthly, Quarterly, Semiannual, Onetime
	 * @param pResult
	 *      		Result of the test case
	 */
	public static void DS_Verify_Frequency_Row_Number(String pUserCode, String pBundle, String pFrequency, TCResult pResult) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		int OrderId = -1;
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "select a.id from `order` a inner join fos_user b on a.user_id = b.id where b.user_code ='" + pUserCode + "'" ;
			stmt = con.createStatement();
			OrderId = F_Payment.DS_GetOrderID(pUserCode);
			//Check exist row number in Order_Schedule table
	    		query = "select count(*) from payment_schedule where order_id = '" + OrderId + "'" ;
	    		//System.out.println("Query is: " + query + "\r\n");
	        rs = stmt.executeQuery(query);
	        rs.last();
	        if (rs.getRow() > 0)
	        		{
	        			rs.first();
	        			int ExpectedRowNumber = rs.getInt(1);
	        			int RowNumber = F_Payment.GetFrequencyPaymentRowNumber(pBundle, pFrequency);
	        			if(ExpectedRowNumber != RowNumber)
	        			{
	        				pResult.SetResult(false);
		        			pResult.SetMessage("\r\n Row Number in PaymentSchedule for usercode " +  pUserCode + "  is " + RowNumber  +  " : not correct");
	        			}
	        		} 
	        else
	        		{
	        			pResult.SetResult(false);
	        			pResult.SetMessage("\r\n There is no row in PaymentSchedule for usercode " +  pUserCode);
	        		}
	        
	        }
		catch(SQLException ex)
		{
			// handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    pResult.SetResult(false);
			pResult.SetMessage("\r\n SQL error");

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
	 * Verify there is a new payment mail in MailBox client
	 * 
	 */
	public static void Verify_Receive_Email_New_Payment(String pUserName, String pDomain, TCResult pResult) {
		
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]/div/a/span[contains(text(),'Bestätigung Ihrer Bestellung bei lms')]"), "Email for New Payment", pResult);
			
	}

	/**
	 * Verify period_product_price_gross in Product table
	 * 
	 */
	public static void DS_Verify_Period_Product_Price_Gross(TCResult pResult) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "SELECT * FROM (SELECT id,period_product_price_gross,(product_price_gross * product_duration) AS period_product_price_gross_1 FROM product) AS t1 WHERE period_product_price_gross <> period_product_price_gross_1;";
			//System.out.println("Query is: " + query + "\r\n");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
	        rs.last();
	        int total_row = rs.getRow(); 
	        System.out.println(" total result set row is: " + rs.getRow() + "\r\n");
	        if ( total_row > 0)
	        	{
	        		rs.first();
	        		String ids = "Product IDs: ";
	        		for(int i = 0; i<total_row; i++)
	    			{
	    				ids = ids  + rs.getString("id") + ", ";
	    				if (rs.isLast() == false) rs.next();
	    			}
	        		
	        		pResult.SetResult(false);
	        		pResult.SetMessage("\r\n There is existing row which has period_product_price_gross incorrect. " + ids);
	        	}
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
		
}
