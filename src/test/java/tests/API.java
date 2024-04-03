package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Hello;
import functions.F_Navigation;
import interfaces.I_DashboardPage;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import variables.ConstantLib;
import verificationFunctions.*;

public class API extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC022_Verify_API_Matching_List_Score_For_A_Random_User() 
	{
//		for(int i = 0;i<10;i++)
//		{
//			F_PartnerVerification.API_Verify_Matching_List_For_A_Random_User_Has_Data(Result);
//	
//		}
		//----Run with a Random user
		F_PartnerVerification.API_Verify_Matching_List_For_A_Random_User_Has_Data(Result);
		//-----Run with Multi-User
		/*int TotalRunUserNumber = 50;
		int NumberUserPerThread = 10;
		F_PartnerVerification.API_Verify_Matching_List_For_All_Users_Has_Data_By_Threads(TotalRunUserNumber,NumberUserPerThread,Result);*/			
		Assert.assertTrue(Result.Result, Result.Message);
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_Verify_Mail_Matching_InterestInMe_lists_has_data() 
	{
		String AccountReceiveMessage = ConstantLib.UserInit.AccountReceiveMessage;
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		
		generalVerification.verifyElementVisible( I_DashboardPage.pnl_MailBoxSection , "Mailbox data", Result);
		generalVerification.verifyElementVisible( I_DashboardPage.pnl_MatchingSection , "Matching List data", Result);
		generalVerification.verifyElementVisible( I_DashboardPage.pnl_InterestInMeSection , "Interest In Me data", Result);
		generalVerification.verifyElementVisible( I_DashboardPage.pnl_PerfectMatchSection , "PerfectMatch data", Result);

	}
}
