package verificationFunctions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import functions.F_Account;
import functions.F_Navigation;
import functions.generalFunctions;
import interfaces.I_DashboardPage;
import interfaces.I_HomePage;
import interfaces.I_MyProfile;
import variables.ConstantLib.Constants;
import variables.ESUser;
import variables.SQLUser;
import variables.TCResult;

public class F_AccountVerification {

	/**
	 * Verify account is created successfully
	 * 
	 * @param pAccount
	 *            Account needs to verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void accountCreatedSuccessfully(TCResult pResult) {

		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile Image", pResult);
		By byPannelPremium = By.xpath("//div[@class='dashboard__aside']//div[contains(@class,'premium')]");
		generalVerification.verifyElementVisible(byPannelPremium, "My Profile Image", pResult);
			
	}
	
	/**
	 * Verify account is created successfully
	 * 
	 * @param pAccount
	 *            Account needs to verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_UserCode_PartnerProfile(String pUserCode,TCResult pResult) {
		String ProfileUserCode = Constants.Driver.getCurrentUrl().split("code=")[1].split("&")[0];
		if(!ProfileUserCode.equals(pUserCode))
		{
			pResult.SetResult(false);
			pResult.SetMessage("UserCode: " + ProfileUserCode + " instead " + pUserCode + " in Profile which is visiting");

		}
	}
	
	/**
	 * Verify the percentage number in Statistic table (Dashboard) and percentage in MyProfile are equal
	 * 
	 */
	public static void Verify_Value_Percentage_Statistic_Table(TCResult pResult) {
		int topPercent = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_TopPercent_Statistic).split("%")[0]);
		int midPercent = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_MiddlePercent_Statistic).split("%")[0]);
		F_Navigation.GotoMyProfile();
		int myProfilePercent = Integer.parseInt(generalFunctions.getTextOfElement(I_MyProfile.lbl_PercentNumber).split(" ")[0]);
		
		if ( (topPercent != midPercent) || (topPercent != myProfilePercent) || (myProfilePercent != midPercent))
		{
			pResult.SetResult(false);
			pResult.SetMessage("Percentage Number displays incorrectly");

		}
	}
	
	
	/**
	 * Verify the unread mail number in Statistic table (Dashboard)
	 * 
	 */
	public static void Verify_Value_MailNumber_Statistic_Table(TCResult pResult) {
				
		int MailNumber_Statistic = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_UnreadMailNumber_Statistic));
		int MailNumber_Pusher = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.img_PusherUnreadMailNumber));
		int MailNumber_Total = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_TotalUnreadMailNumber));
		
		if ( (MailNumber_Statistic != MailNumber_Pusher) || (MailNumber_Statistic != MailNumber_Total) || (MailNumber_Pusher != MailNumber_Total))
		{
			pResult.SetResult(false);
			pResult.SetMessage("Unread Mail Number displays incorrectly");

		}
	}
	
	/**
	 * Verify Interest In Me number in Statistic table (Dashboard)
	 * 
	 */
	public static void Verify_Value_InterestInMe_Statistic_Table(TCResult pResult) {
				
		int InterestInMe_Statistic = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_InterestNumber_Statistic));
		int InterestInMe_Pusher = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.img_PusherInterestNumber));
		
				
		if (InterestInMe_Statistic != InterestInMe_Pusher)
		{
			pResult.SetResult(false);
			pResult.SetMessage("Interest In Me number displays incorrectly:");

		}
	}
	
	/**
	 * Verify Total Matching Partner number in Statistic table (Dashboard)
	 * 
	 */
	public static void Verify_Value_TotalPartner_Statistic_Table(TCResult pResult) {
				
		int TotalPartner_Statistic = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_MatchingNumber_Statistic));
		int TotalPartner_DashboardSection = Integer.parseInt(generalFunctions.getTextOfElement(I_DashboardPage.lbl_TotalMatchingNumber));
		
				
		if (TotalPartner_Statistic != TotalPartner_DashboardSection)
		{
			pResult.SetResult(false);
			pResult.SetMessage("Total Matching Partner number displays incorrectly:");

		}
	}
	
	
	/**
	 * Is the data of Country, Gender, GenderSearch, IncomeFrom, IncomeTo, Dob FOR A USER between ES and MySQL are synchronized 
	 * 
	 * @param User
	 *            An object user
	 * @param pResult
	 *            Result of the test case
	 */
	public static void ES_DS_Verify_Data_Synchronize_Between_ES_MYSQL_For_A_User(SQLUser pSQLUser, Map<String, ESUser> pArrayESUser, TCResult pResult) {
		
		boolean flag = true;
		String error = "";
		ESUser ES_user= pArrayESUser.get(pSQLUser.getSQL_UserId());
		if (ES_user != null)
		{
			
			//System.out.println("----compare-----SQL_UserID = " + pSQLUser.getSQL_UserId() + " ES_UserID " + ES_user.getES_UserId());
			if(!pSQLUser.getSQL_UserId().equals(ES_user.getES_UserId()))
			{
				flag = false;
				error = error + "------MySQL UserID = " + pSQLUser.getSQL_UserId() + " but ES UserID = " + ES_user.getES_UserId() + "\r\n";
			}
		
			//System.out.println("----compare-----SQL_Age = " + pUser.getSQL_Age() + " ES_Age " + pUser.getES_Age());
			if(!pSQLUser.getSQL_Age().equals(ES_user.getES_Age()))
			{
				flag = false;
				error = error + "------MySQL Dob = " + pSQLUser.getSQL_Age() + " but ES Dob = " + ES_user.getES_Age() + "\r\n";
			}
		
			//System.out.println("----compare-----SQL_Country = " + pUser.getSQL_Country() + " ES_Country " + pUser.getES_Country());
			if(!pSQLUser.getSQL_Country().equals(ES_user.getES_Country()))
			{
				flag = false;
				error = error + "------MySQL Country = " + pSQLUser.getSQL_Country() + " but ES Country = " + ES_user.getES_Country() + "\r\n";
			}
		
			//System.out.println("----compare-----SQL_Gender = " + pUser.getSQL_Gender() + " ES_Gender " + pUser.getES_Gender());
			if(!pSQLUser.getSQL_Gender().equals(ES_user.getES_Gender()))
			{
				flag = false;
				error = error + "------MySQL Gender = " + pSQLUser.getSQL_Gender() + " but ES Gender = " + ES_user.getES_Gender() + "\r\n";
			}
		
			//System.out.println("----compare-----SQL_GenderSearch = " + pUser.getSQL_GenderSearch() + " ES_GenderSearch " + pUser.getES_GenderSearch());
			if(!pSQLUser.getSQL_GenderSearch().equals(ES_user.getES_GenderSearch()))
			{
				flag = false;
				error = error + "------MySQL Gender Search = " + pSQLUser.getSQL_GenderSearch() + " but ES Gender Search = " + ES_user.getES_GenderSearch() + "\r\n";
			}
		
			//System.out.println("----compare-----SQL_IncomeFrom = " + pUser.getSQL_IncomeFrom() + " ES_IncomeFrom " + pUser.getES_IncomeFrom());
			if(!pSQLUser.getSQL_IncomeFrom().equals(ES_user.getES_IncomeFrom()))
			{
				flag = false;
				error = error + "------MySQL IncomeFrom = " + pSQLUser.getSQL_IncomeFrom() + " but ES IncomeFrom = " + ES_user.getES_IncomeFrom() + "\r\n";
			}
	
			//System.out.println("----compare-----SQL_IncomeTo = " + pUser.getSQL_IncomeTo() + " ES_IncomeTo " + pUser.getES_IncomeTo());
			if(!pSQLUser.getSQL_IncomeTo().equals(ES_user.getES_IncomeTo()))
			{
				flag = false;
				error = error + "------MySQL IncomeTo = " + pSQLUser.getSQL_IncomeTo() + " but ES IncomeTo = " + ES_user.getES_IncomeTo() + "\r\n";
			}
			
			//System.out.println("----compare-----SQL_Education = " + pSQLUser.getSQL_Education() + " getES_Education =" + ES_user.getES_Education());
			if(!pSQLUser.getSQL_Education().toLowerCase().equals(ES_user.getES_Education().toLowerCase()))
			{
				flag = false;
				error = error + "------MySQL Education = " + pSQLUser.getSQL_Education() + " but ES Education = " + ES_user.getES_Education() + "\r\n";
			
			}
			
		}
		else
		{
			flag = false;
			error = error + "------UserID: " + pSQLUser.getSQL_UserId() + " DOES NOT EXIST in ES";
		}
		if(flag == false)
		{
			pResult.SetResult(false);
			pResult.SetMessage("UserID: " + pSQLUser.getSQL_UserId() + " got the wrong data ");
			pResult.SetMessage(error);
		}
		
		
	}
	
	/**
	 * Is the data of Country, Gender, GenderSearch, IncomeFrom, IncomeTo, Dob FOR ALL USER between ES and MySQL are synchronized 
	 * 
	 * @param pArrayUser
	 *            An array of User objects
	 * @param pResult
	 *            Result of the test case
	 */
	public static void ES_DS_Verify_Data_Synchronize_Between_ES_MYSQL_For_All_Users(TCResult pResult) {
		
		
		
		//String userIDs = "81,13686,42613,47510,47660,51808,54430,54967,57537,57722,57756,57972,60648,60763,60782,60813,60847,60899,61048,61050,61064,61081,61116,61132,61201,6382,10743,10876,11027,43668,8415,8417,8926,13195,17634,34364,34939,42811,47314,54450,57508,57710,57712,57803,58035,60595,60643,60936,61052,61079,61111,61143,2544,6288,7088,18695,19156,35841,46830,50835,54241,54366,56781,57349,57369,59757,59764,59966,59973,60100,60132,60300,62960,29041,29332,33183,49513,49672,53491,53541,56074,56417,56456,58982,59289,59657,59659,62022,62213,62288,62415,62506,54048,57221,57255,59760,59928,59963,60031,60062,60178,60248,60331,62818,5379,5829,19399,20220,32519,44806,58524,58793,61349,61350,61366,61401,61450,61548,61683,61950,61985,62000,774,4802,8946,17688,17971,42924,43408,47638,47972,48090,51847,54538,60691,60906,61008,61042,61089,61122,61226,2227,10550,10851,14063,18910,27181,31910,35604,36039,46753,54187,56894,57215,59804,59921,60356,60357,62780,62797,62828,62913,7293,7459,12609,20447,25393,29956,33799,38061,53237,56394,56545,56561,59317,59369,59503,59537,59621,62261,62361,62596,62647,62733,62740,62751,1474,1615,5266,5525,5527,5970,10282,36318,40682,44699,45224,52087,52135,52144,52228,55656,58453,58864,58937,58948,61336,61688,61797,61813,61999,3373,7600,16127,21358,49970,53278,55903,56585,58991,59279,59546,59645,62069,62084,62153,62317,62551,62568,62585,62670,62685,62687,8334,8600,12844,13698,30051,38489,38793,42612,47549,54642,54919,58138,60642,60644,60712,60810,60828,60862,60944,60996,61069,61137,61255,10783,14125,26959,31971,36251,46888,51002,53681,56784,59815,59890,59915,59924,59985,60124,60192,60192,60308,60333,60374,60383,60442,62857,62868,62941,62943,62966,12101,16806,20627,25389,37423,45579,46145,53149,59165,59281,59290,59542,59583,59608,59622,62021,62048,62116,62148,62291,62600,62757,5619,15404,24301,27920,44648,52120,52227,52247,58193,58313,61380,61430,61639,61698,61739,61746,61764,61780,62728,9516,9632,10185,19257,19477,24056,24272,27831,44393,48657,52499,58215,58215,58465,58751,61289,61406,61576,61576,61624,61660,61692,61908,61976,61839,61839,61846,61882,61921,61964";
		//String userIDs = "2447";
		
		int totalrecord = F_Account.DS_GetToTalNumberOfAllUsers();
		//int totalrecord = 45000;
		int offset = 0;
		int limit = 500;
		int number1round = totalrecord/limit + 1;
		
		for(int j = 0; j< number1round; j++)
		{
			Map<String, SQLUser> ArraySQLUser = new HashMap<String, SQLUser>();
			Map<String, ESUser> ArrayESUser = new HashMap<String, ESUser>();
				
			String userIDs = F_Account.DS_GetValuesInAColumn("select id from fos_user where username not like '%user_deleted%' order by id desc limit " + limit + " OFFSET " + offset, "id");
			//String userIDs = "31,38,26";
			//String userIDs = "81,13686,42613,47510,47660,51808,54430,54967,57537,57722,57756,57972,60648,60763,60782,60813,60847,60899,61048,61050,61064,61081,61116,61132,61201,6382,10743,10876,11027,43668,8415,8417,8926,13195,17634,34364,34939,42811,47314,54450,57508,57710,57712,57803,58035,60595,60643,60936,61052,61079,61111,61143,2544,6288,7088,18695,19156,35841,46830,50835,54241,54366,56781,57349,57369,59757,59764,59966,59973,60100,60132,60300,62960,29041,29332,33183,49513,49672,53491,53541,56074,56417,56456,58982,59289,59657,59659,62022,62213,62288,62415,62506,54048,57221,57255,59760,59928,59963,60031,60062,60178,60248,60331,62818,5379,5829,19399,20220,32519,44806,58524,58793,61349,61350,61366,61401,61450,61548,61683,61950,61985,62000,774,4802,8946,17688,17971,42924,43408,47638,47972,48090,51847,54538,60691,60906,61008,61042,61089,61122,61226,2227,10550,10851,14063,18910,27181,31910,35604,36039,46753,54187,56894,57215,59804,59921,60356,60357,62780,62797,62828,62913,7293,7459,12609,20447,25393,29956,33799,38061,53237,56394,56545,56561,59317,59369,59503,59537,59621,62261,62361,62596,62647,62733,62740,62751,1474,1615,5266,5525,5527,5970,10282,36318,40682,44699,45224,52087,52135,52144,52228,55656,58453,58864,58937,58948,61336,61688,61797,61813,61999,3373,7600,16127,21358,49970,53278,55903,56585,58991,59279,59546,59645,62069,62084,62153,62317,62551,62568,62585,62670,62685,62687,8334,8600,12844,13698,30051,38489,38793,42612,47549,54642,54919,58138,60642,60644,60712,60810,60828,60862,60944,60996,61069,61137,61255,10783,14125,26959,31971,36251,46888,51002,53681,56784,59815,59890,59915,59924,59985,60124,60192,60192,60308,60333,60374,60383,60442,62857,62868,62941,62943,62966,12101,16806,20627,25389,37423,45579,46145,53149,59165,59281,59290,59542,59583,59608,59622,62021,62048,62116,62148,62291,62600,62757,5619,15404,24301,27920,44648,52120,52227,52247,58193,58313,61380,61430,61639,61698,61739,61746,61764,61780,62728,9516,9632,10185,19257,19477,24056,24272,27831,44393,48657,52499,58215,58215,58465,58751,61289,61406,61576,61576,61624,61660,61692,61908,61976,61839,61839,61846,61882,61921,61964";
			//System.out.println(userIDs);
			
			String ESquery = "{\"sort\":[{\"user_id\":{\"order\":\"asc\"}}],\"from\":0,\"size\":10000,\"query\":{\"terms\":{\"user_id\":[" + userIDs + "]}}}";
			//System.out.println(ESquery);

			ArraySQLUser = F_Account.DS_GetValuesOfUsers("select a.id,a.username, a.dob,b.gender, b.gender_search,b.income_from,b.income_to,b.country,b.education_highest_degree from fos_user a inner join user_profile b on a.id = b.user_id where a.id in (" + userIDs + ") order by a.id asc", ArraySQLUser);
			ArrayESUser = F_Account.ES_GetValuesOfUsers(ESquery, ArrayESUser);
		
			System.out.println("---------------------Round " + j +" :Numbers of SQL users SQL =  " + ArraySQLUser.size() + "--------------------Numbers of ES users  = " + ArrayESUser.size());
			
			for(Map.Entry<String, SQLUser> entry : ArraySQLUser.entrySet())
			{
				String key = entry.getKey();
				ES_DS_Verify_Data_Synchronize_Between_ES_MYSQL_For_A_User(ArraySQLUser.get(key), ArrayESUser , pResult);
				
			}
			offset = offset + limit;
			
		}
				
	}
	
		
}