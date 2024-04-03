package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Hello;
import functions.F_Navigation;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import variables.ConstantLib;
import verificationFunctions.*;

public class Hello extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC017_Vefiy_UI_Hello_PopUp_For_A_Female() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String Account_HelloFemale = ConstantLib.UserInit.AccountHelloFemale;
		String UserCode_HelloFemale = ConstantLib.UserInit.UserCodeHelloFemale;
		
		String Account_HelloFemale_NoAvatar = ConstantLib.UserInit.AccountFemaleNoAvatar;
		String UserCode_HelloFemale_NoAvatar = ConstantLib.UserInit.UserCodeFemaleNoAvatar;
		
		F_Hello.DS_SetStatusOfHello(UserCode_HelloFemale, "0");
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Account_HelloFemale + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoPartnerPage();
		
		F_HelloVerification.Verify_Hello_PopUp_Appear(Result);
		F_Hello.CloseHelloPopUp();
		F_HelloVerification.Verify_Hello_Widget_Appear(Result);
		
		F_Hello.DS_SetStatusOfHello(UserCode_HelloFemale, "2");
		F_Navigation.GotoPartnerPage();
		F_HelloVerification.Verify_Hello_PopUp_Not_Appear(Result);
		F_HelloVerification.Verify_Hello_Widget_Not_Appear(Result);
		F_Account.LogOutUser();
		
		F_Hello.DS_SetStatusOfHello(UserCode_HelloFemale_NoAvatar, "0");
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Account_HelloFemale_NoAvatar + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoPartnerPage();
		F_HelloVerification.Verify_Hello_PopUp_Not_Appear(Result);
		F_HelloVerification.Verify_Hello_Widget_Not_Appear(Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC018_Vefiy_UI_Hello_PopUp_For_A_Male() 
	{
		
		// Pre-condition-------------------------------------------------------------
		String Account_HelloMale = ConstantLib.UserInit.AccountHelloMale;
		String UserCode_HelloMale = ConstantLib.UserInit.UserCodeHelloMale;
		
		String Account_HelloMale_NoAvatar = ConstantLib.UserInit.AccountMaleNoAvatar;
		String UserCode_HelloMale_NoAvatar = ConstantLib.UserInit.UserCodeMaleNoAvatar;
		
		F_Hello.DS_SetStatusOfHello(UserCode_HelloMale, "0");
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Account_HelloMale + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoPartnerPage();
		
		F_HelloVerification.Verify_Hello_PopUp_Appear(Result);
		F_Hello.CloseHelloPopUp();
		F_HelloVerification.Verify_Hello_Widget_Appear(Result);
		
		F_Hello.DS_SetStatusOfHello(UserCode_HelloMale, "2");
		F_Navigation.GotoPartnerPage();
		F_HelloVerification.Verify_Hello_PopUp_Not_Appear(Result);
		F_HelloVerification.Verify_Hello_Widget_Not_Appear(Result);
		F_Account.LogOutUser();
		
		F_Hello.DS_SetStatusOfHello(UserCode_HelloMale_NoAvatar, "0");
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Account_HelloMale_NoAvatar + Constants.EmailDomain, Constants.Password);
		F_Navigation.GotoPartnerPage();
		F_HelloVerification.Verify_Hello_PopUp_Not_Appear(Result);
		F_HelloVerification.Verify_Hello_Widget_Not_Appear(Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
}
