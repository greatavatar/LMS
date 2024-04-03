package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import functions.generalFunctions;
import interfaces.I_DashboardPage;
import interfaces.I_HomePage;
import interfaces.I_PartnerList;
import variables.ConstantLib.Constants;

public class F_Navigation {

	/**
	 * Go to lms URL
	 */
	public static void goTolmsURL() {
		
		//Constants.Driver.get(Constants.Url);
		//Face a problem run testsuite not stable in Jenkin (org.openqa.selenium.TimeoutException: timeout). So try to refresh page again after first time access
		try {
				Constants.Driver.navigate().to(Constants.Url);
			} catch (TimeoutException e2) {
			   //LOG.error("Catching timeout exception");
			   System.out.println("\r\n Catching timeout exception");
			   Constants.Driver.navigate().refresh();
			}
		
		
		if(generalFunctions.CheckIsControlAppear(I_HomePage.btn_closeCookieWarning))
		{
			generalFunctions.click(I_HomePage.btn_closeCookieWarning);
		}
		generalFunctions.waitForSeconds(5);
		
	
	}

	/**
	 * Go to lms URL PRODUCTION
	 */
	public static void goToProductionlmsURL() {
		Constants.Driver.navigate().to("https://www.lms.de/");
		//Constants.Driver.get(Constants.Url);
		
		if(generalFunctions.CheckIsControlAppear(I_HomePage.btn_closeCookieWarning))
		{
			generalFunctions.click(I_HomePage.btn_closeCookieWarning);
		}
		generalFunctions.waitForSeconds(5);
	}
	
	/**
	 * Go to Login Page by Top Right Label
	 * 
	 */
	public static void GotologinPage() {

		generalFunctions.click(I_DashboardPage.lik_Login);
		
	}
	
	/**
	 * Go to Dashboard Page by clicking lms Icon
	 * 
	 */
	public static void GotoDashBoard() {

		generalFunctions.click(I_HomePage.img_lmsIcon);
		//generalFunctions.waitForSeconds(1);
		generalFunctions.waitForLoadingIconDisappear();
	}
	
	/**
	 * Go to Partner List page by clicking Partner Icon in header
	 * 
	 */
	public static void GotoPartnerPage() {

		generalFunctions.click(I_HomePage.lik_PartnerList);
		//generalFunctions.waitForSeconds(1);
		generalFunctions.waitForLoadingIconDisappear();
	}
	
	/**
	 * Go to Partner List page by clicking Partner Icon in header
	 * 
	 */
	public static void GoToMyFavouriteList() {

		GotoPartnerPage();
		generalFunctions.click(I_PartnerList.tab_MyFavourite);
	}
	
	/**
	 * Go to MyProfile Page
	 * 
	 */
	public static void GotoMyProfile() {

		generalFunctions.click(I_HomePage.lik_MyProfile);
		//generalFunctions.waitForSeconds(2);
	}
	
	/**
	 * Go to Messenger Page
	 * 
	 */
	public static void GotoMailBox() {

		generalFunctions.click(I_HomePage.lik_MailBox);
	}
	
	/**
	 * Go to a profile in MailBox list
	 * 
	 */
	public static void OpenMailProfileDashboard(int pProfileNumber) {

		generalFunctions.click(By.xpath("//section[contains(@class,'testInbox')]//a[contains(@class,'message-info')]["+ pProfileNumber +"]"));
	}
	
	/**
	 * Go to a profile in Partner list
	 * 
	 */
	public static void OpenPartnerProfileDashboard(int pProfileNumber) {

		generalFunctions.click(By.xpath("//div[contains(@class,'testMatching')]//li["+ pProfileNumber +"]"));
	}
	
	/**
	 * Go to a profile in Interested list
	 * 
	 */
	public static void OpenInterestProfileDashboard(int pProfileNumber) {

		generalFunctions.click(By.xpath("//div[contains(@class,'testInterestInMe')]//li[" + pProfileNumber + "]"));
	}
	
	/**
	 * Close Premium Zero PopUp
	 * 
	 */
	public static void ClosePremiumZeroPopUp() {

		//generalFunctions.click(By.xpath("//a[contains(text(),'Premium nicht nutzen')]"));
		generalFunctions.click(By.xpath("//*[@class='identity-upload__close-popup']"));
		//Workaround for Browserstack
		generalFunctions.waitForSeconds(2);
	}
	
	/**
	 * Go To Profile By UserCode URL
	 * 
	 */
	public static void GoToProfileByUserCode(String pUserCode) {

		Constants.Driver.navigate().to("https://staging.lms.com/partner/profile/overview?partner_code=" + pUserCode);
		generalFunctions.waitForLoadingIconDisappear();
	}
	
}
