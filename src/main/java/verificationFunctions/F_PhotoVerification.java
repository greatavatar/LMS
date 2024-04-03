package verificationFunctions;


//import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.yaml.snakeyaml.scanner.Constant;

import functions.generalFunctions;
import interfaces.*;
//import variables.ConstantLib.Constants;
import variables.TCResult;

public class F_PhotoVerification {

	/**
	 * Verify Avatar in Partner Profile is unshared
	 * 
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_Partner_Photo_Is_Unshared(TCResult pResult) {
		generalVerification.verifyAttributeContainValue(I_VisitProfile_Dashboard.img_avatar_partner, "src", "e_blur", pResult);
		generalVerification.verifyAttributeNotContainValue(I_VisitProfile_Dashboard.img_relationship_myprofile, "src", "e_blur", pResult);
		generalVerification.verifyAttributeContainValue(I_VisitProfile_Dashboard.img_relationship_partner, "src", "e_blur", pResult);
		generalFunctions.click(I_VisitProfile_Dashboard.tab_matching);
		generalVerification.verifyAttributeContainValue(I_VisitProfile_Dashboard.img_overview_partner, "src", "e_blur", pResult);
		generalVerification.verifyAttributeNotContainValue(I_VisitProfile_Dashboard.img_overview_myprofile, "src", "e_blur", pResult);
	}
	
	/**
	 * Verify Avatar in Partner Profile is share
	 * 
	 * @param pResult
	 *            Result of the test case
	 */
	public static void Verify_Partner_Photo_Is_Shared(TCResult pResult) {
		generalVerification.verifyAttributeNotContainValue(I_VisitProfile_Dashboard.img_avatar_partner, "src", "e_blur", pResult);
		generalVerification.verifyAttributeNotContainValue(I_VisitProfile_Dashboard.img_relationship_partner, "src", "e_blur", pResult);
		generalFunctions.click(I_VisitProfile_Dashboard.tab_matching);
		generalVerification.verifyAttributeNotContainValue(I_VisitProfile_Dashboard.img_overview_partner, "src", "e_blur", pResult);
		generalVerification.verifyAttributeNotContainValue(I_VisitProfile_Dashboard.img_overview_myprofile, "src", "e_blur", pResult);
	}
	
}
