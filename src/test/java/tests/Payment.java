package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Navigation;
import functions.F_Payment;
import interfaces.I_HomePage;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_PaymentVerification;
import verificationFunctions.generalVerification;
import variables.ConstantLib;
import org.testng.annotations.Listeners;

public class Payment extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC010_Vefiy_User_Buy_A_BASIC_MONTHLY_Promotion_Bundle_By_CREADIT_CARD() 
	{
		
		// Pre-condition
		String AccountPayment = ConstantLib.UserInit.AccountPayment;	
		String AccountPayment_Usercode = ConstantLib.UserInit.UserCodeAccountPayment;
		
		//Data for buying Credit Card flow
		String Bundle = ConstantLib.PaymentInit.BasicBundle;
		String FrequencyCC = ConstantLib.PaymentInit.MontlyFrequency;
		String CardNumber = ConstantLib.PaymentInit.CardNumber;

		//Delete payment email and payment in database
		F_Payment.DS_DeletePayment(AccountPayment_Usercode);
		F_Account.DeleteAllSpamMail(AccountPayment, Constants.EmailDomain);
		
		//------------------------TESTCASE----------------------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountPayment + Constants.EmailDomain, Constants.Password);	
		F_Payment.BuyPaymentWithCreditCard(Bundle, FrequencyCC, CardNumber, Month, Year, VerificationNumber);
		F_Payment.CompletePaymentBilling();
		
		F_PaymentVerification.Verify_Page_Redirect_To_Dashboard_After_Buying(Result);
		F_PaymentVerification.Verify_Receive_Email_New_Payment(AccountPayment, Constants.EmailDomain, Result);
		F_PaymentVerification.DS_Verify_OrderID_Exist(AccountPayment_Usercode, Result);
		F_PaymentVerification.DS_Verify_Frequency_Row_Number(AccountPayment_Usercode, Bundle, FrequencyCC, Result);
				
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	

	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC011_Vefiy_User_Buy_A_BASIC_QUARTERLY_Promotion_Bundle_By_DEBIT_BANKING() 
	{
		
		// Pre-condition
		String AccountPayment = ConstantLib.UserInit.AccountPayment;	
		String AccountPayment_Usercode = ConstantLib.UserInit.UserCodeAccountPayment;
	
		//Data for buying Debit flow
		String Bundle = ConstantLib.PaymentInit.BasicBundle;
		String FrequencyDB = ConstantLib.PaymentInit.QuarterlyFrequency;
		String IBAN = ConstantLib.PaymentInit.IBAN;
		String BIC = ConstantLib.PaymentInit.BIC;
		
		//Delete payment email and payment in database
		F_Payment.DS_DeletePayment(AccountPayment_Usercode);
		F_Account.DeleteAllSpamMail(AccountPayment, Constants.EmailDomain);

		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountPayment + Constants.EmailDomain, Constants.Password);	
		F_Payment.BuyPaymentWithDebitBanking(Bundle, FrequencyDB, AccountOwner, IBAN, BIC); 
		F_Payment.CompletePaymentBilling();
		
		F_PaymentVerification.Verify_Page_Redirect_To_Dashboard_After_Buying(Result);;
		F_PaymentVerification.Verify_Receive_Email_New_Payment(AccountPayment, Constants.EmailDomain, Result);
		F_PaymentVerification.DS_Verify_OrderID_Exist(AccountPayment_Usercode, Result);
		F_PaymentVerification.DS_Verify_Frequency_Row_Number(AccountPayment_Usercode, Bundle, FrequencyDB, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC012_Vefiy_User_Buy_A_SMART_SEMIANNUAL_Promotion_Bundle_By_CREADIT_CARD() 
	{
		
		// Pre-condition
		String AccountPayment = ConstantLib.UserInit.AccountPayment;	
		String AccountPayment_Usercode = ConstantLib.UserInit.UserCodeAccountPayment;
		
		//Data for buying Credit Card flow
		String Bundle = ConstantLib.PaymentInit.SmartBundle;
		String FrequencyCC = ConstantLib.PaymentInit.SemiAnnualFrequency;
		String CardNumber = ConstantLib.PaymentInit.CardNumber;
		
		//Delete payment email and payment in database
		F_Payment.DS_DeletePayment(AccountPayment_Usercode);
		F_Account.DeleteAllSpamMail(AccountPayment, Constants.EmailDomain);
		
		//------------------------TESTCASE----------------------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountPayment + Constants.EmailDomain, Constants.Password);	
		F_Payment.BuyPaymentWithCreditCard(Bundle, FrequencyCC, CardNumber, Month, Year, VerificationNumber);
		F_Payment.CompletePaymentBilling();
		
		F_PaymentVerification.Verify_Page_Redirect_To_Dashboard_After_Buying(Result);
		F_PaymentVerification.Verify_Receive_Email_New_Payment(AccountPayment, Constants.EmailDomain, Result);
		F_PaymentVerification.DS_Verify_OrderID_Exist(AccountPayment_Usercode, Result);
		F_PaymentVerification.DS_Verify_Frequency_Row_Number(AccountPayment_Usercode, Bundle, FrequencyCC, Result);
				
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC013_Vefiy_User_Buy_A_SMART_ONETIME_Promotion_Bundle_By_DEBIT_BANKING() 
	{
		
		// Pre-condition
		String AccountPayment = ConstantLib.UserInit.AccountPayment;	
		String AccountPayment_Usercode = ConstantLib.UserInit.UserCodeAccountPayment;
	
		//Data for buying Debit flow
		String Bundle = ConstantLib.PaymentInit.SmartBundle;
		String AccountOwner = "Auto Owner Payment";
		String FrequencyDB = ConstantLib.PaymentInit.OnetimeFrequency;
		String IBAN = ConstantLib.PaymentInit.IBAN;
		String BIC = ConstantLib.PaymentInit.BIC;
		
		//Delete payment email and payment in database
		F_Payment.DS_DeletePayment(AccountPayment_Usercode);
		F_Account.DeleteAllSpamMail(AccountPayment, Constants.EmailDomain);

		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountPayment + Constants.EmailDomain, Constants.Password);	
		F_Payment.BuyPaymentWithDebitBanking(Bundle, FrequencyDB, AccountOwner, IBAN, BIC); 
		F_Payment.CompletePaymentBilling();
		
		F_PaymentVerification.Verify_Page_Redirect_To_Dashboard_After_Buying(Result);
		F_PaymentVerification.Verify_Receive_Email_New_Payment(AccountPayment, Constants.EmailDomain, Result);
		F_PaymentVerification.DS_Verify_OrderID_Exist(AccountPayment_Usercode, Result);
		F_PaymentVerification.DS_Verify_Frequency_Row_Number(AccountPayment_Usercode, Bundle, FrequencyDB, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC014_Vefiy_User_Buy_A_COMFORT_QUARTERLY_Promotion_Bundle_By_CREADIT_CARD() 
	{
		
		// Pre-condition
		String AccountPayment = ConstantLib.UserInit.AccountPayment;	
		String AccountPayment_Usercode = ConstantLib.UserInit.UserCodeAccountPayment;
		
		//Data for buying Credit Card flow
		String Bundle = ConstantLib.PaymentInit.ComfortBundle;
		String FrequencyCC = ConstantLib.PaymentInit.QuarterlyFrequency;
		String CardNumber = ConstantLib.PaymentInit.CardNumber;
		
		//Delete payment email and payment in database
		F_Payment.DS_DeletePayment(AccountPayment_Usercode);
		F_Account.DeleteAllSpamMail(AccountPayment, Constants.EmailDomain);
		
		//------------------------TESTCASE----------------------------------------
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountPayment + Constants.EmailDomain, Constants.Password);	
		F_Payment.BuyPaymentWithCreditCard(Bundle, FrequencyCC, CardNumber, Month, Year, VerificationNumber);
		F_Payment.CompletePaymentBilling();
		
		F_PaymentVerification.Verify_Page_Redirect_To_Dashboard_After_Buying(Result);
		F_PaymentVerification.Verify_Receive_Email_New_Payment(AccountPayment, Constants.EmailDomain, Result);
		F_PaymentVerification.DS_Verify_OrderID_Exist(AccountPayment_Usercode, Result);
		F_PaymentVerification.DS_Verify_Frequency_Row_Number(AccountPayment_Usercode, Bundle, FrequencyCC, Result);
				
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC015_Vefiy_User_Buy_A_COMFORT_ONETIME_Promotion_Bundle_By_DEBIT_BANKING() 
	{
		
		// Pre-condition
		String AccountPayment = ConstantLib.UserInit.AccountPayment;	
		String AccountPayment_Usercode = ConstantLib.UserInit.UserCodeAccountPayment;
	
		//Data for buying Debit flow
		String Bundle = ConstantLib.PaymentInit.ComfortBundle;
		String FrequencyDB = ConstantLib.PaymentInit.OnetimeFrequency;
		String IBAN = ConstantLib.PaymentInit.IBAN;
		String BIC = ConstantLib.PaymentInit.BIC;
		
		//Delete payment email and payment in database
		F_Payment.DS_DeletePayment(AccountPayment_Usercode);
		F_Account.DeleteAllSpamMail(AccountPayment, Constants.EmailDomain);

		F_Navigation.goTolmsURL();
		F_Account.LoginUser(AccountPayment + Constants.EmailDomain, Constants.Password);	
		F_Payment.BuyPaymentWithDebitBanking(Bundle, FrequencyDB, AccountOwner, IBAN, BIC); 	
		F_Payment.CompletePaymentBilling();
		
		F_PaymentVerification.Verify_Page_Redirect_To_Dashboard_After_Buying(Result);
		F_PaymentVerification.Verify_Receive_Email_New_Payment(AccountPayment, Constants.EmailDomain, Result);
		F_PaymentVerification.DS_Verify_OrderID_Exist(AccountPayment_Usercode, Result);
		F_PaymentVerification.DS_Verify_Frequency_Row_Number(AccountPayment_Usercode, Bundle, FrequencyDB, Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TC019_Vefiy_DS_Period_Product_Price_Gross() 
	{
		
		F_PaymentVerification.DS_Verify_Period_Product_Price_Gross(Result);
		
		Assert.assertTrue(Result.Result, Result.Message);		
	}
	
}


