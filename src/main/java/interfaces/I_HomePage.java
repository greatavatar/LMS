package interfaces;

import org.openqa.selenium.By;

public class I_HomePage {
		
	
	//----------Login Starting Page------------------------------------------
	public static By txt_AccountLogin = By.xpath("//input[@name='email']");
	public static By txt_PasswordLogin = By.xpath("//input[@name='password']");
	public static By btn_Login = By.xpath("//button[@id='btnEmailLogin']");
	public static By btn_FacebookLogin = By.xpath("//form[@id='formFacebookLogin']/button[@id='btnFbLogin']");
	public static By btn_GoogleLogin = By.xpath("//form[@id='formGoogleLogin']/button[@id='btnGoogleLogin']");
	
	
	//-------------Register Account------------------------------------ 
	public static By ra_isMale = By.id("isMale");
	public static By ra_isFemale = By.id("isFemale");
	public static By ra_LikeFemale = By.id("likeFemale");
	public static By ra_LikeMale = By.id("likeMale");
	public static By btn_Register = By.className("register-button");
	public static By txt_email = By.xpath("//form/div/div/input[@name='email']");
	public static By txt_password = By.xpath("//form/div/div/input[@name='password']");
	
	//------------TOP BANNER ICON--------------------------------------
	public static By img_lmsIcon = By.xpath("//img[@alt='lms Logo weiß']");
	public static By img_lmsIconPaywall = By.xpath("//img[@alt='lms Logo weiß']");
	public static By lik_Ratgeber_Top = By.xpath("//div[contains(@class,'container')]/a[contains(text(),'Ratgeber')]");
	public static By lik_LogIn = By.xpath("//div[@class='nav--not-logged-in']/a[contains(text(),'Einloggen')]");
	public static By lik_Hier = By.xpath("//a[contains(@href,'/press')]/b/u[text()='hier']");
	
	public static By lik_MyProfile = By.xpath("//div[@class='nav__item-list']//img[@alt='Mein Profil']");
	public static By lik_LogOut = By.xpath("//a[@class='dashboard__logout']");
	public static By lik_MailBox = By.xpath("//div[@class='nav__item-list']//img[@alt='Nachrichten']");
	public static By lik_PartnerList = By.xpath("//div[@class='nav__item-list']//img[@alt='Partnervorschläge']");
	public static By lik_HomePage = By.xpath("//div[@class='nav__item-list']//img[@alt='Startseite']");
	
	//-----------------------------------------------------------------
	
	//----------MIDDLE BANNER------------------------------------------
	
	public static By lik_MailBox_profile = By.xpath("//div[@class='overview__fact']//div[text()='Nachrichten']");
	public static By lik_PartnerList_profile = By.xpath("//div[@class='overview__fact']//div[text()='Partnervorschläge']");
	public static By lik_Interested_profile = By.xpath("//div[@class='overview__fact']//div[text()='Interessenten']");
	public static By lik_ProfileIntegrity_profile = By.xpath("//div[@class='overview__fact']//div[text()='Profil Vollständigkeit']");
	
	//-----------------------------------------------------------------
	
	//---------More Link for List--------------------------------------
	
	public static By lik_More_ForMail = By.xpath("//section[contains(@class,'testInbox')]/div/div/a[@href='/messaging/inbox']");
	public static By lik_More_ForPartner= By.xpath("//div[contains(@class,'testMatching')]/div/div/a[@href='/matching/suggestion']");
	public static By lik_More_ForInterested = By.xpath("//div[contains(@class,'testInterestInMe')]/div/div/a[@href='/user/interest-in-me']");
	
	//---------Premium links--------------------------------------
	
	public static By lik_Premium_Top = By.xpath("//div[contains(@class,'none-mobile')]//u[contains(text(),'PREMIUM-MITGLIED WERDEN')]");
	public static By lik_NoDiscountWidgetLeft = By.xpath("//div[@class='dashboard__aside']//*[contains(text(),'Premium-Mitglied werden')]");
	public static By lik_DiscountWidgetLeft = By.xpath("//div[@class='dashboard__aside']//*[contains(text(),'Jetzt sichern')]");

	//-----------Footer links------------------------------------------------------
	public static By lik_Facebook = By.xpath("//ul[@class='footer-social-media--wrapper']/li/a[@href='https://facebook.com/lms']");
	public static By lik_Twitter = By.xpath("//ul[@class='footer-social-media--wrapper']/li/a[@href='https://twitter.com/lmsCom']");
	public static By lik_Instagram = By.xpath("//ul[@class='footer-social-media--wrapper']/li/a[@href='https://www.instagram.com/xxxxxxxxxxxxx_swan/']");
	public static By lik_Xing = By.xpath("//ul[@class='footer-social-media--wrapper']/li/a[@href='https://www.xing.com/companies/lmsgmbh']");
	
	public static By lik_lmsFooter = By.xpath("//div[@class='signature flex--none hidden-xs']/a/img[@alt='lms Logo schwarz']");
	public static By lik_Kontakt = By.xpath("//a[@title='Kontakt']");
	public static By lik_Presse = By.xpath("//a[@title='Presse']");
	public static By lik_Ratgeber_Bottom = By.xpath("//div[contains(@class,'bottom')]/b/a[@title='Ratgeber']");
	public static By lik_Ubersicht = By.xpath("//a[@title='Übersicht']");
	public static By lik_lms_Tipps = By.xpath("//a[@title='lms Tipps']");
	public static By lik_Partnersuche = By.xpath("//a[@title='Partnersuche']");
	public static By lik_Kontaktaufnahme = By.xpath("//a[@title='Kontaktaufnahme']");
	public static By lik_Profil_erstellen = By.xpath("//a[@title='Profil erstellen']");
	public static By lik_Sucheinstellungen = By.xpath("//a[@title='Sucheinstellungen']");
	public static By lik_Neu_bei_lms = By.xpath("//a[@title='Neu bei lms']");
	public static By lik_Erstes_Date = By.xpath("//a[@title='Erstes Date']");
	public static By lik_Uber_lms = By.xpath("//a[@title='Über lms']");
	public static By lik_Mission = By.xpath("//a[@title='Mission']");
	public static By lik_Team = By.xpath("//a[@title='Team']");
	public static By lik_Erfahrungen = By.xpath("//a[@title='Erfahrungen']");
	public static By lik_AGB = By.xpath("//a[contains(@class,'inline-block')][@href='/agb']");
	public static By lik_Impressum = By.xpath("//a[@title='Impressum']");
	public static By lik_Datenschutzerklarung = By.xpath("//a[@title='Datenschutzerklärung']");
	public static By lik_Partnerprogramm = By.xpath("//a[@title='Partnerprogramm']");
	public static By img_Ausgezeichnet_top_logo = By.xpath("//div[contains(@class,'none-mobile')]/div[contains(@class,'none-mobile')]//a[contains(@class,'ausgezeichnet-badge')]/img");
	public static By img_Ausgezeichnet_footer_logo = By.xpath("//img[contains(@class,'ausgezeichnet-footer-logo')]");
	public static By img_Ausgezeichnet_middle_logo  = By.xpath("//div[@class='aus-widget-score-container']");
	
	//-----------button close cookie popup------------------------------------------------------
	public static By btn_closeCookieWarning  = By.xpath("//div[contains(@class,'message--shown')]//button[contains(text(),' Einverstanden')]");
	
}


