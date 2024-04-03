package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Message;
import functions.F_Navigation;
import functions.F_Photo;
import functions.generalFunctions;
import interfaces.I_HomePage;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import variables.valueList;
import verificationFunctions.F_MessageVerification;
import verificationFunctions.F_PhotoVerification;
import variables.ConstantLib;
import org.testng.annotations.Listeners;

public class Message extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC006_Part1_Verify_Premium_User_Can_Send_A_Message_To_Another_User() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMessage = ConstantLib.UserInit.AccountReceiveMessage;
		String AccountSendMessage = ConstantLib.UserInit.AccountSendMessage;
		String UserCode_SendMessage = ConstantLib.UserInit.UserCodeSendMessage;
		String UserCode_ReceiveMessage = ConstantLib.UserInit.UserCodeReceiveMessage;
		String ContainsMessage1 = generalFunctions.randomString("Contains ","",10);
		String ContainsMessage2 = generalFunctions.randomString("Contains ","",10);
		
		//Delete all messages in mail and web before sending message
		//------Confirm with client does not check email
		F_Account.DeleteAllSpamMail(AccountReceiveMessage, Constants.EmailDomain);
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_Message.DeleteAllMessages();
		F_Account.LogOutUser();
		//----------------------------TESTCASE------------------------------------------
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountSendMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveMessage);
		F_Message.SendMessageFromPartnerProfile(UserCode_ReceiveMessage, ContainsMessage1);
		F_MessageVerification.Verify_Sent_Newest_Message(ContainsMessage1, Result);
		F_Account.LogOutUser();
		
		F_Account.LoginUserInLoginPage(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_MessageVerification.Verify_Receive_Newest_Message(ContainsMessage1, Result);
		F_Message.SendMessage(UserCode_SendMessage,ContainsMessage2);
		F_MessageVerification.Verify_Sent_Newest_Message(ContainsMessage2, Result);
		F_Account.LogOutUser();
		
		F_Account.LoginUserInLoginPage(AccountSendMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_MessageVerification.Verify_Receive_Newest_Message(ContainsMessage2, Result);
		
		//------Confirm with client does not check email
		//F_MessageVerification.Verify_Receive_Email_New_Message(AccountReceiveMessage, Constants.EmailDomain, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC006_Part2_Verify_Basic_User_Can_Not_Send_A_Message_To_Another_User() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMessage = ConstantLib.UserInit.AccountFemaleNoAvatar;
		String UserCode_SendMessage = ConstantLib.UserInit.UserCodeSendMessage;
		
		//----------------------------TESTCASE------------------------------------------
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoDashBoard();	
		F_Navigation.GotoMyProfile();
	    F_Account.SetValueDegree("2","");
		F_Navigation.GotoMailBox();	  
		F_MessageVerification.Verify_Premium_Banner_Appear_For_P0_User(UserCode_SendMessage, Result);
		F_Navigation.GotoMyProfile();
		F_Account.SetValueDegree("6","");
		F_Account.SetValueHavingKid("No", "", "");
		F_Navigation.GotoMailBox();	 
		F_MessageVerification.Verify_Premium_Banner_Appear_For_Basic_User(UserCode_SendMessage, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC007_Part1_Verify_User_Can_Send_A_Smiley_To_Another_User_In_Partner_Profile() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMessage = ConstantLib.UserInit.AccountReceiveMessage;
		String AccountSendMessage = ConstantLib.UserInit.AccountSendMessage;
		String UserCode_ReceiveMessage = ConstantLib.UserInit.UserCodeReceiveMessage;
		String TitleMessage = valueList.MessageText.SmileyMessageTitle;
		//Delete all messages in mail and web before sending message
		//F_Account.DeleteAllSpamMail(AccountReceiveMessage, Constants.EmailDomain);		
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_Message.DeleteAllMessages();
		F_Account.LogOutUser();
		//----------------------------TESTCASE------------------------------------------
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountSendMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveMessage);
		F_Message.SendSmileyInProfile();
		F_Account.LogOutUser();
		
		F_Account.LoginUserInLoginPage(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_MessageVerification.Verify_Receive_Newest_Smiley(TitleMessage, Result);
		
		//------Confirm with client does not check email
		//F_MessageVerification.Verify_Receive_Email_New_Smiley_Message(AccountReceiveMessage, Constants.EmailDomain, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC007_Part2_Verify_User_Can_Send_A_Smiley_To_Another_User_In_Messenger() 
	{	
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveMessage = ConstantLib.UserInit.AccountReceiveMessage;
		String AccountSendMessage = ConstantLib.UserInit.AccountSendMessage;
		String UserCode_ReceiveMessage = ConstantLib.UserInit.UserCodeReceiveMessage;
		String TitleMessage = valueList.MessageText.SmileyMessageTitle;
		//Delete all messages in mail and web before sending message
		//F_Account.DeleteAllSpamMail(AccountReceiveMessage, Constants.EmailDomain);		
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_Message.DeleteAllMessages();
		F_Account.LogOutUser();
		//----------------------------TESTCASE------------------------------------------
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountSendMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveMessage);
		F_Message.SendMessageFromPartnerProfile(UserCode_ReceiveMessage, "test");
		F_Message.SendSmileyInMessenger();
		F_MessageVerification.Verify_Sent_Newest_Smiley(TitleMessage, Result);
		F_Account.LogOutUser();
		
		F_Account.LoginUserInLoginPage(AccountReceiveMessage + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_MessageVerification.Verify_Receive_Newest_Smiley(TitleMessage, Result);
		
		//------Confirm with client does not check email
		//F_MessageVerification.Verify_Receive_Email_New_Smiley_Message(AccountReceiveMessage, Constants.EmailDomain, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC007_Part1_Verify_User_Can_SharePhoto_To_Another_User_In_Partner_Profile() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveSharePhoto = ConstantLib.UserInit.AccountReceiveMessage;
		String AccountSharePhoto= ConstantLib.UserInit.AccountSendMessage;
		String UserCode_ReceiveSharePhoto = ConstantLib.UserInit.UserCodeReceiveMessage;
		String UserCode_ShareSharePhoto = ConstantLib.UserInit.UserCodeSendMessage;
		String TitleMessage = valueList.MessageText.SharePhotoMessageTitle;
		
		//Delete all messages in mail and web before receive Photo message
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
		F_Account.LoginUserInLoginPage(AccountSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveSharePhoto);
		F_Photo.SharePhotoToAUser();
		F_Navigation.GotoMailBox();
		F_Message.SelectAUserToSendMessage(UserCode_ReceiveSharePhoto);
		F_MessageVerification.Verify_Send_Newest_SharePhotoMessage(TitleMessage, Result);
		F_Account.LogOutUser();
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_Message.SelectAUserToSendMessage(UserCode_ShareSharePhoto);
		F_MessageVerification.Verify_Receive_Newest_SharePhotoMessage(TitleMessage, Result);
	
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC007_Part2_Verify_User_Can_SharePhoto_To_Another_User_In_Messenger() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String AccountReceiveSharePhoto = ConstantLib.UserInit.AccountReceiveMessage;
		String AccountSharePhoto= ConstantLib.UserInit.AccountSendMessage;
		String UserCode_ReceiveSharePhoto = ConstantLib.UserInit.UserCodeReceiveMessage;
		String UserCode_ShareSharePhoto = ConstantLib.UserInit.UserCodeSendMessage;
		String TitleMessage = valueList.MessageText.SharePhotoMessageTitle;
		
		//Delete all messages in mail and web before receive Photo message
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
		F_Account.LoginUserInLoginPage(AccountSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GoToProfileByUserCode(UserCode_ReceiveSharePhoto);
		F_Message.SendMessageFromPartnerProfile(UserCode_ReceiveSharePhoto, "test");
		F_Message.SharePhotoInMessenger();
		F_MessageVerification.Verify_Send_Newest_SharePhotoMessage(TitleMessage, Result);
		F_Account.LogOutUser();
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountReceiveSharePhoto + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoMailBox();
		F_Message.SelectAUserToSendMessage(UserCode_ShareSharePhoto);
		F_MessageVerification.Verify_Receive_Newest_SharePhotoMessage(TitleMessage, Result);
	
		Assert.assertTrue(Result.Result, Result.Message);		
	}
}
