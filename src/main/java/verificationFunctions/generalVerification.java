package verificationFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import functions.generalFunctions;
import variables.TCResult;
import variables.ConstantLib.Constants;

public class generalVerification {

	/**
	 * Verify that element is visible
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementVisible(By pBy, String pElementName, TCResult pResult) {
		generalFunctions.waitForControlVisible(pBy);
		generalFunctions.waitForSeconds(1);
		/*WebElement mElement = Constants.Driver.findElement(pBy);
		if (!mElement.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is not displayed");
		}*/
		
		Constants.Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		int size = Constants.Driver.findElements(pBy).size();
		if(size < 1)
		{
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is invisible, it has to be visible");
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
	}

	/**
	 * Verify that element is invisible
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementInvisible(By pBy, String pElementName, TCResult pResult) {
		
		Constants.Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		int size = Constants.Driver.findElements(pBy).size();
		if(size > 0)
		{
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is visible, it has to be invisible");
		}
		
		/*Boolean isPresent = Constants.Driver.findElements(pBy).size() > 0;
		if (isPresent == false) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is visible, it has to be invisible");
		}*/
		
		/*WebElement mElement = Constants.Driver.findElement(pBy);
		if (mElement != null && mElement.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is still displayed");
		}*/
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
	}

	/**
	 * Verify that element is selected
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementSelected(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (!mElement.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is not selected");
		}
	}

	/**
	 * Verify that element is not selected
	 * 
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pElementName
	 *            Name of element to be displayed in error message if error
	 *            occurs
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementNotSelected(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (mElement.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is selected");
		}
	}

	/**
	 * Compare text of actual and expected results
	 * 
	 * @param pFieldName
	 *            Name of the element
	 * @param pActualResult
	 *            Actual value needs to verify
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyElementValue(String pElementName, String pActualResult, String pExpectedResult,
			TCResult pResult) {
		if (!pActualResult.equals(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is displayed " + pActualResult + " instead of " + pExpectedResult);
		}
	}

	/**
	 * Verify element enable
	 * 
	 * @param pElementName
	 *            Name of the element
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void verifyElementEnabled(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (!mElement.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is not enabled");
		}
	}

	/**
	 * Verify element not enable
	 * 
	 * @param pElementName
	 *            Name of the element
	 * @param pBy
	 *            Mechanism of element that contains actual value needs to
	 *            verify
	 * @param pResult
	 *            Result of the test case
	 */
	public static void verifyElementNotEnabled(By pBy, String pElementName, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		if (mElement.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + pElementName + " is enabled");
		}
	}
	
	/**
	 * Compare text of actual and expected results to verify Website Title
	 * 
	 * @param pActualResult
	 *            Actual value needs to verify
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyWebsiteTitle(String pExpectedResult,
			TCResult pResult) {
		String ActualResult = Constants.Driver.getTitle();
		if (!ActualResult.equals(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Webstitle's title should be " + pExpectedResult + " instead of " + ActualResult);
		}
	}

	/**
	 * Verify expected value in a specific attribute of a control
	 * 
	 * @param pBy
	 *            By of a element
	 * @param pAttribute
	 *            Attribute value needs to get
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyAttributeContainValue(By pBy, String pAttribute, String pExpectedResult, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		String ActualResult = mElement.getAttribute(pAttribute);
		if (!ActualResult.contains(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Attribute:" + pAttribute + " value should be  " + pExpectedResult + " instead of " + ActualResult);
		}
	}
	
	/**
	 * Verify expected value NOT in a specific attribute of a control
	 * 
	 * @param pBy
	 *            By of a element
	 * @param pAttribute
	 *            Attribute value needs to get
	 * @param pExpectedResult
	 *            Expected value
	 * @param pResult
	 *            Result of test case
	 */
	public static void verifyAttributeNotContainValue(By pBy, String pAttribute, String pExpectedResult, TCResult pResult) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		String ActualResult = mElement.getAttribute(pAttribute);
		if (ActualResult.contains(pExpectedResult) == true) {
			pResult.SetResult(false);
			pResult.SetMessage("\r\n" + "Attribute:" + pAttribute + " value should be " + pExpectedResult + " instead of " + ActualResult);
		}
	}
	
}
