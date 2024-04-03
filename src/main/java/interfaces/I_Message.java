package interfaces;

import org.openqa.selenium.By;

public class I_Message {
		
	public static By txt_Message = By.xpath("//div[contains(@class,'message-detail')]//textarea");
	public static By btn_SendMessageGrey = By.xpath("//div[@class='messenger__btn-send']");
	public static By btn_SendMessageGreen = By.xpath("//div[@class='messenger__btn-send active']");
	
	public static By btn_LeftActions = By.xpath("//div[contains(@class,'add-new')]");
	public static By img_SmileyAction = By.xpath("//div[@class='messenger__smiley']");
	public static By img_SharePhotoAction = By.xpath("//div[@class='messenger__photo']");
	public static By img_UnSharePhotoAction = By.xpath("//div[@class='messenger__photo messenger__photo-shared']");
	public static By img_FavouriteAction = By.xpath("//div[contains(@class,'partner-favoriten')]");
	
	public static By btn_RightActions = By.xpath("//img[@alt='more'][contains(@class,'none-mobile')]");
	public static By lnk_DeleteThread = By.xpath("//div[contains(@data-target,'delete-thread-popup')]");
	public static By lnk_Report = By.xpath("//div[contains(@data-target,'reportModal')]");
	
	public static By btn_PremiumBanner = By.xpath("//button[contains(@class,'premium-banner')]");
	public static By btn_BuyPremium = By.xpath("//button[contains(text(),'Premium Angebote ansehen')]");
	
	public static By btn_ConfirmDelete = By.xpath("//button[contains(@class,'btn-thread')][contains(text(),'Kontakt entfernen')]");
	
	public static By lbl_LastInboxBlurMessage = By.xpath("//div[@class='messenger__thread']/div[2]/div[last()]//div[@class='messenger-message inbox']/span[@class='messenger__blur']");

	
}



