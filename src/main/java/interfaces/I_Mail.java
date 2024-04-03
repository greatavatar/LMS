package interfaces;

import org.openqa.selenium.By;

public class I_Mail {
	
	//--------------------https://tempr.email/
	public static By txt_Username = By.id("LoginLocalPart");
	public static By sel_domain = By.id("LoginDomainId");
	public static By btn_Login = By.xpath("//input[contains(@value,'Postfach abrufen')]");
	
	public static By lnk_Email = By.xpath("//span[contains(text(),'Ihre E-Mail-Adresse')]");
	public static By btn_Confirm = By.xpath("//a[contains(text(),'Zu lms')]");
	public static By lnk_Confirm = By.xpath("//a[contains(text(),'Link')]");
	
	public static By lnk_NoDiscountPremium_Left = By.xpath("//a[contains(text(),'Premium-Mitglied werden')]");
	public static By lnk_DiscountPremium_Left = By.xpath("//div[contains(@data-banner,'promotionBanner')]//button[contains(text(),'Jetzt sichern')]");
	
	//--------------------https://getnada.com/
	public static By lnk_AddInboxNaDa = By.xpath("//span[contains(text(),'Add Inbox')]");
	public static By txt_EmailNaDa = By.xpath("//input[@class='user_name']");
	public static By sel_domainNaDa = By.id("domain");
	public static By btn_AcceptNaDa = By.xpath("//a[@class='button success']");
	
	public static By img_PusherMailNumber = By.xpath("//ul[@role='tablist']/li[1]//span[contains(@class,'badge')]");
}


