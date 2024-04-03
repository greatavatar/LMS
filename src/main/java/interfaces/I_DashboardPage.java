package interfaces;

import org.openqa.selenium.By;

public class I_DashboardPage {

	//Browser
	public static By lik_Login = By.xpath("//a[contains(@class,'right__login color--white')]");
	public static By btn_FacebookLogin = By.xpath("//button[@id='btnFbLogin']");
	public static By btn_GoogleLogin = By.xpath("//button[@id='btnGoogleLogin']");
	
	public static By btn_PremiumRightWidget = By.xpath("//div[@class='banner']//a[contains(text(),'Jetzt sichern')]");
	public static By lik_NoDiscountPremium_Right = By.xpath("//div[contains(@class,'dashboard__right')]//a[contains(text(),'Premium-Mitglied werden')]");
	public static By img_MyAvatar = By.xpath("//img[@class='dashboard__avatar']");

	public static By img_PusherInterestNumber = By.xpath("//div[@class='nav__item-list']/a[contains(@href,'suggestion')]//span[contains(@class,'badge')]");
	public static By img_PusherUnreadMailNumber = By.xpath("//div[@class='nav__item-list']/a[contains(@href,'messenger')]//span[contains(@class,'badge')]");

	public static By lbl_TotalUnreadMailNumber = By.xpath("//a[@href='/messaging/inbox']//span[contains(@class,'green')]");
	public static By lbl_TotalMatchingNumber = By.xpath("//*[contains(@class,'testMatching')]//a[contains(@class,'light-green')]");
	
	public static By lbl_UnreadMailNumber_Statistic = By.xpath("//span[contains(@class,'totalMessage')]/span");
	public static By lbl_MatchingNumber_Statistic = By.xpath("//span[contains(@class,'totalSuggestion')]");
	public static By lbl_InterestNumber_Statistic = By.xpath("//span[contains(@class,'totalSuggestion')]/parent::li/following-sibling::li//span[@class='dashboard-stats__value']");
	
	public static By lbl_TopPercent_Statistic = By.xpath("//div[@class='dashboard__profile-attractive']/a/strong[2]");
	public static By lbl_MiddlePercent_Statistic = By.xpath("//div[@class='dashboard-stats']/div[2]/ul/li[3]/span[2]");
	
	public static By popup_RemindUploadPic = By.xpath("//div[@class='identity-upload__content']");
	public static By btn_CloseRemindUploadPic = By.xpath("//*[@class='identity-upload__close-popup']");
	
	public static By pnl_MailBoxSection = By.xpath("//section[contains(@class,'testInbox')]");
	public static By pnl_MatchingSection = By.xpath("//section[contains(@class,'testMatching')]");
	public static By pnl_InterestInMeSection = By.xpath("//section[contains(@class,'testInterestInMe')]");
	public static By pnl_PerfectMatchSection = By.xpath("//div[@class='dashboard-perfectmatch__wrapper']");
	
	public static By lbl_BlockedAccountError = By.xpath("//div[contains(text(),'Dieses Profil ist gesperrt')]");
	
	
}