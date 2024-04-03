package functions;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import functions.generalFunctions;
import interfaces.I_InviteFriend;
import interfaces.I_VisitProfile_Dashboard;
import variables.ConstantLib.Constants;

public class F_PartnerList {


	/**
	 * Go to Last Page in Partner List
	 * 
	 */
	public static void GoToLastPage() {
		
		 List<WebElement> list_PageNumber = Constants.Driver.findElements(By.xpath("//ul[contains(@class,'pagination')]/li"));
	
		 list_PageNumber.get(list_PageNumber.size()-1).click();

	}
	
	/**
	 * Go to First Page in Parter List
	 * 
	 */
	public static void GoToFirstPage() {
		
		 List<WebElement> list_PageNumber = Constants.Driver.findElements(By.xpath("//ul[@class='matching-pagination']/li"));
	
		 list_PageNumber.get(0).click();

	}
	
	/**
	 * Go To expected Page in PartnerList
	 * 
	 * @param int pPageNumber
	 *            Page want to navigate to
	 */
	public static void GoToPage(int pPageNumber) {
		
		 List<WebElement> list_PageNumber = Constants.Driver.findElements(By.xpath("//ul[@class='matching-pagination']/li"));
		 list_PageNumber.get(pPageNumber-1).click();

	}
	
	/**
	 * Click to set Favourite icon to be ON
	 * 
	 */
	public static void BookmarkFavouriteUser() {
	
		generalFunctions.click(I_VisitProfile_Dashboard.img_favourite_off);
	}
	
	/**
	 * Click to set Favourite icon to be OFF
	 * 
	 */
	public static void UnBookmarkFavouriteUser() {
	
		generalFunctions.click(I_VisitProfile_Dashboard.img_favourite_on);
	}
	
	/**
	 * Click to a Favourite profile in Favourite list
	 * 
	 */
	public static void GoToFavouriteUser(int pIndex) {
	
		generalFunctions.click(By.xpath("//li[@class='list-item']["+ pIndex +"]/a"));
	}
	
	/**
	 * Delete all records of a user in 'user_interested' table
	 * 
	 * @param int pUserCode
	 *            Usercode want to delete all Interest In Me contacts
	 */
	public static void DS_DeleteAllInterestInMe(String pUserCode) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "delete a from user_interested a inner join fos_user b on a.user_id = b.id where b.user_code = '" + pUserCode + "'" ;
			//System.out.println("Query is: " + query + "\r\n");
			stmt = con.createStatement();
		    //stmt.executeQuery(query);
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
	 * Delete all records of a user in 'user_interested' table
	 * 
	 * @param int pUserCode
	 *            Usercode want to delete all Interest In Me contacts
	 */
	public static void DS_DeleteAllFavourite(String pUserName) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "Delete a from `favorite` a inner join fos_user b on a.user_id = b.id where b.username ='" + pUserName + "'" ;
			//System.out.println("Query is: " + query + "\r\n");
			stmt = con.createStatement();
		    //stmt.executeQuery(query);
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
}
