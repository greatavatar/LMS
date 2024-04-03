package verificationFunctions;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.yaml.snakeyaml.scanner.Constant;

import functions.F_API;
import functions.F_Account;
import functions.F_Worker;
//import functions.generalFunctions;
//import interfaces.I_HomePage;
import variables.ConstantLib.Constants;
import variables.SQLUser;
import variables.TCResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class F_PartnerVerification {

	/**
	 * Verify account is created successfully
	 * 
	 * @param pAccount
	 *            Account needs to verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_Matching_User_Number_At_Least(int pMatchingUserNumber,TCResult pResult) {

		String CurrentUrl = Constants.Driver.getCurrentUrl();
		
		String [] parts = CurrentUrl.split("=");
		int MatchingUserNumber = Integer.parseInt(parts[1]);
		
		if(MatchingUserNumber < pMatchingUserNumber)
		{
			pResult.SetMessage("Current MatchingNumber is " + MatchingUserNumber + " < " + pMatchingUserNumber + " Expected Number");
			pResult.SetResult(false);
		}
				
	}
	
	 /* Verify UserCode and Name for first profile in PartnerList in Dashboard
	 * 
	 * @param pUserCode
	 *            UserCode need to check
	 *   @param pName
	 *            Name need to check         
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_FirstUser_In_PartnerList_Dashboard(String pUserCode,String pName,TCResult pResult) {

		String Profile_href = Constants.Driver.findElement(By.xpath("//div[contains(@class,'testInterestInMe')]//li[1]/a")).getAttribute("href");
		String FirstProfileUserCode = Profile_href.split("code=")[1].split("&")[0];
		if(!pUserCode.equals(FirstProfileUserCode))
		{
			pResult.SetResult(false);
			pResult.SetMessage("UserCode: " + FirstProfileUserCode + " appears instead " + pUserCode  + " for First Profile in PartnerList");
		}
		
		/*String FirstProfileName = Constants.Driver.findElement(By.xpath("//div[contains(@class,'testInterestInMe')]//li[1]//span[contains(@class,'job-age')][1]")).getText().split(",")[0];
		if( (!pUserCode.equals(FirstProfileUserCode)) || (!pName.equals(FirstProfileName)))
		{
			pResult.SetResult(false);
			pResult.SetMessage("UserCode: " + FirstProfileUserCode + " appears instead " + pUserCode  + ",Name: " + FirstProfileName +  " instead " + pName + " for First Profile in PartnerList");
		}*/
						
	}
	
	
	
	 /* Verify UserCode and Name for first profile in PartnerList in Dashboard
	 * 
	 * @param pUserCode
	 *            UserCode need to check
	 *   @param pName
	 *            Name need to check         
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_User_In_FarvouriteList(String pUserCode,int pIndex,String pName,TCResult pResult) {

		String Profile_href = Constants.Driver.findElement(By.xpath("//li[@class='list-item']["+ pIndex +"]/a")).getAttribute("href");
		String ProfileUserCode = Profile_href.split("code=")[1].split("&")[0];
		String ProfileName = Constants.Driver.findElement(By.xpath("//li[@class='list-item']["+ pIndex +"]//strong[contains(@class,'text-capitalized')]")).getText().split(",")[0];
		if( (!pUserCode.equals(ProfileUserCode)) || (!pName.toUpperCase().equalsIgnoreCase(ProfileName)))
		{
			pResult.SetResult(false);
			pResult.SetMessage("UserCode: " + ProfileUserCode + " appears instead " + pUserCode  + ",Name: " + ProfileName +  " instead " + pName + " for expected Profile in FavouriteList");
		}
				
	}
	
	 /* Verify UserCode and Name for first profile in PartnerList in Dashboard
	 * 
	 * @param pUserCode
	 *            UserCode need to check
	 *   @param pName
	 *            Name need to check         
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_User_Not_In_FarvouriteList(String pUserCode,TCResult pResult) {

		List<WebElement> list_favourite =  Constants.Driver.findElements(By.xpath("//li[@class='list-item']/a"));
		for (int i=0;i<list_favourite.size(); i++)
		{
			String Profile_href = list_favourite.get(i).getAttribute("href");;
			String ProfileUserCode = Profile_href.split("code=")[1].split("&")[0];
			if(ProfileUserCode.equals(pUserCode))
			{
				pResult.SetResult(false);
				pResult.SetMessage("UserCode: " + ProfileUserCode + " should not appears in FavouriteList");

			}
		}
			
	}
	
	/**
	 * Verify API Matching List for a random user return data not null
	 * 
	 * @param pArrayUser
	 *            An array of User objects
	 * @param pResult
	 *            Result of the test case
	 */
	public static void API_Verify_Matching_List_For_A_Random_User_Has_Data(TCResult pResult) {
		
		SQLUser user = F_Account.DS_GetRandomAUser();
		user.setSQL_UserName("email-3840@yopmail.com");
		System.out.println(user.getSQL_UserName());
		System.out.println("------Verifing UserName " + user.getSQL_UserName() + " has data in Matching Partner List");
		String accessToken = F_API.GetAccessTokenOfAUser(user.getSQL_UserName(), user.getSQL_Password());
		System.out.println(" accessToken = " + accessToken);
		int TotalMatchNumber = F_API.GetTotalNumberMatchingNumber(accessToken);
		System.out.println(" total number = " + TotalMatchNumber);
		
		if(TotalMatchNumber < 1)
		{
			pResult.SetResult(false);
			pResult.SetMessage("API MatchingList call for UserName: " + user.getSQL_UserName() + " does not appears any data");
		}
	}

	/**
	 * Verify API Matching List for all users return data not null
	 * 
	 * @param pArrayUser
	 *            An array of User objects
	 * @param pResult
	 *            Result of the test case
	 */
	public static void API_Verify_Matching_List_For_All_Users_Has_Data(TCResult pResult) {
		
		String query = "select a.id,a.username,a.dob,b.gender, b.gender_search,b.income_from,b.income_to,b.country,b.education_highest_degree from fos_user a inner join user_profile b on a.id = b.user_id where a.complete_profile_2_at is not null and a.username not like '%user_deleted%' order by a.id asc";
		//String query = "select * from ( select a.id,a.username,a.dob,b.gender, b.gender_search,b.income_from,b.income_to,b.country,b.education_highest_degree from fos_user a inner join user_profile b on a.id = b.user_id where a.complete_profile_2_at is not null and a.username not like '%user_deleted%' order by a.id asc) as tmp1, (SELECT RAND() * (SELECT MAX(id)-10 FROM fos_user) AS tid) AS tmp2 where tmp1.id >= tmp2.tid limit 10";
		Map<String, SQLUser> ArraySQLUser = new HashMap<String, SQLUser>();
		ArraySQLUser = F_Account.DS_GetValuesOfUsers(query, ArraySQLUser);

		int i = 0;
		for(Map.Entry<String, SQLUser> entry : ArraySQLUser.entrySet()) {
		    String key = entry.getKey();
		    SQLUser user = entry.getValue();
		    System.out.println(user.getSQL_UserName());
		    i = i + 1;
		    String accessToken = F_API.GetAccessTokenOfAUser(user.getSQL_UserName(),"xxxxxxx");
			int matchingPartnerMember = F_API.GetTotalNumberMatchingNumber(accessToken);
			System.out.println("--matchingPartnerMember: " + matchingPartnerMember);
			if(matchingPartnerMember < 1)
			{
				pResult.SetResult(false);
				pResult.SetMessage("API MatchingList call for UserName: " + user.getSQL_UserName() + " does not appears any data");
			}
		    
		}
		 System.out.println("Verified for total user: " + i);
     
	}
	
	
	/**
	 * Verify API Matching List for all users return data not null
	 */
	public static void API_Verify_Matching_List_For_All_Users_Has_Data_By_Threads(int pTotalRunUserNumber, int pNumberUserPerThread ,TCResult pResult) {
		
		//String query = "select username from fos_user a inner join user_profile b on a.id = b.user_id where a.complete_profile_2_at is not null and a.username not like '%user_deleted%' order by a.id desc"; 
		String query = "select * from (select a.id,a.username from fos_user a inner join user_profile b on a.id = b.user_id where a.complete_profile_2_at is not null and a.username not like '%user_deleted%' ) as tmp1, (SELECT RAND() * (SELECT MAX(id)-10 FROM fos_user) AS tid) AS tmp2 where tmp1.id >= tmp2.tid limit " + pTotalRunUserNumber;
		String[] arr_UserName = F_Account.DS_GetValuesInAColumn(query, "username").split(",");
		ExecutorService executor = Executors.newFixedThreadPool(8);
	        int totalrecord = pTotalRunUserNumber;
	        int from = 0;
			int limit = pNumberUserPerThread;
			int to = 0;
			int count = 0;
			while (from - 1 + limit <= totalrecord ) 
			{
				to = from - 1 + limit;
				Runnable worker = new F_Worker(arr_UserName,from,to,limit,pResult);
				executor.execute(worker);
				from = to + 1;
				count = count + 1;
			}
			
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	        }
	        System.out.println("Finished all threads");
	        System.out.println("-----------total--------" + count);
	     
	}
	
	/**
	 * Verify API Matching List for a random user return data not null
	 * 
	 * @param pArrayUser
	 *            An array of User objects
	 * @param pResult
	 *            Result of the test case
	 */
	public static void API_Verify_Matching_List_For_List_User_Has_Data(String[] pArrUserNames,int pFrom, int pTo,int pTotalPerThread, TCResult pResult) {
		
		for(int i=pFrom;i<=pTo;i++)
		{
			try
			{
				System.out.println("i = " + i + " ------Verifing UserName " + pArrUserNames[i] + " has data in Matching Partner List");
				String accessToken = F_API.GetAccessTokenOfAUser(pArrUserNames[i],"xxxxxxx");
				int matchingPartnerMember = F_API.GetTotalNumberMatchingNumber(accessToken);
				System.out.println("--matchingPartnerMember: " + matchingPartnerMember);
				if(matchingPartnerMember < 1)
				{
					pResult.SetResult(false);
					pResult.SetMessage("API MatchingList call for UserName: " + pArrUserNames[i] + " does not appears any data");
				}
			}
			catch(Exception e)
			{
				System.out.println("--pFrom: " + pFrom + "--pTo: " + pTo + "--i: " + i );
				e.printStackTrace();	
			}
		
		}
		
	}
	
}
