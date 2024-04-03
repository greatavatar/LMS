package functions;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import functions.generalFunctions;
import interfaces.I_VisitProfile_Dashboard;
import variables.ConstantLib.Constants;

public class F_Photo {


	/**
	 * Click to share photo in Partner Profile
	 */
	public static void SharePhotoToAUser() {
		
		generalFunctions.click(I_VisitProfile_Dashboard.img_sharephoto);
		//Delay time before loading icon appear
		generalFunctions.waitForSeconds(2);
		//generalFunctions.waitForLoadingIconDisappear();
		F_Photo.waitForCompleteSharePhotoPopUpDisappear();
	}
	
	/**
	 * Click to Unshare photo in Partner Profile
	 */
	public static void UnSharePhotoToAUser() {
		
		generalFunctions.click(I_VisitProfile_Dashboard.img_unsharephoto);
		generalFunctions.click(I_VisitProfile_Dashboard.btn_unshareOk);
		generalFunctions.click(I_VisitProfile_Dashboard.btn_unshareConfirmed);
		//Workaround for BrowserStack Firefox
		generalFunctions.waitForSeconds(2);
	}
	
	/**
	 * Visit a profile user and make sure that user has share photo button
	 */
	public static void SetStatusToBeSharePhoto() {
		
		Constants.Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		Boolean isPresent = Constants.Driver.findElements(I_VisitProfile_Dashboard.img_unsharephoto).size() > 0;
		if(isPresent == true)
		{
			F_Photo.UnSharePhotoToAUser();
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);	
		
	}
	
	/**
	 * Wait for Complete SharePhoto Popup disappear
	 *            
	 */
	public static void waitForCompleteSharePhotoPopUpDisappear() {
		generalFunctions.waitForElementNotVisible(By.xpath("//div[@id='photo-success-noti'][contains(@style,'display: block')]//span[contains(text(),'Foto gesendet')]"));
				
	}
	
}
