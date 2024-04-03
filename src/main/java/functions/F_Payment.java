package functions;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import functions.generalFunctions;
import interfaces.I_DashboardPage;
import interfaces.I_HomePage;
import interfaces.I_Payment;
import interfaces.I_VisitProfile_Dashboard;
import variables.TCResult;
import variables.ConstantLib.Constants;

public class F_Payment {

	/**
	 * Delete payments for a user
	 * 
	 * @param int pUserCode
	 *            Usercode want to delete all payments in database
	 */
	public static void DS_DeletePayment(String pUserCode) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		int OrderId = 0;
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "select * from `order` a inner join fos_user b on a.user_id = b.id where b.user_code ='" + pUserCode + "'" ;
			//System.out.println("Query is: " + query + "\r\n");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
	        rs.last();
	        //System.out.println(" total result set row is: " + rs.getRow() + "\r\n");
	        if (rs.getRow() > 0)
	        	{
	        		rs.first();
	        		OrderId = rs.getInt("id");
	        		query = "delete from `payment_schedule` where order_id ='" +  Integer.toString(OrderId)  + "'" ;
	        		stmt.executeUpdate(query);
	        		//System.out.println("Query is: " + query + "\r\n");
	        		query = "delete from `payment_transaction` where order_id ='" +  Integer.toString(OrderId)  + "'" ;
	        		stmt.executeUpdate(query);
	        		//System.out.println("Query is: " + query + "\r\n");
	        		query = "delete from `order` where id ='" +  Integer.toString(OrderId)  + "'" ;
	        		stmt.executeUpdate(query);
	        		//System.out.println("Query is: " + query + "\r\n");
	        		query = "delete a from `billing_info` a inner join fos_user b on a.user_id = b.id where b.user_code = '" +  pUserCode + "'" ;
	        		stmt.executeUpdate(query);
	        		//System.out.println("Query is: " + query + "\r\n");
	        		query = "update fos_user set `premium_start_date` = null, `premium_end_date`= null, `free_premium_status` = null, `product_id` = null, `incomplete_purchase` = 0 where user_code = '" +  pUserCode + "'" ;
	        		stmt.executeUpdate(query);
	        		//System.out.println("Query is: " + query + "\r\n");
	        		query = "update fos_user set `incomplete_purchase` = 0 where user_code = '" +  pUserCode + "'" ;
	        		stmt.executeUpdate(query);
	        		//System.out.println("Query is: " + query + "\r\n");
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
		
	/**Choose to click an expected Bundle: Basic, Smart, Comfort
	 * @param pBundle
	 *            The Bundle which user wants to buy
	 */
	public static void ChooseBuyBundle(String pBundle) {
		
		generalFunctions.waitForSeconds(2);
		if (pBundle == "BASIC")
		{
			generalFunctions.click(I_Payment.btn_PremiumBASICBundle);
		}
		else if  (pBundle == "SMART")
		{
			generalFunctions.click(I_Payment.btn_PremiumSMARTBundle);
		}	
		else if  (pBundle == "COMFORT")
		{
			generalFunctions.click(I_Payment.btn_PremiumCOMFORTBundle);
		}
	}
	
	/**Choose to click an expected Frequency method of a Payment: Monthly, Quarterly, Semiannual, Onetime
	 * @param pTime
	 *            Frequency method which user wants to buy
	 */
	public static void ChooseFrequencyPayment(String pTime) {
		
		generalFunctions.waitForSeconds(3);
		if (pTime == "Monthly")
		{
			generalFunctions.click(I_Payment.tab_Monthly);
		}
		else if  (pTime == "Quarterly")
		{
			generalFunctions.click(I_Payment.tab_Quarterly);
		}	
		else if  (pTime == "Semiannual")
		{
			generalFunctions.click(I_Payment.tab_SemiAnnual);
		}
		else if  (pTime == "Onetime")
		{
			generalFunctions.click(I_Payment.tab_OneTime);
		}
	}
	
	/**Choose to click SUBMIT button of an expected Frequency method: Monthly, Quarterly, Semiannual, Onetime
	 * @param pTime
	 *            Frequency method which user wants to buy
	 */
	public static void ClickSubmitWhichFrequency(String pTime) {
		
		if (pTime == "Monthly")
		{
			generalFunctions.click(I_Payment.btn_DebitMonthlySubmit);
		}
		else if  (pTime == "Quarterly")
		{
			generalFunctions.click(I_Payment.btn_DebitQuarterlySubmit);
		}	
		else if  (pTime == "Semiannual")
		{
			generalFunctions.click(I_Payment.btn_DebitSemiAnnualSubmit);
		}
		else if  (pTime == "Onetime")
		{
			generalFunctions.click(I_Payment.btn_DebitOneTimeSubmit);
		}
		generalFunctions.waitForElementVisible(I_Payment.btn_Submit);
	}
	
	/**Buy a payment with Credit Card method
	 * @param pBundle
	 *            The Bundle which user wants to buy: BASIC, SMART, COMFORT
	 * @param pFrequency
	 *            Time Method which user wants to buy: Monthly, Quarterly, Semiannual, Onetime
	 * @param pCardNumber
	 *            Value for Card Number field
	 * @param pMonth
	 *            Value for expire month field
     * @param pYear
	 *            Value for expire year field
     * @param pVerificationNumber
	 *            Value 3 digits for Verification Number field
	 */
	public static void BuyPaymentWithCreditCard(String pBundle, String pFrequency, String pCardNumber, String pMonth, String pYear, String pVerificationNumber) {
		
		F_Navigation.GotoDashBoard();
		generalFunctions.click(By.xpath("//div[@class='dashboard__aside']//*[contains(text(),'Jetzt sichern') or contains(text(),'Premium-Mitglied werden')]"));
		ChooseBuyBundle(pBundle);
		ChooseFrequencyPayment(pFrequency);
		
		generalFunctions.click(I_Payment.tab_CreditCard);	
		Constants.Driver.switchTo().frame(Constants.Driver.findElement(By.id("paymentIframe")));
		generalFunctions.sendKeys(I_Payment.txt_CardNumber, pCardNumber);
		generalFunctions.selectDropDownList(I_Payment.slt_ExpireMonth, pMonth);
		generalFunctions.selectDropDownList(I_Payment.slt_ExpireYear, pYear);
		generalFunctions.sendKeys(I_Payment.txt_VerificationNumber, pVerificationNumber);
		Constants.Driver.switchTo().parentFrame();
		//Constants.Driver.switchTo().frame(Constants.OriginalHandle);
		
		//generalFunctions.click(I_Payment.btn_CreditPaymentSubmit);
		ClickSubmitWhichFrequency(pFrequency);
	}
	
	/**Buy a payment with Debit Banking method
	 * @param pBundle
	 *            The Bundle which user wants to buy: BASIC, SMART, COMFORT
	 * @param pFrequency
	 *            Time Method which user wants to buy: Monthly, Quarterly, Semiannual, Onetime
	 * @param pAccountOwner
	 *            Name of Account Owner
	 * @param pIBAN
	 *            value for IBAN field
     * @param pBIC
	 *            value for BIC field
	 */
	public static void BuyPaymentWithDebitBanking (String pBundle, String pFrequency, String pAccountOwner, String pIBAN, String pBIC) {
		
		F_Navigation.GotoDashBoard();
		generalFunctions.click(By.xpath("//div[@class='dashboard__aside']//*[contains(text(),'Jetzt sichern') or contains(text(),'Premium-Mitglied werden')]"));
		ChooseBuyBundle(pBundle);
		ChooseFrequencyPayment(pFrequency);
		
		generalFunctions.click(I_Payment.tab_DebitBanking);
		generalFunctions.sendKeys(I_Payment.txt_AccountOwner, pAccountOwner);
		generalFunctions.sendKeys(I_Payment.txt_IBAN, pIBAN);
		//control has removed
		//generalFunctions.sendKeys(I_Payment.txt_BIC, pBIC);
		
		ClickSubmitWhichFrequency(pFrequency);
	}
	
	/**Fill information at the last step to complete a billing of a payment
	 * @param pFirstName
	 *            Value for First Name field
	 * @param pLastName
	 *            Value for Last Name field
	 * @param pAddress
	 *            Value for Address field
	 * @param pHouseNo
	 *            Value for Address House Number field
     * @param pZip
	 *            vValue for ZipCode field
	 * @param pCity
	 *            vValue for City field
	 * @param pCountry
	 *            vValue for Country field
	 */
	public static void CompletePaymentBilling (String pFirstName, String pLastName, String pAddress, String pHouseNo, String pZip, String pCity) {
		
		generalFunctions.sendKeys(I_Payment.txt_FirstName, pFirstName);
		generalFunctions.sendKeys(I_Payment.txt_LastName, pLastName);
		generalFunctions.sendKeys(I_Payment.txt_AddrStreet, pAddress);
		generalFunctions.sendKeys(I_Payment.txt_AddrHouseNo, pHouseNo);
		generalFunctions.sendKeys(I_Payment.txt_AddrZip, pZip);
		generalFunctions.sendKeys(I_Payment.txt_AddrCity, pCity);

		generalFunctions.click(I_Payment.chb_Confirm);
		generalFunctions.click(I_Payment.btn_Submit);
	}
	
	/**Fill default information at the last step to complete a billing of a payment
	 * @param pFirstName
	 *            Value for First Name field
	 * @param pLastName
	 *            Value for Last Name field
	 * @param pAddress
	 *            Value for Address field
	 * @param pHouseNo
	 *            Value for Address House Number field
     * @param pZip
	 *            vValue for ZipCode field
	 * @param pCity
	 *            vValue for City field
	 * @param pCountry
	 *            vValue for Country field
	 */
	public static void CompletePaymentBilling () {
		
		generalFunctions.sendKeys(I_Payment.txt_FirstName, "AutoTestFirstName");
		generalFunctions.sendKeys(I_Payment.txt_LastName, "AutoTestLastName");
		generalFunctions.sendKeys(I_Payment.txt_AddrStreet, "AutoTestAddress");
		generalFunctions.sendKeys(I_Payment.txt_AddrHouseNo, "AutoTestHouseNo");
		generalFunctions.sendKeys(I_Payment.txt_AddrZip, "02625");
		generalFunctions.sendKeys(I_Payment.txt_AddrCity, "AutoTestCity");

		generalFunctions.click(I_Payment.chb_Confirm);
		
		//Firefox: Support Popup over Submit button, need to scroll before clicking submit to avoid
		JavascriptExecutor jse = (JavascriptExecutor)Constants.Driver;
		WebElement ele = Constants.Driver.findElement(I_Payment.btn_Submit);
		jse.executeScript("arguments[0].scrollIntoView(true);",ele);
		jse.executeScript("scroll(0, 600);");
		generalFunctions.waitForSeconds(2);
		
		generalFunctions.click(I_Payment.btn_Submit);
		generalFunctions.waitForSeconds(15);
		generalFunctions.waitForElementVisible(By.xpath("//a[contains(text(),'Hallo')]"));
	}
	
	/**
	 * Return Order ID of a user base on Usercode
	 * 
	 * @param pUserCode
	 *            Usercode of a user to get Order ID
	 */
	public static int DS_GetOrderID(String pUserCode) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		int OrderId = -1;
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "select a.id from `order` a inner join fos_user b on a.user_id = b.id where b.user_code ='" + pUserCode + "'" ;
			stmt = con.createStatement();
			//System.out.println("Query is: " + query + "\r\n");
			rs = stmt.executeQuery(query);
			rs.last();
	        //System.out.println(" total result set row is: " + rs.getRow() + "\r\n");
	        if (rs.getRow() > 0)
	        		{
	        			rs.first();
	        			OrderId = rs.getInt("id");
		        		//System.out.println("Order ID: " + OrderId + "has ordered for Usercode: " + pUserCode + "\r\n");	
	        		} 
	        else System.out.println("\r\n There is no Payment is ordered for UserCode: " + pUserCode);
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
		return OrderId;
	}
	
	
	/**
	 * Return the expected row number in Payment_Schedule table for each type of Bundle and Frequency
	 * @param pBundle
	 * 		Value for type of Bundle: BASIC, SMART, COMFORT
	 * @param pFrequency
	 *      	Value for type of Frequency: Monthly, Quarterly, Semiannual, OneTime
	 * 
	 */
	public static int GetFrequencyPaymentRowNumber(String pBundle, String pFrequency) {
		
		int row_number = 0;
		
		if (pBundle.equals("BASIC") && pFrequency.equals("Monthly")) row_number = 6;
		else if (pBundle.equals("BASIC") && pFrequency.equals("Quarterly")) row_number = 2;
		else if (pBundle.equals("BASIC") && pFrequency.equals("Semiannual")) row_number = 1;
		else if (pBundle.equals("BASIC") && pFrequency.equals("Onetime")) row_number = 1;
		else if (pBundle.equals("SMART") && pFrequency.equals("Monthly")) row_number = 12;
		else if (pBundle.equals("SMART") && pFrequency.equals("Quarterly")) row_number = 4;
		else if (pBundle.equals("SMART") && pFrequency.equals("Semiannual")) row_number = 2;
		else if (pBundle.equals("SMART") && pFrequency.equals("Onetime")) row_number = 1;
		else if (pBundle.equals("COMFORT") && pFrequency.equals("Monthly")) row_number = 24;
		else if (pBundle.equals("COMFORT") && pFrequency.equals("Quarterly")) row_number = 8;
		else if (pBundle.equals("COMFORT") && pFrequency.equals("Semiannual")) row_number = 4;
		else if (pBundle.equals("COMFORT") && pFrequency.equals("Onetime")) row_number = 1;
		
		return row_number;
	}
	
}
