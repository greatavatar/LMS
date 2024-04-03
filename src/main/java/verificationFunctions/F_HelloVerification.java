package verificationFunctions;


import org.openqa.selenium.By;

import functions.generalFunctions;
import interfaces.*;
//import variables.ConstantLib.Constants;
import variables.TCResult;

public class F_HelloVerification {

	/**
	 * Verify Hello Popup exists
	 */
	public static void Verify_Hello_PopUp_Appear(TCResult pResult) {
		
		generalVerification.verifyElementVisible(By.xpath("//div[@id='say-hello-modal'][@class='modal fade in']//button[contains(text(),'Sag Hallo!')]"), "Say Hello button in Hello PopUp", pResult);

	}
	
	/**
	 * Verify Hello Widget exists
	 */
	public static void Verify_Hello_Widget_Appear(TCResult pResult) {
		
		generalVerification.verifyElementVisible(By.xpath("//div[@class='shadowy-box-wrapper'][not(contains(@style,'display: none;'))]//button[contains(text(),'Sag Hallo!')]"), "Say Hello button in Hello Widget", pResult);

	}

	/**
	 * Verify Hello Popup does not exist
	 */
	public static void Verify_Hello_PopUp_Not_Appear(TCResult pResult) {
		
		generalVerification.verifyElementInvisible(By.xpath("//div[@id='say-hello-modal'][@class='modal fade in']//button[contains(text(),'Sag Hallo!')]"), "Say Hello button in Hello PopUp", pResult);

	}
	
	/**
	 * Verify Hello Widget does not exist
	 */
	public static void Verify_Hello_Widget_Not_Appear(TCResult pResult) {
		
		generalVerification.verifyElementInvisible(By.xpath("//div[@class='shadowy-box-wrapper'][not(contains(@style,'display: none;'))]//button[contains(text(),'Sag Hallo!')]"), "Say Hello button in Hello Widget", pResult);

	}
	
}
