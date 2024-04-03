package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Message;
import functions.F_Photo;
import functions.F_Navigation;
import functions.generalFunctions;
import interfaces.I_HomePage;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_MessageVerification;
import verificationFunctions.F_PhotoVerification;
import variables.ConstantLib;
import variables.ConstantLib.*;
import variables.valueList;


public class Photo extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC016_Vefiy_Share_Unshare_Photo_To_Premium_User() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveSharePhoto = ConstantLib.UserInit.AccountReceiveMessage;
		String AccountSharePhoto= ConstantLib.UserInit.AccountSendMessage;
		String UserCode_ReceiveSharePhoto = ConstantLib.UserInit.UserCodeReceiveMessage;
		String UserCode_ShareSharePhoto = ConstantLib.UserInit.UserCodeSendMessage;
		String TitleMessage = valueList.MessageText.SharePhotoMessageTitle;
		
		//Delete all messages in mail and web before receive Photo message
		F_Account.DeleteAllSpamMail(AccountReceiveSharePhoto, Constants.EmailDomain);
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveSharePhoto + Constants.EmailDomain, Constants.Password);
		generalFunctions.click(I_HomePage.lik_MailBox);
		F_Message.DeleteAllMessages();
		F_Account.LogOutUser();
		//Set Status of SharePhoto icon HAVE TO BE SHARE-ABLE before running testcase----------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveSharePhoto);	
		F_Photo.SetStatusToBeSharePhoto();
		F_Account.LogOutUser();
		
		//------------------------TESTCASE------------------------------------------
		F_Account.LoginUserInLoginPage(AccountReceiveSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ShareSharePhoto);
		F_PhotoVerification.Verify_Partner_Photo_Is_Unshared(Result);
		F_Account.LogOutUser();
		
		F_Account.LoginUserInLoginPage(AccountSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveSharePhoto);
		F_Photo.SharePhotoToAUser();
		F_Account.LogOutUser();
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveSharePhoto + Constants.EmailDomain, Constants.Password);
		generalFunctions.click(I_HomePage.lik_MailBox);
		
		F_MessageVerification.Verify_Receive_Newest_Message(TitleMessage, Result);
		
		F_Navigation.GoToProfileByUserCode(UserCode_ShareSharePhoto);
		F_PhotoVerification.Verify_Partner_Photo_Is_Shared(Result);
		F_Account.LogOutUser();
		
		F_MessageVerification.Verify_Receive_Email_New_SharePhoto(AccountReceiveSharePhoto, Constants.EmailDomain, Result);

		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC021_Vefiy_Share_Unshare_Photo_To_Basic_User() 
	{
		
		// Pre-condition-------------------------------------------------------------
		
		String AccountA = ConstantLib.UserInit.AccountPotentialP0;
		String UserCode_AccountA = ConstantLib.UserInit.UserCodePotentialP0;
		
		String AccountB = ConstantLib.UserInit.AccountSendMessage;
		String UserCode_AccountB = ConstantLib.UserInit.UserCodeSendMessage;
		
		String TitleMessage = valueList.MessageText.SharePhotoMessageTitle;
		
		//Delete all messages in mail and web before receive Photo message
		F_Account.DeleteAllSpamMail(AccountA, Constants.EmailDomain);
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountA + Constants.EmailDomain, Constants.Password);
		generalFunctions.click(I_HomePage.lik_MailBox);
		F_Message.DeleteAllMessages();
		F_Account.LogOutUser();
		//Set Status of SharePhoto icon HAVE TO BE SHARE-ABLE before running testcase----------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountB + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_AccountA);	
		F_Photo.SetStatusToBeSharePhoto();
		F_Account.LogOutUser();
		
		//------------------------TESTCASE------------------------------------------
		F_Account.LoginUserInLoginPage(AccountA + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_AccountB);
		F_PhotoVerification.Verify_Partner_Photo_Is_Unshared(Result);
		F_Account.LogOutUser();
		
		F_Account.LoginUserInLoginPage(AccountB + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_AccountA);
		F_Photo.SharePhotoToAUser();
		F_Account.LogOutUser();
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountA + Constants.EmailDomain, Constants.Password);
		generalFunctions.click(I_HomePage.lik_MailBox);
		
		F_MessageVerification.Verify_Receive_Newest_Message(TitleMessage, Result);
		
		F_Navigation.GoToProfileByUserCode(UserCode_AccountB);
		F_PhotoVerification.Verify_Partner_Photo_Is_Unshared(Result);
		F_Account.LogOutUser();
		
		F_MessageVerification.Verify_Receive_Email_New_SharePhoto(AccountA, Constants.EmailDomain, Result);

		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
}







