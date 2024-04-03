package verificationFunctions;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.testng.internal.annotations.IListeners;

import functions.F_Account;
import functions.F_Message;
import functions.F_Navigation;
//import functions.generalFunctions;
//import interfaces.I_HomePage;
//import interfaces.I_Mail;
import variables.ConstantLib.Constants;
import variables.TCResult;
import variables.valueList;
import functions.generalFunctions;
import interfaces.I_DashboardPage;
import interfaces.I_Message;
import interfaces.I_Payment;

public class F_MessageVerification {

	/**
	 * Verify there is a new message receive in MailBox
	 * 
	 */
	public static void Verify_Receive_Newest_SharePhotoMessage(String pText,TCResult pResult) {
		
			
		generalVerification.verifyElementVisible(By.xpath("//div[@class='messenger__thread']//div[contains(text(),' Heute')]/ancestor::div[@class='messenger__thread-group']/div[last()]//div[contains(@class,'system-message inbox')]//img[contains(@src,'pic_icon')]"), "New SharePhoto Message is received", pResult);

	}
	
	/**
	 * Verify there is a new message is sent in MailBox
	 * 
	 */
	public static void Verify_Send_Newest_SharePhotoMessage(String pText,TCResult pResult) {
		
		generalVerification.verifyElementVisible(By.xpath("//div[@class='messenger__thread']//div[contains(text(),' Heute')]/ancestor::div[@class='messenger__thread-group']/div[last()]//div[contains(@class,'system-message outbox')]//img[contains(@src,'pic_icon')]"), "New SharePhoto Message is sent", pResult);

	}
	
	/**
	 * Verify there is a new message receive in MailBox
	 * 
	 */
	public static void Verify_Receive_Newest_Smiley(String pText,TCResult pResult) {
		
			
		generalVerification.verifyElementVisible(By.xpath("//div[@class='messenger__thread']//div[contains(text(),' Heute')]/ancestor::div[@class='messenger__thread-group']/div[last()]//div[contains(@class,'system-message inbox')]//img[contains(@src,'smiley')]"), "New Smiley Message is received", pResult);

	}
	
	/**
	 * Verify there is a new message is sent in MailBox
	 * 
	 */
	public static void Verify_Sent_Newest_Smiley(String pText,TCResult pResult) {
		
		generalVerification.verifyElementVisible(By.xpath("//div[@class='messenger__thread']//div[contains(text(),' Heute')]/ancestor::div[@class='messenger__thread-group']/div[last()]//div[contains(@class,'system-message outbox')]//img[contains(@src,'smiley')]"), "New Smiley Message is sent", pResult);

	}
	
	/**
	 * Verify there is a new message receive in MailBox
	 * 
	 */
	public static void Verify_Receive_Newest_Message(String pText,TCResult pResult) {
		
		
		
		generalVerification.verifyElementVisible(By.xpath("//div[@class='messenger__thread']//div[contains(text(),' Heute')]/ancestor::div[@class='messenger__thread-group']/div[last()]//div[@class='messenger-message inbox']/span[text()='"+ pText +"']"), "New Received Message", pResult);

	}
	
	/**
	 * Verify there is a new message is sent in MailBox
	 * 
	 */
	public static void Verify_Sent_Newest_Message(String pText,TCResult pResult) {
		
		generalVerification.verifyElementVisible(By.xpath("//div[@class='messenger__thread']//div[contains(text(),' Heute')]/ancestor::div[@class='messenger__thread-group']/div[last()]//div[@class='messenger-message outbox']/span[text()='"+ pText +"']"), "New Message is sent", pResult);

	}
	
	/**
	 * Verify there is no new message in MailBox
	 * 
	 */
	public static void Verify_Receive_No_New_Message(TCResult pResult) {
		
	
	}
	
	/**
	 * Verify there is a new message in MailBox
	 * 
	 */
	public static void Verify_Receive_Email_New_Message(String pUserName, String pDomain, TCResult pResult) {
		
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Sie haben eine neue Nachricht erhalten')]"), "Email for New Message", pResult);
				
	}
	
	/**
	 * Verify there is a new message in MailBox
	 * 
	 */
	public static void Verify_Receive_Email_New_SharePhoto(String pUserName, String pDomain, TCResult pResult) {
		
		F_Account.LoginSpamAccount(pUserName, pDomain);
		generalVerification.verifyElementVisible(By.xpath("//div[@id='Inbox']/div[2]//span[contains(text(),'Sie haben eine Bildfreigabe erhalten')]"), "Email for New Share Photo Message", pResult);
				
	}
	
	/**
	 * Verify there is a new smiley message in MailBox
	 * 
	 */
	public static void Verify_Receive_Email_New_Smiley_Message(String pUserName, String pDomain, TCResult pResult) {
		
		F_Account.LoginSpamAccount(pUserName, pDomain);
		
		By by_TitleSmileyMail1 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Sie haben einen Smiley erhalten! ?')]");
		By by_TitleSmileyMail2 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Smiley! Sie wurden angelächelt.')]");
		By by_TitleSmileyMail3 = By.xpath("//div[@id='Inbox']/div[1]//span[contains(text(),'Ihnen wurde ein Lächeln geschenkt! ?')]");

		List<By> by_TitleSmileyMail = new ArrayList<By>();
		by_TitleSmileyMail.add(by_TitleSmileyMail1);
		by_TitleSmileyMail.add(by_TitleSmileyMail2);
		by_TitleSmileyMail.add(by_TitleSmileyMail3);
		boolean flag = false;
		
		Constants.Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
			pResult.SetMessage("\r\n Smiley Mail is not displayed");
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * Verify UI and behavior of Premium Banner in messenger for basic user
	 * 
	 */
	public static void Verify_Premium_Banner_Appear_For_Basic_User(String pUserCode,TCResult pResult) {
		
		F_Message.SelectAUserToSendMessage(pUserCode);
		generalVerification.verifyElementVisible(I_Message.btn_BuyPremium, "Premium Button in Premium Banner", pResult);
		//Check last inbox message IS BLUR
		generalVerification.verifyElementVisible(I_Message.lbl_LastInboxBlurMessage, "Lastest blur message", pResult);
		//Check blur message in contact list
		generalVerification.verifyElementVisible(By.xpath("//ul[@class='messenger__contact-list-wrapper']/li//a[contains(@href,'"+ pUserCode +"')]//following-sibling::div[1]//div[contains(@class,'messenger__blur')]"), "Blur message in contact list", pResult);
		generalFunctions.click(I_Message.btn_BuyPremium);
		generalVerification.verifyElementVisible(I_Payment.btn_PremiumBASICBundle, "BASIC BUNDLE confirm button", pResult);
		F_Navigation.goTolmsURL();
		F_Navigation.GotoMailBox();
		F_Message.SelectAUserToSendMessage(pUserCode);
		generalFunctions.waitForSeconds(3);
		generalFunctions.click(I_Message.txt_Message);
		generalVerification.verifyElementVisible(I_Payment.btn_PremiumBASICBundle, "BASIC BUNDLE confirm button", pResult);
	}
	
	/**
	 * Verify UI and behavior of Premium Banner in messenger for Potential Zero user
	 * 
	 */
	public static void Verify_Premium_Banner_Appear_For_P0_User(String pUserCode,TCResult pResult) {
		
		F_Message.SelectAUserToSendMessage(pUserCode);
		generalVerification.verifyElementVisible(I_Message.btn_BuyPremium, "Premium Button in Premium Banner", pResult);
		//Check last inbox message IS BLUR
		generalVerification.verifyElementVisible(I_Message.lbl_LastInboxBlurMessage, "Lastest blur message", pResult);
		//Check blur message in contact list
		generalVerification.verifyElementVisible(By.xpath("//ul[@class='messenger__contact-list-wrapper']/li//a[contains(@href,'"+ pUserCode +"')]//following-sibling::div[1]//div[contains(@class,'messenger__blur')]"), "Blur message in contact list", pResult);
		generalFunctions.click(I_Message.btn_BuyPremium);
		generalVerification.verifyElementVisible(I_DashboardPage.popup_RemindUploadPic, "Remind Picture Popup", pResult);
		generalFunctions.waitForSeconds(2);
		generalFunctions.click(I_DashboardPage.btn_CloseRemindUploadPic);
		generalFunctions.waitForSeconds(2);
		generalFunctions.click(I_Message.txt_Message);
		generalVerification.verifyElementVisible(I_DashboardPage.popup_RemindUploadPic, "Remind Picture Popup", pResult);
		generalFunctions.waitForSeconds(2);
		generalFunctions.click(I_DashboardPage.btn_CloseRemindUploadPic);
		generalFunctions.waitForSeconds(2);
	}
		
	
}
