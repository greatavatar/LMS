package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import functions.F_AWS;
import functions.F_Account;
import functions.F_Navigation;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AWSVerification;
import variables.ConstantLib;


public class AWS extends DefaultAnnotations
{
	//----------------------Testcase PreContion for all testcases for Worker-------------------------
	
		@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
		public void TC_AWS_001_Precondtion_For_Testcases_Worker_Premium_Zero_Promotion() 
		{
			String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountZeroPrice;
			
			//Edit to make sure this user is Potential PO student
			F_Navigation.goTolmsURL();
			F_Account.LoginUser(AccountReceiveMail + Constants.EmailDomain, Constants.Password);
			F_Navigation.GotoMyProfile();
			F_Account.SetValueDegree("2","");
		}
		
		@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
		public void TC_AWS_002_Precondtion_For_Worker_Testcases_Price_Premium() 
		{
			//Set Complete Profile 2 of a user to be make sure it is stil in 14 days for checking Price_Promotion_Worker
			String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
			String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;
			F_Account.DS_UpdateCompleteProfile2(AccountUserID, "today");
			
			//Edit to make sure this use is NOT Potential PO 
			F_Navigation.goTolmsURL();
			F_Account.LoginUser(AccountReceiveMail + Constants.EmailDomain, Constants.Password);
			F_Navigation.GotoMyProfile();
			F_Account.SetValueDegree("6","");
			F_Account.SetValueHavingKid("No", "", "");
		}
		
	//--------------------------------------------------------------------------------------
		
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_003_Verify_Worker_Of_New_Perfect_Mail() 
	{
		// Pre-condition-------------------------------------------------------------
		
		// UserID of user need to check perfect mail 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;

		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Email_New_Perfect(AccountUserID);
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_Perfect_Matching(AccountReceiveMail, Constants.EmailDomain, Result);

		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_004_Verify_Worker_Of_New_Matching_Mail() 
	{
		// Pre-condition-------------------------------------------------------------
		
		// UserID of user need to check perfect mail 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;
		
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Email_New_Matching(AccountUserID);
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_New_Matching(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	//--------------------------------------------------------------------------------------
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_005_Verify_Worker_Of_Premium_Zero_Promotion_DAY1() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountZeroPrice; 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountZeroPrice;
	
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Premium_Zero_Promotion(AccountUserID,"DAY_1");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_DAY1(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_006_Verify_Worker_Of_Premium_Zero_Promotion_DAY4() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountZeroPrice; 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountZeroPrice;
	
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Premium_Zero_Promotion(AccountUserID,"DAY_4");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_DAY4(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_007_Verify_Worker_Of_Premium_Zero_Promotion_DAY28() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountZeroPrice; 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountZeroPrice;
	
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Premium_Zero_Promotion(AccountUserID,"DAY_28");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_DAY28(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_008_Verify_Worker_Of_Premium_Zero_Promotion_STUDENT_DAY_1() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountZeroPrice; 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountZeroPrice;
	
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Premium_Zero_Promotion(AccountUserID,"STUDENT_DAY_1");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_STUDENT_DAY_1(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_009_Verify_Worker_Of_Premium_Zero_Promotion_STUDENT_DAY_28() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountZeroPrice; 
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountZeroPrice;
	
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Premium_Zero_Promotion(AccountUserID,"STUDENT_DAY_28");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_STUDENT_DAY_28(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_010_Verify_Worker_Of_Price_Promotion_DAY0() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;
		
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Email_Price_Promotion(AccountUserID,"DAY_0");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY0(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_011_Verify_Worker_Of_Price_Promotion_DAY6() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;
		
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Email_Price_Promotion(AccountUserID,"DAY_6");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY6(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_012_Verify_Worker_Of_Price_Promotion_DAY7() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;
		
		//Delete all messages in mail and web before receive Photo message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Email_Price_Promotion(AccountUserID,"DAY_7");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY7(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC_AWS_013_Verify_Worker_Of_Price_Promotion_DAY13() 
	{
		// Pre-condition-------------------------------------------------------------
		String AccountUserID = ConstantLib.UserInit.Worker_UserIDAccountPricePromotion;
		String AccountReceiveMail = ConstantLib.UserInit.Worker_AccountPricePromotion;
		
		//Delete all messages in mail and web before receive message
		F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
		
		F_AWS.SendWorker_Email_Price_Promotion(AccountUserID,"DAY_13");
		F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY13(AccountReceiveMail, Constants.EmailDomain, Result);
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	
	
}
