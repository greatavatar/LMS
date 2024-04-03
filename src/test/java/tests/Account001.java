package tests;

import java.util.Random;

//import org.openqa.selenium.JavascriptExecutor;
//import org.yaml.snakeyaml.scanner.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Navigation;
import functions.generalFunctions;
import interfaces.I_HomePage;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AccountVerification;
import verificationFunctions.generalVerification;
import variables.ConstantLib;
import org.testng.annotations.Listeners;

public class Account001 extends DefaultAnnotations
{
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC003_Log_in_Account_HomePage() 
	{

		F_Navigation.goTolmsURL();
		
		//Normally login
		F_Account.LoginUser(ConstantLib.Constants.Email,ConstantLib.Constants.Password);
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);
		F_Account.LogOutUser();
		
		//Login by Facebook account
		F_Navigation.GotoDashBoard();
		F_Account.LoginUser(Constants.EmailFacebook, Constants.PasswordFacebook, "facebook");
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);
		F_Account.LogOutUser();
		
		//Login by Google account
		F_Navigation.GotoDashBoard();
		F_Account.LoginUser(Constants.EmailGoogle, Constants.PasswordGoogle, "google");
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);

		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC004_Log_in_Account_LoginPage() 
	{	

		F_Navigation.goTolmsURL();
		//Normally login
		F_Account.LoginUserInLoginPage(ConstantLib.Constants.Email,ConstantLib.Constants.Password);
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);
		F_Account.LogOutUser();
		
		//Login by Facebook account
		F_Account.LoginUserInLoginPage(Constants.EmailFacebook, Constants.PasswordFacebook, "facebook");
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);
		F_Account.LogOutUser();
		
		//Login by Google account
		F_Account.LoginUserInLoginPage(Constants.EmailGoogle, Constants.PasswordGoogle, "google");
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);

		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	public void TC005_Verify_User_can_create_new_account_successfully() 
	{
		// Pre-condition
		String[] ListSex={"male", "female"};
		String[] ListStuden={"Yes", "No"};
		String[] LisHaveChildren={"Yes", "No"};
        String Sex = (ListSex[new Random().nextInt(ListSex.length)]);
        String Studen = (ListSex[new Random().nextInt(ListSex.length)]);
        String Children = (ListSex[new Random().nextInt(ListSex.length)]);
        
		F_Navigation.goTolmsURL();
		F_Account.CreateAccount(generalFunctions.randomNumber(4), Constants.Password,Sex);
		
		F_AccountVerification.accountCreatedSuccessfully(Result);  
		Assert.assertTrue(Result.Result, Result.Message);
	}
	
	
	
}
