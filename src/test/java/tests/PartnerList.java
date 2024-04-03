package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Navigation;
import functions.F_PartnerList;
import functions.generalFunctions;
import interfaces.I_HomePage;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AccountVerification;
import verificationFunctions.F_PartnerVerification;
import variables.ConstantLib;
import org.testng.annotations.Listeners;

public class PartnerList extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC008_Vefiy_User_Has_Data_in_Suggestion_Partner_List() 
	{
		
		// Pre-condition
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Constants.Email, Constants.Password);
		F_Navigation.GotoPartnerPage();
		
		F_PartnerList.GoToLastPage();
		F_PartnerVerification.Verify_Matching_User_Number_At_Least(10, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC009_Vefiy_New_Visited_User_Appears_in_Interested_In_Me_List() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveInterest = ConstantLib.UserInit.AccountReceiveInterest;
		String AccountVisitInterest = ConstantLib.UserInit.AccountVisitInterest;
		
		String AccountRecive_Usercode = ConstantLib.UserInit.UserCodeReceiveInterest;
		String AccountVisit_Usercode = ConstantLib.UserInit.UserCodeVisitInterest;
		String AccountVisit_Name = ConstantLib.UserInit.NameAccountVisitInterest;
		//-------------Delete interest in me relationship in database------------------
		F_PartnerList.DS_DeleteAllInterestInMe(AccountRecive_Usercode);
		
		//------------------------TESTCASE----------------------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountVisitInterest + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(AccountRecive_Usercode);
		F_Account.LogOutUser();

		F_Account.LoginUserInLoginPage(AccountReceiveInterest + Constants.EmailDomain, Constants.Password);
	
		F_PartnerVerification.Verify_FirstUser_In_PartnerList_Dashboard(AccountVisit_Usercode,AccountVisit_Name , Result);
		F_Navigation.OpenInterestProfileDashboard(1);
		F_AccountVerification.Verify_UserCode_PartnerProfile(AccountVisit_Usercode, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC020_Vefiy_Favorite_UnFavorite_In_Partner_Profile() 
	{
		
		// Pre-condition-------------------------------------------------------------
		
		String AccountA = ConstantLib.UserInit.AccountVisitInterest;
		String UserCodeB = ConstantLib.UserInit.UserCodeReceiveInterest;
		String AccountB_Name = ConstantLib.UserInit.NameAccountReceiveInterest;
		//Delete all existing favourite of user AccountReceiveInterest
		F_PartnerList.DS_DeleteAllFavourite(AccountA + Constants.EmailDomain);
		
		//------------------------TESTCASE----------------------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountA + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCodeB);
		F_PartnerList.BookmarkFavouriteUser();
		F_Navigation.GoToMyFavouriteList();
			
		F_PartnerVerification.Verify_User_In_FarvouriteList(UserCodeB,1,AccountB_Name , Result);
		F_PartnerList.GoToFavouriteUser(1);
		F_AccountVerification.Verify_UserCode_PartnerProfile(UserCodeB, Result);
		
		F_PartnerList.UnBookmarkFavouriteUser();
		F_Navigation.GoToMyFavouriteList();
		
		F_PartnerVerification.Verify_User_Not_In_FarvouriteList(UserCodeB, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
		
	}
	

	
}
