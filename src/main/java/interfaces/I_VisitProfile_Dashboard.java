package interfaces;

import org.openqa.selenium.By;

public class I_VisitProfile_Dashboard {
		
	public static By img_message = By.xpath("//img[@alt='Nachricht senden']");
	public static By img_smiley = By.xpath("//img[@alt='Smiley']");
	//Complicated Xpath cause of 1.Mobile - Desktop Version, 2.Share and Unshare control switching hidden
	public static By img_sharephoto = By.xpath("//li[@class='pointer action__menu-item']//img[@alt='Fotos freigeben']");
	public static By img_unsharephoto = By.xpath("//li[@id='unsharePictureIcon'][@class='pointer action__menu-item']//div[contains(@class,'none-mobile')]/img[@alt='Freigabe widerrufen']");
	public static By img_report = By.xpath("//img[@alt='Nutzer melden']");
	
	public static By tab_matching = By.xpath("//a[@title='Matching']");
	public static By tab_profil = By.xpath("//a[@title='Profile']");
	public static By tab_unsere_nachrichten = By.xpath("//a[@title='Our messages']");
	
	public static By img_avatar_partner = By.xpath("//div[contains(@class,'avatar')]/img[@id='partnerAvatar']");
	public static By img_relationship_partner = By.xpath("//div[contains(@class,'score')]/img[@alt='Partnervorschlag']");
	public static By img_relationship_myprofile = By.xpath("//div[contains(@class,'score')]/img[@alt='Profilbild']");
	public static By img_overview_partner = By.xpath("//div[contains(@class,'overview-info__avatar')]/div/img[@alt='Partnervorschlag']");
	public static By img_overview_myprofile = By.xpath("//div[contains(@class,'overview-info__avatar')]/div/img[@alt='Profilbild']");
	public static By btn_unshareOk = By.xpath("//button[contains(text(),'Freigabe widerrufen')]");
	public static By btn_unshareConfirmed = By.xpath("//button[contains(text(),'Schließen')]");
	
	public static By img_favourite_off = By.xpath("//div[@class='favorite-toggle partner-favoriten-toggle']");
	public static By img_favourite_on = By.xpath("//div[@class='favorite-toggle partner-favoriten-toggle active']");
	
	//public static By img_favourite_off = By.xpath("//*[name()='use'][contains(@*,'icon-bookmark-line')]");
	//public static By img_favourite_on = By.xpath("//*[name()='use'][contains(@*,'icon-bookmark-fill')]");
	
	
	
}



