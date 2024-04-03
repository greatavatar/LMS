package functions;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import functions.generalFunctions;
import interfaces.I_Message;
import interfaces.I_VisitProfile_Dashboard;
import variables.ConstantLib.Constants;

public class F_Message {


	/**
	 * Send a message from Partner Profile 
	 */
	public static void SendMessageFromPartnerProfile(String pUserCode, String pMessage) {
		
		generalFunctions.click(I_VisitProfile_Dashboard.img_message);
		SendMessage(pUserCode,pMessage);

	}
	
	/**
	 * Send a message in Messenger UI
	 */
	public static void SendMessage(String pUserCode,String pMessage) {
		
		SelectAUserToSendMessage(pUserCode);
		//Cannot user generalFunction.sendKeys cause of error :Element must be user-editable in order to clear it.
		generalFunctions.sendKeys(I_Message.txt_Message, pMessage);
		
		//Constants.Driver.findElement(I_Message.txt_Message).sendKeys(pMessage);
		generalFunctions.click(I_Message.btn_SendMessageGreen);

	}
	
	/**
	 * Delete a contact/all messages
	 */
	public static void DeleteAllMessages() {
		if(generalFunctions.CheckIsControlAppear(I_Message.btn_RightActions))
		{
			generalFunctions.click(I_Message.btn_RightActions);
			generalFunctions.click(I_Message.lnk_DeleteThread);
			generalFunctions.click(I_Message.btn_ConfirmDelete);
		}
	}

	/**
	 * Send Smiley To a user in Messenger interface
	 */
	public static void SendSmileyInMessenger() {
		
		generalFunctions.click(I_Message.btn_LeftActions);
		generalFunctions.click(I_Message.img_SmileyAction);
	}
	
	/**
	 * Click SharePhoto to a user in Messenger interface
	 */
	public static void SharePhotoInMessenger() {
		
		generalFunctions.click(I_Message.btn_LeftActions);
		generalFunctions.click(I_Message.img_SharePhotoAction);
	}
	
	/**
	 * Send Smiley To a user in Visit Profile page
	 */
	public static void SendSmileyInProfile() {
		
		generalFunctions.click(I_VisitProfile_Dashboard.img_smiley);
		//Workaround for loading icon
		generalFunctions.waitForSeconds(6);
		generalFunctions.waitForElementNotVisible(By.xpath("//span[contains(text(),'Lächeln gesendet')]"));
				
			
	}
	
	/**
	 *
	 */
	public static void SelectAUserToSendMessage(String pUserCode) {
		
		generalFunctions.waitForSeconds(1);
		By By_user = By.xpath("//ul[@class='messenger__contact-list-wrapper']/li//a[contains(@href,'"+pUserCode+"')]//following-sibling::div[1]");
		generalFunctions.click(By_user);
		
	}

}
