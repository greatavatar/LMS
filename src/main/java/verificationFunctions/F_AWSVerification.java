package verificationFunctions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import functions.F_Account;

//import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.yaml.snakeyaml.scanner.Constant;

import functions.generalFunctions;
import interfaces.*;
//import variables.ConstantLib.Constants;
import variables.TCResult;
import variables.ConstantLib.Constants;

public class F_AWSVerification {

	/**
	 * Verify Workder of Premium_Zero_Promotion can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_DAY1(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Premium: 100 % kostenlos kein Abo keine Verpflichtungen')]"), "Premium_Zero_Promotion DAY 0 mail", pResult);

		}
	
	/**
	 * Verify Workder of Premium_Zero_Promotion can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_DAY4(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Erinnerung: Ihre kostenlose Premium-Mitgliedschaft wartet')]"), "Premium_Zero_Promotion DAY 4 mail", pResult);

		}
	
	/**
	 * Verify Workder of Premium_Zero_Promotion can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_DAY28(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Erinnerung: Ihre kostenlose Premium-Mitgliedschaft wartet')]"), "Premium_Zero_Promotion DAY 28 mail", pResult);

		}
	
	/**
	 * Verify Workder of Premium_Zero_Promotion can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_STUDENT_DAY_1(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Premium: 100 % kostenlos kein Abo keine Verpflichtungen')]"), "Premium_Zero_Promotion STUDENT_DAY_1 mail", pResult);

		}
	
	/**
	 * Verify Workder of Premium_Zero_Promotion can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Premium_Zero_Promotion_STUDENT_DAY_28(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Erinnerung: Ihre kostenlose Premium-Mitgliedschaft wartet')]"), "Premium_Zero_Promotion STUDENT_DAY_28 mail", pResult);

		}
	
	/**
	 * Verify Workder of Email_Price_Promotion DAY 0 can send email 
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY0(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		if (ExistBugZeroPercentMail(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Top Angebot: jetzt 0 % sparen')]"),pResult) == false)
			generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Top Angebot: jetzt 50 % sparen')]"), "Email_Price_Promotion Day 0 mail", pResult);

		}
	/**
	 * Verify Workder of Email_Price_Promotion DAY 6 can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY6(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		if (ExistBugZeroPercentMail(By.xpath("//div[@id='Inbox']/div[1]//span[text()='0 % Rabatt auf Ihre Premium-Mitgliedschaft']"),pResult) == false)
			generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'50 % Rabatt auf Ihre Premium-Mitgliedschaft')]"), "Email_Price_Promotion Day 6 mail", pResult);

		}
	
	/**
	 * Verify Workder of Email_Price_Promotion DAY 7 can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY7(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);
		if (ExistBugZeroPercentMail(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Einmalig verlängert: 0 % Rabatt auf Ihre Premium-Mitgliedschaft')]"),pResult) == false)
			generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Einmalig verlängert: 50 % Rabatt auf Ihre Premium-Mitgliedschaft')]"), "Email_Price_Promotion Day 7 mail", pResult);

		}
	
	/**
	 * Verify Workder of Email_Price_Promotion DAY 13 can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Email_Price_Promotion_DAY13(String pUserName, String pDomain, TCResult pResult) {
		F_Account.LoginSpamAccount(pUserName, pDomain);	
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Nur noch wenige Stunden: Ihr Glück wartet nicht')]"), "Email_Price_Promotion Day 13 mail", pResult);

		}
	
	/**
	 * Verify Workder of Perfect Mail can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Email_Perfect_Matching(String pUserName, String pDomain, TCResult pResult) {
			
		F_Account.LoginSpamAccount(pUserName, pDomain);
		
		By by_TitleSmileyMail1 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Sie sollten sich unbedingt kennenlernen!')]");
		By by_TitleSmileyMail2 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Sie beide sollten sich kennenlernen!')]");
		By by_TitleSmileyMail3 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Es wird Zeit, dass Sie sich kennenlernen!')]");

		List<By> by_TitleSmileyMail = new ArrayList<By>();
		by_TitleSmileyMail.add(by_TitleSmileyMail1);
		by_TitleSmileyMail.add(by_TitleSmileyMail2);
		by_TitleSmileyMail.add(by_TitleSmileyMail3);
		boolean flag = false;
		
		Constants.Driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		for(int i=0; i<by_TitleSmileyMail.size(); i++)
		{
			Boolean isPresent = Constants.Driver.findElements(by_TitleSmileyMail.get(i)).size() > 0;
			if (isPresent == true) {
				flag = true;	
				break;
			}
		}
		
		if (flag == false) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n Perfectmail is not displayed");
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		}
	
	/**
	 * Verify Workder of New Matching Mail can send email
	 * 
	 * @param pUserName
	 *            Account to receive mail
	 */
	public static void Verify_Receive_Mail_From_AWS_Email_New_Matching(String pUserName, String pDomain, TCResult pResult) {
			
		F_Account.LoginSpamAccount(pUserName, pDomain);
		
		By by_TitleSmileyMail1 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Entdecken Sie neue lms Mitglieder!')]");
		By by_TitleSmileyMail2 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Neue Mitglieder bei lms!')]");
		By by_TitleSmileyMail3 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Begrüßen Sie neue Mitglieder. Kopfüber ins Liebesglück?')]");

		List<By> by_TitleSmileyMail = new ArrayList<By>();
		by_TitleSmileyMail.add(by_TitleSmileyMail1);
		by_TitleSmileyMail.add(by_TitleSmileyMail2);
		by_TitleSmileyMail.add(by_TitleSmileyMail3);
		boolean flag = false;
		
		Constants.Driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		for(int i=0; i<by_TitleSmileyMail.size(); i++)
		{
			Boolean isPresent = Constants.Driver.findElements(by_TitleSmileyMail.get(i)).size() > 0;
			if (isPresent == true) {
				flag = true;		
				break;
			}
		}
		
		if (flag == false) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n New Matching mail is not displayed");
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		}
	
	/**
	Work around action for check bug 0% email
	 */
	public static boolean ExistBugZeroPercentMail (By pBy, TCResult pResult){
		generalFunctions.waitForSeconds(1);
		Constants.Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try
		{
			WebElement mElement = Constants.Driver.findElement(pBy);
			if (mElement.isDisplayed()) {
				pResult.SetResult(false);
				pResult.SetMessage("\r\n BUG: there is 0% mail is displayed");
				return true;
			}
		}
		catch(Exception e) {}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		return false;
		
	}
	
}
