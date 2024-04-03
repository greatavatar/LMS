package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import functions.F_Account;
import functions.F_Navigation;
import functions.generalFunctions;
import interfaces.I_HomePage;
import interfaces.I_LoginPage;
import interfaces.I_Mail;
import interfaces.I_VisitProfile_Dashboard;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import variables.valueList;
import verificationFunctions.F_AccountVerification;
import verificationFunctions.generalVerification;
import org.testng.annotations.Listeners;

public class UI_Links extends DefaultAnnotations
{
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	public void TC001_Verify_HomePage_Links_Part1() 
	{

		F_Navigation.goTolmsURL();
		
		generalFunctions.click(I_HomePage.lik_Ratgeber_Top);
		generalVerification.verifyWebsiteTitle("Übersicht", Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(@class,'advisor__page-title')][text()='Übersicht']"), "Übersicht Label", Result);
		
		F_Navigation.GotoDashBoard();
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.HomePage, Result);
		generalVerification.verifyElementVisible(I_HomePage.txt_AccountLogin, "Login textbox", Result);
		generalVerification.verifyElementVisible(I_HomePage.btn_Login, "Login button", Result);

		generalFunctions.click(I_HomePage.img_Ausgezeichnet_top_logo);
		generalFunctions.SwitchToNewTab(Constants.OriginalHandle);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Ausgezeichnet_Logo, Result );
		generalVerification.verifyElementVisible(By.xpath("//span[@class='brand'][text()='Ausgezeichnet.org']"),"Ausgezeichnet.org label", Result);
		generalFunctions.CloseAllOtherTabs(Constants.OriginalHandle);
		
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.img_Ausgezeichnet_middle_logo);
		generalFunctions.SwitchToNewTab(Constants.OriginalHandle);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Ausgezeichnet_Logo, Result );
		generalVerification.verifyElementVisible(By.xpath("//span[@class='brand'][text()='Ausgezeichnet.org']"),"Ausgezeichnet.org label", Result);
		generalFunctions.CloseAllOtherTabs(Constants.OriginalHandle);
	
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Kontakt);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.HomePage, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[contains(text(),'Wenn Sie Fragen haben, kontaktieren Sie uns bitte unter ')]"), "message label", Result);
		generalVerification.verifyElementVisible(By.xpath("//a[@href='mailto:service@lms.com']"), "lms mail link", Result);
		
	
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Presse);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Presse, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'lms Pressebereich')]"), "lms Pressebereich label", Result);
		
		generalFunctions.click(I_HomePage.lik_lmsFooter);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.HomePage, Result);
		generalVerification.verifyElementVisible(I_HomePage.txt_AccountLogin, "Login textbox", Result);

		generalFunctions.click(I_HomePage.lik_Ratgeber_Bottom);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Ratgeber, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(@class,'advisor__page-title')][text()='Übersicht']"), "Übersicht Label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Ubersicht);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Ubersicht, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Übersich')]"), "Übersich label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_lms_Tipps);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.lms_Tipps, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'lms Tipps')]"), "lms Tipps label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Partnersuche);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Partnersuche, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Partnersuche')]"), "Partnersuche label", Result);

		
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Erstes_Date);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Erstes_Date, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Erstes Date')]"), "Erstes Date label", Result);

	
		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	public void TC001_Verify_HomePage_Links_Part2() 
	{

		F_Navigation.goTolmsURL();
	
		generalFunctions.click(I_HomePage.lik_Uber_lms);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Uber_lms, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Liebe für alle!')]"), "Liebe für alle! label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Mission);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Mission, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Mission')]"), "Mission label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Team);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Team, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Team')]"), "Team label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Erfahrungen);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Erfahrungen, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(@class,'erfahrungen__title')]"), "Erfahrungen label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_AGB);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.AGB, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[contains(text(),'AGB')]"), "AGB label", Result);
		
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Impressum);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Impressum, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[contains(text(),'Impressum')]"), "Impressum label", Result);
	
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Datenschutzerklarung);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Datenschutzerklarung, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[contains(text(),'Datenschutzerklärung')]"), "Datenschutzerklärung label", Result);

		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Partnerprogramm);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.HomePage, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[contains(text(),'Das lms Partner-Programm')]"), "Partner-Program label", Result);
		
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.img_Ausgezeichnet_footer_logo);
		generalFunctions.SwitchToNewTab(Constants.OriginalHandle);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Ausgezeichnet_Logo, Result );
		generalVerification.verifyElementVisible(By.xpath("//span[@class='brand'][text()='Ausgezeichnet.org']"),"Ausgezeichnet.org label", Result);
		generalFunctions.CloseAllOtherTabs(Constants.OriginalHandle);
		
		generalFunctions.click(I_HomePage.lik_Facebook);
		generalVerification.verifyElementVisible(By.xpath("//i[contains(@class,'fb_logo img')]"), "Facebook logo", Result);
		generalVerification.verifyElementVisible(By.xpath("//a[@href='https://www.facebook.com/lms/']"), "lms label", Result);
		
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Twitter);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Twitter, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[@class='ProfileAvatar']/a/img[@alt='lms']"), "lms logo", Result);
			
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Instagram);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Instagram, Result);
		generalVerification.verifyElementVisible(By.xpath("//h1[@title='xxxxxxxxxxxxx_swan']"), "lms label", Result);
		
		Constants.Driver.navigate().back();
		generalFunctions.click(I_HomePage.lik_Xing);
		// Error "Webstitle's title should be lms GmbH als Arbeitgeber | XING Unternehmen instead of lms GmbH as an employer | XING Companies."
		//when running with HEADLESS mode
		//generalVerification.verifyWebsiteTitle("lms GmbH as an employer | XING Companies", Result);
		generalVerification.verifyElementVisible(By.xpath("//img[contains(@alt,'lms GmbH')]"), "lms Logo", Result);

		Assert.assertTrue(Result.Result, Result.Message);
		
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	public void TC002_Verify_DashBoard_Links_Part1() 
	{

		//Pre-Condittons
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Constants.EmailLinks, Constants.Password);
		
		//-------------------Verify links in TOP BANNER
		generalFunctions.click(I_HomePage.lik_MailBox);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Mailbox, Result);
		generalVerification.verifyElementVisible(By.xpath("//ul[@class='messenger__contact-list-wrapper']"), "Contact list", Result);
		
		generalFunctions.click(I_HomePage.lik_PartnerList);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.PartnerList, Result);
		generalVerification.verifyElementVisible(By.xpath("//h2[text()='Meine Partnervorschläge']"), "Partnervorschläge label", Result);
	
		generalFunctions.click(I_HomePage.lik_MyProfile);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.MyProfile, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[text()='Ich über mich']"), "Ich über mich label", Result);
		
		generalFunctions.click(I_HomePage.lik_HomePage);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Startseite, Result);
		generalVerification.verifyElementVisible(By.xpath("//div[@class='dashboard__aside']"), "Information Activity Section", Result);
		
		
		F_Account.LogOutUser();
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Login, Result);
		generalVerification.verifyElementVisible(I_LoginPage.txt_Email, "Email textbox", Result);
		F_Account.LoginUserInLoginPage(Constants.EmailLinks, Constants.Password);
		
		
		//-------------------Verify MORE links for 3 list
		
		F_Navigation.GotoDashBoard();
		generalFunctions.click(I_HomePage.lik_More_ForMail);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Mailbox, Result);
		generalVerification.verifyElementVisible(By.xpath("//ul[@class='messenger__contact-list-wrapper']"), "Contact list", Result);

		F_Navigation.GotoDashBoard();
		generalFunctions.click(I_HomePage.lik_More_ForPartner);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.PartnerList, Result);
		generalVerification.verifyElementVisible(By.xpath("//h2[text()='Meine Partnervorschläge']"), "Partnervorschläge label", Result);

		F_Navigation.GotoDashBoard();
		generalFunctions.click(I_HomePage.lik_More_ForInterested);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.InterestList, Result);
		generalVerification.verifyElementVisible(By.xpath("//h2[text()='Meine Interessenten']"), "Meine Interessenten label", Result);
		
		Assert.assertTrue(Result.Result, Result.Message);
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	public void TC002_Verify_DashBoard_Links_Part2() 
	{

		//Pre-Condittons
		
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Constants.EmailLinks, Constants.Password);
				
		//-------------------Verify P0 disccount 100% links--------
		F_Navigation.GotoDashBoard();	
		F_Navigation.GotoMyProfile();
	    F_Account.SetValueDegree("2","");
		F_Navigation.GotoDashBoard(); 
		//Account after 14 days has no banner
		generalVerification.verifyElementVisible(I_HomePage.lik_Premium_Top, "Premium Top Banner", Result);
	
		//-----------------------Account < 14 days has Bannber
		/*generalFunctions.click(I_HomePage.lik_Premium_Top);
		generalVerification.verifyWebsiteTitle("Startseite", Result);
		//Workaround, somehow it not work, can not use javascript to click because it will be error in BrowserStack
		generalFunctions.waitForSeconds(3);
		generalVerification.verifyElementVisible(By.xpath("//a[contains(text(),'Premium nicht nutzen')]"), "Premium PopUp Cancel Link", Result);
		F_Navigation.ClosePremiumZeroPopUp();*/
		
		generalFunctions.click(I_HomePage.lik_DiscountWidgetLeft);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Startseite, Result);
		//Workaround, somehow it not work, can not use javascript to click because it will be error in BrowserStack
		generalFunctions.waitForSeconds(3);
		generalVerification.verifyElementVisible(By.xpath("//*[contains(text(),'So werden Sie gratis Premium-Mitglied')]"), "Welcome text Premium Zero popup", Result);
		F_Navigation.ClosePremiumZeroPopUp();
		
		generalFunctions.click(I_HomePage.lik_PartnerList);
		generalFunctions.click(I_Mail.lnk_DiscountPremium_Left);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.PartnerList, Result);
		//Workaround, somehow it not work, can not use javascript to click because it will be error in BrowserStack
		generalFunctions.waitForSeconds(3);
		generalVerification.verifyElementVisible(By.xpath("//*[contains(text(),'So werden Sie gratis Premium-Mitglied')]"), "Welcome text Premium Zero popup", Result);
		F_Navigation.ClosePremiumZeroPopUp();
		
		//-------------------Verify Premium Link --------------
		F_Navigation.GotoMyProfile();
		F_Account.SetValueDegree("6","");
		F_Account.SetValueHavingKid("No", "", "");
		F_Navigation.GotoDashBoard();
		
		//----------Account < 14 days has Bannber
		/*generalFunctions.click(I_HomePage.lik_Premium_Top);
		generalVerification.verifyWebsiteTitle("Premium", Result);
		generalVerification.verifyElementVisible(By.xpath("//button[contains(text(),'Ich wähle Premium smart')]"), "Buy Premium Smart button", Result);
		generalFunctions.click(I_HomePage.img_lmsIconPaywall);*/
		
		generalFunctions.click(I_HomePage.lik_NoDiscountWidgetLeft);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Premium, Result);
		generalVerification.verifyElementVisible(By.xpath("//button[contains(text(),'Ich wähle Premium smart')]"), "Buy Premium Smart button", Result);
		generalFunctions.click(I_HomePage.img_lmsIconPaywall);
		
		generalFunctions.waitForLoadingIconDisappear();
		generalFunctions.click(I_HomePage.lik_PartnerList);
		generalFunctions.click(I_Mail.lnk_NoDiscountPremium_Left);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Premium, Result);
		generalVerification.verifyElementVisible(By.xpath("//button[contains(text(),'Ich wähle Premium smart')]"), "Buy Premium Smart button", Result);
		generalFunctions.click(I_HomePage.img_lmsIconPaywall);
			
		//-------------------Verify a Profile Link in 3 list
		
		generalFunctions.waitForLoadingIconDisappear();
		F_Navigation.OpenMailProfileDashboard(1);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.Mailbox, Result);
		generalVerification.verifyElementVisible(By.xpath("//ul[@class='messenger__contact-list-wrapper']"), "Contact list", Result);
		
		F_Navigation.GotoDashBoard();
		F_Navigation.OpenPartnerProfileDashboard(1);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.PartnerProfile, Result);
		generalVerification.verifyElementVisible(I_VisitProfile_Dashboard.img_smiley, "Smiley image", Result);

		F_Navigation.GotoDashBoard();
		F_Navigation.OpenInterestProfileDashboard(1);
		generalVerification.verifyWebsiteTitle(valueList.WindowTitle.PartnerProfile, Result);
		generalVerification.verifyElementVisible(I_VisitProfile_Dashboard.img_smiley, "Smiley image", Result);
		
		Assert.assertTrue(Result.Result, Result.Message);
	}
	
	
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	public void TC022_Verify_Values_In_Statistics_Section() 
	{
		//Pre-Condittons
		F_Navigation.goTolmsURL();
		F_Account.LoginUser(Constants.EmailLinks, Constants.Password);
		F_AccountVerification.Verify_Value_Percentage_Statistic_Table(Result);
		F_Navigation.GotoDashBoard();
		F_AccountVerification.Verify_Value_MailNumber_Statistic_Table(Result);
		F_AccountVerification.Verify_Value_InterestInMe_Statistic_Table(Result);
		F_AccountVerification.Verify_Value_TotalPartner_Statistic_Table(Result);
		
		Assert.assertTrue(Result.Result, Result.Message);
	}
	
}
