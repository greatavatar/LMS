package functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.amazonaws.services.elasticbeanstalk.model.SystemStatus;

import functions.generalFunctions;
import interfaces.I_CreateAccountPages;
import interfaces.I_DashboardPage;
import interfaces.I_HomePage;
import interfaces.I_LoginPage;
import interfaces.I_Mail;
import variables.ConstantLib;
import variables.ConstantLib.Constants;
import variables.ESUser;
import variables.SQLUser;
import variables.Product;

import org.elasticsearch.client.RestClient;
import org.openqa.selenium.Alert;
import org.json.JSONArray;
import org.json.JSONObject;

public class F_Account {
	
	/**
	 * Create lms account
	 * 
	 * @param pEmail
	 *            Email to create
	 * @param pPassword
	 *            Password to create
	 */
	public static void CreateAccount(String pEmail, String pPassword, String pSex) {
			
		//------------------Fill Information Question----------------------------
		
		if(pSex == "female")
		{
			generalFunctions.click(I_HomePage.ra_isFemale);
			generalFunctions.click(I_HomePage.ra_LikeMale);
		}
		else
		{
			generalFunctions.click(I_HomePage.ra_isMale);
			generalFunctions.click(I_HomePage.ra_LikeFemale);
		}
		
		if(pSex == "female")
		{
			 pEmail = "xxxxxxx_female_"+ pEmail;
		}
		else
		{
			pEmail = "xxxxxxx_male_"+ pEmail;
		}
		
		System.out.println(pEmail + Constants.EmailDomain);
		
		generalFunctions.sendlmss(I_HomePage.txt_email,pEmail + Constants.EmailDomain);
		generalFunctions.sendlmss(I_HomePage.txt_password, pPassword);
		generalFunctions.click(I_HomePage.btn_Register);
		
		generalFunctions.waitForSeconds(3);
		generalFunctions.click(I_CreateAccountPages.btn_WelcomePage1);
		generalFunctions.click(I_CreateAccountPages.btn_WelcomePage2);
		generalFunctions.click(I_CreateAccountPages.btn_WelcomePage3);
		
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		
		F_AnswerPictureQuestion("2");
		
		//BrowerStack workaround
		generalFunctions.waitForSeconds(2);
		generalFunctions.sendlmss(I_CreateAccountPages.txt_answer, "test");
		//BrowerStack workaround
		generalFunctions.waitForSeconds(1);
		generalFunctions.click(I_CreateAccountPages.btn_Submit);
		//BrowerStack workaround
		generalFunctions.waitForSeconds(1);
		generalFunctions.click(I_CreateAccountPages.btn_Submit);
		
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(8);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(8);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(5);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(6);
		F_FillRadioQuestion(7);
		F_FillRadioQuestion(7);
		
		F_AnswerPictureQuestion("3");
		generalFunctions.click(I_CreateAccountPages.btn_Submit);
		
		//--------Static value for testing------------
		//String[] toppin = {"Cheese", "Pepperoni", "Black Olives"};
		/*F_AnswerOptionQuestion(new String[] {"Tennis", "Badminton", "Volleyball"});
		F_AnswerOptionQuestion(new String[] {"Mehrmals die Woche"});
		F_AnswerOptionQuestion(new String[] {"Zuhause", "Camping"});
		F_AnswerOptionQuestion(new String[] {"Rock", "Pop", "RnB"});
		F_AnswerOptionQuestion(new String[] {"Nein"});
		F_AnswerOptionQuestion(new String[] {"Freunde treffen", "Familie", "Kino"});
		F_AnswerOptionQuestion(new String[] {"romantisch", "spontan"});
		F_AnswerOptionQuestion(new String[] {"Kunst", "Kochen", "Kino"});*/
		
		F_AnswerOptionQuestion(3);
		F_AnswerOptionQuestion(1);
		F_AnswerOptionQuestion(2);
		F_AnswerOptionQuestion(3);
		
		if(generalFunctions.getRandomInt(0, 1) == 0)
		{	
			F_AnswerOptionQuestion(new String[] {"Ja"});
			F_AnswerOptionQuestion(1);
		}
		else F_AnswerOptionQuestion(new String[] {"Nein"});
		
		F_AnswerOptionQuestion(3);
		F_AnswerOptionQuestion(2);
		F_AnswerOptionQuestion(3);
		generalFunctions.waitForControlVisible(By.xpath("//*[contains(text(),'E-Mail bestätigen und starten!')]"));
		System.out.println("In Process Creating Account: " + pEmail + ConstantLib.Constants.EmailDomain);
		
		//------------------Active Email----------------------------
		generalFunctions.waitForSeconds(3);
		F_ConfirmMail(pEmail, Constants.EmailDomain);
		//generalFunctions.click(I_CreateAccountPages.btn_Submit3);
		
		generalFunctions.waitForSeconds(6);
		Constants.Driver.get(ConstantLib.Constants.Url);
		
		//------------------First Page Submit Profile----------------------------
		
		//+++++++++++++++++++++++Static value for testing+++++++++++++++++++++++++++++
		/*generalFunctions.selectDropDownList(I_CreateAccountPages.sel_Smoking, "Nichtraucher");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_Religion, "Buddhismus");
		generalFunctions.sendlmss(I_CreateAccountPages.txt_Height, "180");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_DescribleSelf, "normal");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_MaritalStatus, "ledig");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_HowImportant, "nicht wichtig");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_JudgeSelf, "attraktiv");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_EstimateAppearance, "sympathisch");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_HowManyChildfren, "1 Kind");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_ChildrenHoldHouse, "1 Kind");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_LikeChildrenPartner, "Ja, wünsche ich mir");*/

		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_Smoking,1);
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_Religion,1);
		generalFunctions.sendlmss(I_CreateAccountPages.txt_Height, Integer.toString(generalFunctions.getRandomInt(160, 190)));
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_DescribleSelf,1);
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_MaritalStatus,1);
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_HowImportant,1);
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_JudgeSelf,1);
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_EstimateAppearance,1);
		
		//Random have children or not
		/*if(generalFunctions.getRandomInt(0, 1) == 0)
		{
			generalFunctions.selectDropDownList(I_CreateAccountPages.sel_HowManyChildfren, "1 Kind");
			generalFunctions.selectDropDownList(I_CreateAccountPages.sel_ChildrenHoldHouse, "1 Kind");
		}
		
		else
		{
			generalFunctions.selectDropDownList(I_CreateAccountPages.sel_HowManyChildfren, "Keine Kinder");
		}*/
		
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_HowManyChildfren, "1 Kind");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_ChildrenHoldHouse, "1 Kind");	
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.sel_LikeChildrenPartner,1);
		
		generalFunctions.click(I_CreateAccountPages.btn_SubmitFirstProfile);
		
		//------------------Second Page Submit Profile----------------------------
		
		//+++++++++++++++++++++++Static value for testing+++++++++++++++++++++++++++++
		/*generalFunctions.sendlmss(I_CreateAccountPages.txt_JobTitle, "test");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_HighestDegree, "Abitur");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_ProfessionalGuild, "Beamter");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Country, "Deutschland");
		generalFunctions.sendlmss(I_CreateAccountPages.txt_FirstName, "autoFirst");
		generalFunctions.sendlmss(I_CreateAccountPages.txt_LastName, "autoSecond");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Day, "1");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Month, "12");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Year, "1988");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Income, "Über 100.000 EUR");
		generalFunctions.sendlmss(I_CreateAccountPages.txt_PostCode, "02625");
		generalFunctions.sendlmss(I_CreateAccountPages.txt_Location, "test location");*/
		
		generalFunctions.sendlmss(I_CreateAccountPages.txt_JobTitle, "auto jobTitle");
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.select_HighestDegree,1);
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.select_ProfessionalGuild,1);
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Country, "Deutschland");
		generalFunctions.sendlmss(I_CreateAccountPages.txt_FirstName, "autoFirst");
		generalFunctions.sendKeys(I_CreateAccountPages.txt_LastName, "autoSecond");
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Day, Integer.toString(generalFunctions.getRandomInt(1, 28)));
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Month, Integer.toString(generalFunctions.getRandomInt(1, 12)));
		generalFunctions.selectDropDownList(I_CreateAccountPages.select_Year, Integer.toString(generalFunctions.getRandomInt(1970, 2000)));
		generalFunctions.selectRandomInDropDownList(I_CreateAccountPages.select_Income,1);
		generalFunctions.sendKeys(I_CreateAccountPages.txt_PostCode, "02625");
		generalFunctions.sendKeys(I_CreateAccountPages.txt_Location, "test location");
		
		//Work around, click first, will create action to set ON OFF
		Constants.Driver.findElement(I_CreateAccountPages.chkbox_confirm).click();
		//generalFunctions.click(I_CreateAccountPages.chkbox_confirm);
		
		generalFunctions.click(I_CreateAccountPages.btn_submitSecondProfile);
		
		//------------------Premium Zero Popup-------------------------------
		generalFunctions.click(I_CreateAccountPages.lik_PremiumCancel);
		
		//------------------Upload Profile Picture----------------------------
		//Workaround for BrowserStack
		generalFunctions.waitForSeconds(2);
		generalFunctions.click(I_CreateAccountPages.lnk_UploadLater);
		generalFunctions.click(I_CreateAccountPages.lnk_StillUploadLater);
		
		//------------------First Questions----------------------------
	
		
		generalFunctions.sendKeys(I_CreateAccountPages.txt_Answer1, "test");
		generalFunctions.selectDropDownList(I_CreateAccountPages.sel_Question2, "In fünf Jahren möchte ich..");
		generalFunctions.sendKeys(I_CreateAccountPages.txt_Answer2, "test");
		
		generalFunctions.click(I_CreateAccountPages.btn_SubmitFinish);
		
		//if(Constants.HeadlessMode.equals("no"))
		//{
			F_Account.WriteLogFile(pEmail + ConstantLib.Constants.EmailDomain, pPassword,pSex);
		//}
		
	}
	
	/**
	 * Fill all radio buttons in question when creating lms account
	 * 
	 * @param pQuestionTotal
	 *            Number of Radio Questions
	 */
	public static void F_FillRadioQuestion(int pQuestionTotal) {
	
		//Use many static waiting for workaround first cause of Radio Custom control
		generalFunctions.waitForSeconds(1);
			
		for(int i=2; i<pQuestionTotal +2; i++)
		{
			int answerChoice = new Random().nextInt(5) + 1;
			
			//By radioAnswer_Xpath = By.xpath("//ul[contains(@class,'test-question__form')]/li["+ i +"]/label["+ answerChoice +"]/div/input");
			By radioAnswer_Xpath = By.xpath("//ul[contains(@class,'test-question__form')]/li["+ i +"]/label["+ answerChoice +"]/div/label");
			generalFunctions.click(radioAnswer_Xpath);
			
			//Custom Radio, can't use regular click function
			//generalFunctions.SetRadioButtonByJavascript(radioAnswer_Xpath);
			//generalFunctions.waitForSeconds(0.25);
		}
		
		generalFunctions.click(I_CreateAccountPages.btn_Submit);
		generalFunctions.waitForSeconds(1);
	}
	
	/**
	 * Answer Picture Question in Creating Account
	 * 
	 * @param pPicChoose
	 *            Order of Picture to answer
	 */
	public static void F_AnswerPictureQuestion(String pPicChoose) {
		
		By pictureChoise_Xpath = By.xpath("//div[contains(@class,'test-question')]/div[" +pPicChoose +"]/img");
		generalFunctions.click(pictureChoise_Xpath);
		generalFunctions.waitForSeconds(1);
		generalFunctions.click(I_CreateAccountPages.btn_Submit);
		//Workaround for BrowserStack
		generalFunctions.waitForSeconds(2);
	}

	/**
	 * Answer in Option Question Pages
	 * 
	 * @param pAnswer
	 *            Value text of the answer
	 */
	public static void F_AnswerOptionQuestion(String[] pAnswer ){
		
		
		for(int i=0; i<pAnswer.length; i++)
		{
		
			By labelXpath = By.xpath("//div[contains(@class,'test-question')][contains(text(),'"+ pAnswer[i] +"')]");
			generalFunctions.click(labelXpath);		
		}
		//Workaround for BrowserStack
		generalFunctions.waitForSeconds(1);
		generalFunctions.click(I_CreateAccountPages.btn_SubmitAnswer);	
		generalFunctions.waitForSeconds(2);
		
		
	}
	
	/**
	 * Answer in Option Question Pages
	 * 
	 * @param pAnswerNumber
	 *            Value text of the answer
	 */
	public static void F_AnswerOptionQuestion(int pAnswerNumber ){
	
		generalFunctions.waitForSeconds(1);
		int lengOfLabel = Constants.Driver.findElements(By.xpath("//li[contains(@class,'pointer')]//div[contains(@class,'test-question__question')]")).size();
		ArrayList<Integer> arrAnswer = generalFunctions.getRandomNonRepeatingIntegers(pAnswerNumber, 1, lengOfLabel);
		for(int i=0; i<pAnswerNumber; i++)
		{
			By labelXpath = By.xpath("//li[contains(@class,'pointer')][" + arrAnswer.get(i)  + "]//div[contains(@class,'test-question__question')]");
			generalFunctions.click(labelXpath);
			generalFunctions.waitForSeconds(0.5);
		}
		//Workaround for BrowserStacks
		generalFunctions.waitForSeconds(2);
		generalFunctions.click(I_CreateAccountPages.btn_SubmitAnswer);	
		generalFunctions.waitForSeconds(2);
		
	}
	
	/**
	 * Open Spam Mail browser and active register link
	 * 
	 * @param pUsernames
	 *            Register User Name Mail
	 * @param pDomain
	 *            Domain Type of Mail (ex: discard.email)
	 *            
	 */
	public static void F_ConfirmMail(String pUsername,String pDomain) {
		
		generalFunctions.waitForSeconds(4);
		//Get the handle id of current window - use this to close new tab later
		String originalHandle = Constants.Driver.getWindowHandle();
		LoginSpamAccount(pUsername, pDomain);	
		generalFunctions.click(I_Mail.lnk_Email);
		
		//Constants.Driver.switchTo().frame("#iframeMessage");
		//Constants.Driver.switchTo().frame(2);
		Constants.Driver.switchTo().frame(Constants.Driver.findElement(By.id("iframeMessage")));
		generalFunctions.waitForSeconds(3);

		JavascriptExecutor jse = (JavascriptExecutor)Constants.Driver;
		WebElement element = Constants.Driver.findElement(By.xpath("//div[@class='email-header']"));
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		jse.executeScript("scroll(0, 300);");
		generalFunctions.waitForSeconds(2);
		generalFunctions.click(I_Mail.lnk_Confirm);
		generalFunctions.waitForSeconds(5);
	
		//Close the second tab
		generalFunctions.CloseAllOtherTabs(originalHandle);
		
	}
	
	/**
	 * Login lms in Login Page
	 * 
	 * @param pEmail
	 *            Email to login
	 * @param pPassword
	 *            Password to login
	 */
	public static void LoginUserInLoginPage(String pEmail, String pPassword) {

		generalFunctions.sendKeys(I_LoginPage.txt_Email, pEmail);
		generalFunctions.sendKeys(I_LoginPage.txt_Password, pPassword);
		//generalFunctions.clickbyJavascript(I_LoginPage.btn_Login);
		generalFunctions.waitForSeconds(3);
		generalFunctions.click(I_LoginPage.btn_Login);		
		generalFunctions.waitForLoadingIconDisappear();
		
		//CloseTourGuidePopUp();
		ClosePremiumPopUp();
		CloseRemindPicturePopUp();
		
	}
	
	/**
	 * Login lms app with Social Network in Login Page
	 * 
	 * @param pEmail
	 *            Email to login
	 * @param pPassword
	 *            Password to login
	 */
	public static void LoginUserInLoginPage(String pEmail, String pPassword, String pEnviroment) {

		if(pEnviroment == "facebook")
		{
		  	generalFunctions.click(I_LoginPage.btn_Facebook);
			for(String handle : Constants.Driver.getWindowHandles()) 
			{
		        if (!handle.equals(Constants.OriginalHandle)) 
		        {
		        	Constants.Driver.switchTo().window(handle);
				generalFunctions.sendKeys(I_LoginPage.txt_FaceboolEmail, pEmail);
				generalFunctions.sendKeys(I_LoginPage.txt_FaceboolPassword, pPassword);
				generalFunctions.click(I_LoginPage.btn_FaceboolLogin);

				Constants.Driver.switchTo().window(Constants.OriginalHandle);
				generalFunctions.waitForSeconds(3);
		        }
			}
		}
		else if(pEnviroment == "google")
		{
			generalFunctions.click(I_LoginPage.btn_Google);
			generalFunctions.waitForSeconds(2);
			for(String handle : Constants.Driver.getWindowHandles()) 
			{
		        if (!handle.equals(Constants.OriginalHandle)) 
		        {
		        	Constants.Driver.switchTo().window(handle);
				generalFunctions.sendKeys(I_LoginPage.txt_GoogleEmail, pEmail);
				generalFunctions.click(I_LoginPage.btn_GoogleNext);
				generalFunctions.sendKeys(I_LoginPage.txt_GooglePassword, pPassword);
				generalFunctions.click(I_LoginPage.btn_GoogleNext);
				
				Constants.Driver.switchTo().window(Constants.OriginalHandle);
				generalFunctions.waitForSeconds(6);
		        }
			}
		}
		
		generalFunctions.waitForLoadingIconDisappear();
		
		//CloseTourGuidePopUp();
		ClosePremiumPopUp();
		CloseRemindPicturePopUp();
		
	}
	
	/**
	 * Login lms in Home Page in PopUp
	 * 
	 * @param pEmail
	 *            Email to login
	 * @param pPassword
	 *            Password to login
	 */
	public static void LoginUser(String pEmail, String pPassword) {

		//generalFunctions.click(I_HomePage.lik_LogIn);
		generalFunctions.waitForControlVisible(I_HomePage.txt_AccountLogin);
		generalFunctions.sendKeys(I_HomePage.txt_AccountLogin, pEmail);
		generalFunctions.sendKeys(I_HomePage.txt_PasswordLogin, pPassword);
		//generalFunctions.clickbyJavascript(I_LoginPage.btn_Login);
		generalFunctions.click(I_HomePage.btn_Login);
		generalFunctions.waitForLoadingIconDisappear();
		
		//CloseTourGuidePopUp();
		ClosePremiumPopUp();
		CloseRemindPicturePopUp();
		
	}
	
	/**
	 * Login lms app with Social Network
	 * 
	 * @param pEmail
	 *            Email to login
	 * @param pPassword
	 *            Password to login
	 */
	public static void LoginUser(String pEmail, String pPassword, String pEnviroment) {

		if(pEnviroment == "facebook")
		{
			generalFunctions.click(I_DashboardPage.btn_FacebookLogin);
			for(String handle : Constants.Driver.getWindowHandles()) 
			{
		        if (!handle.equals(Constants.OriginalHandle)) 
		        {
		        	Constants.Driver.switchTo().window(handle);
				generalFunctions.sendKeys(I_LoginPage.txt_FaceboolEmail, pEmail);
				generalFunctions.sendKeys(I_LoginPage.txt_FaceboolPassword, pPassword);
				generalFunctions.click(I_LoginPage.btn_FaceboolLogin);
				Constants.Driver.switchTo().window(Constants.OriginalHandle);
				
		        }
			}
		
		}
		else if(pEnviroment == "google")
		{
			generalFunctions.click(I_DashboardPage.btn_GoogleLogin);
			for(String handle : Constants.Driver.getWindowHandles()) 
			{
				generalFunctions.waitForSeconds(5);
				if (!handle.equals(Constants.OriginalHandle)) 
		        {
		        	Constants.Driver.switchTo().window(handle);
				generalFunctions.sendKeys(I_LoginPage.txt_GoogleEmail, pEmail);
				generalFunctions.click(I_LoginPage.btn_GoogleNext);
				generalFunctions.waitForSeconds(5);
				generalFunctions.sendKeys(I_LoginPage.txt_GooglePassword, pPassword);
				generalFunctions.click(I_LoginPage.btn_GoogleNext);
				generalFunctions.waitForSeconds(5);
				Constants.Driver.switchTo().window(Constants.OriginalHandle);
		        }
			}
		}
		
		generalFunctions.waitForSeconds(3);
		generalFunctions.waitForLoadingIconDisappear();
		
		//CloseTourGuidePopUp();
		ClosePremiumPopUp();
		CloseRemindPicturePopUp();		
	}
	
	/**
	 * Login Spam Mail Templr web
	 * 
	 * @param pUserName
	 *            Email to login
	 * @param pDomain
	 *            Domain to login
	 */
	public static void LoginSpamAccount(String pUserName, String pDomain) {

		if(Constants.EmailDomain.equals("@cmail.club"))
		{
			Constants.Driver.get("https://getnada.com");
			generalFunctions.click(I_Mail.lnk_AddInboxNaDa);
			
			
			generalFunctions.sendKeys(I_Mail.txt_EmailNaDa, pUserName);
			generalFunctions.selectDropDownList(I_Mail.sel_domainNaDa, pDomain.split("@")[1]);
			generalFunctions.click(I_Mail.btn_AcceptNaDa);
			generalFunctions.waitForSeconds(4);
		    
		}
		else
		{
			
			//Face a problem run testsuite not stable in Jenkin (org.openqa.selenium.TimeoutException: timeout). So try to refresh page again after first time access
			try {
					Constants.Driver.get("https://tempr.email");
				} catch (TimeoutException e2) {
				   //LOG.error("Catching timeout exception");
				   System.out.println("\r\n Catching timeout exception");
				   Constants.Driver.navigate().refresh();
				}
			generalFunctions.waitForSeconds(6);	
			generalFunctions.sendKeys(I_Mail.txt_Username, pUserName);
			generalFunctions.selectDropDownList(I_Mail.sel_domain, pDomain.split("@")[1]);
			//Usually face timeout error in JENKIN
			generalFunctions.waitForSeconds(7);
			generalFunctions.click(I_Mail.btn_Login);
			//Workaround for Browserstacks
			generalFunctions.waitForSeconds(4);
			
			try {
				Constants.Driver.navigate().refresh();
			} catch (TimeoutException e2) {
			   //LOG.error("Catching timeout exception");
			   System.out.println("\r\n Catching timeout exception");
			   Constants.Driver.navigate().refresh();
			}
		}
			
		
	}
	
	/**
	 * Write to Log File a created account
	 * 
	 * @param pEmail
	 *            Email to log
	 * @param pPassword
	 *            Password to log
	 */
	
	/*public static void WriteLogFile(String pAccountName, String pPassword) {
		 Logger logger = Logger.getLogger("AccountNameLog");  
		    FileHandler fh;  
		    
		    try {  
		        // This block configure the logger with handler and formatter  
		    		fh =  new FileHandler(Constants.Init_Folder + "/MyLogFile.log", true);
		        logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  

		        // the following statement is used to log any messages  
		        logger.info(pAccountName + "----" + pPassword);  

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }
		}*/
		public static void WriteLogFile(String pAccountName, String pPassword, String pSex){
			try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.Init_Folder + "/MyLogFile.txt", true));
		    		    writer.append("\r\n");
		    		    writer.append(pAccountName + "  ----  " + pPassword + "------" + pSex);
		    		    writer.close();
		    		    }
			catch (SecurityException e) {  
		    		        e.printStackTrace();  
		    		    } catch (IOException e) {  
		    		        e.printStackTrace();  
		    		    }
		    		}
	
	/**
	 * Logout lms app
	 * 
	 */
	public static void LogOutUser() {

		generalFunctions.waitForLoadingIconDisappear();
		generalFunctions.waitForSeconds(3);
		F_Navigation.GotoDashBoard();
		generalFunctions.click(I_HomePage.lik_LogOut);
	}
	
	/**
	 * Delete all existing mails of a SPAM MAIL account
	 * 	 
	 * @param pUserName
	 *            UserName to log in https://tempr.email/
	 * @param pPassword
	 *            Domain to log in https://tempr.email/
	 * 
	 */
	public static void DeleteAllSpamMail(String pUserName, String pDomain) {

		LoginSpamAccount(pUserName, pDomain);		
		
		if (Constants.EmailDomain.equals("@cmail.club"))
		{
			Constants.Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			List<WebElement> Checkbox_list = Constants.Driver.findElements(By.xpath("//ul[@class='msg_list']/li"));
			//System.out.println("\r\n CHECKBOX NUMBERR: " + Checkbox_list.size());
			if(Checkbox_list.size()>0)
			{
				//System.out.println("VO FORRRRRRR");
				for(int i=0; i<Checkbox_list.size(); i++)
				{
					Checkbox_list = Constants.Driver.findElements(By.xpath("//ul[@class='msg_list']/li"));
					Checkbox_list.get(0).click();
					generalFunctions.click(By.xpath("//i[@class='icon-trash-empty']"));
				}
			}
			Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);	
		}
		else
		{
			Constants.Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			List<WebElement> Checkbox_list = Constants.Driver.findElements(By.xpath("//div[@id='Inbox']/div/div[@class='Status']/input"));
			if(Checkbox_list.size()>0)
			{
				for(int i=0; i<Checkbox_list.size(); i++)
				{
					//Checkbox_list.get(i).click();
					((JavascriptExecutor) Constants.Driver).executeScript("arguments[0].checked = true;", Checkbox_list.get(i));
					//((JavascriptExecutor) Constants.Driver).executeScript("arguments[0].click();", Checkbox_list.get(i));
				}
				//Scroll down to bottom page to avoid advertise banner
				((JavascriptExecutor) Constants.Driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				generalFunctions.click(By.xpath("//input[@name='RemoveMoreButton']"));
				Alert alert = Constants.Driver.switchTo().alert();
				alert.accept();
				Constants.Driver.switchTo().window(Constants.OriginalHandle );
			}
			Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);	
		
		}
		
	}
	
	/**
	 * Set a specific value for Degree field in My Profile
	 * 	 
	 * @param pNumberDegreeChoice
	 *            Number of Radio button to be clicked for Degree column
	 * @param pNumberTitleChoice
	 *            pNumber of Radio button to be clicked for Title column
	 *            
	 */
	public static void SetValueDegree(String pNumberDegreeChoice, String pNumberTitleChoice) {

		
		//By by_Edit_Button = By.xpath("//div[contains(@class,'left__facts')]/ul/li[4]/*[@data-target='#edit-education']");
		//generalFunctions.waitForSeconds(2);
		//generalFunctions.click(by_Edit_Button);
		//generalFunctions.clickbyJavascript(by_Edit_Button);
		
		By by_Education = By.xpath("//div[@class='facts']/div[4]");
		generalFunctions.click(by_Education);
		
		if(pNumberDegreeChoice != "")
		{
			generalFunctions.click(By.xpath("//div[contains(text(),'Akademischer Grad')]/following-sibling::div["+pNumberDegreeChoice+"]"));
		}
		
		if(pNumberTitleChoice != "")
		{
			generalFunctions.click(By.xpath("//div[contains(text(),'Titel')]/following-sibling::div["+pNumberTitleChoice+"]"));
		}
		generalFunctions.click(By.xpath("//div[@id='editEdu']//button[contains(text(),'Speichern')]"));
		generalFunctions.waitForSeconds(3);
	}
	
	/**
	 * Set a specific value for Having Kid field in My Profile
	 * 	 
	 * @param pYesNo
	 *            Yes or No for have any kid
	 * @param pHowMany
	 *            Value for HowMany select control
	 * @param pHouseHold
	 *            Value for HouseHold select control                   
	 */
	public static void SetValueHavingKid(String pYesNo, String pHowMany, String pHouseHold) {

		//By by_Edit_Button = By.xpath("//div[contains(@class,'left__facts')]/ul/li[8]/*[@data-target='#edit-having-kids']");
		//generalFunctions.click(by_Edit_Button);
		
		By by_ChildrenInHouse = By.xpath("//div[@class='facts']/div[8]");
		generalFunctions.click(by_ChildrenInHouse);

		
		if(pYesNo == "Yes")
		{
			//generalFunctions.click(By.xpath("//div[@id='editHaveKids']//input[@id='rdHaveKids']"));
			generalFunctions.click(By.xpath("//div[@id='editHaveKids']//*[contains(text(),'Ja')]"));
			
		}
		else if(pYesNo == "No")
		{
			//generalFunctions.clickbyJavascript(By.xpath("//div[@id='editHaveKids']//input[@id='rdNoKids']"));
			generalFunctions.click(By.xpath("//div[@id='editHaveKids']//*[contains(text(),'Nein')]"));
		}
		
		if(pHowMany != "")
		{
			generalFunctions.selectDropDownList(By.xpath("//label[contains(text(),'Wenn ja, wie viele')]//following-sibling::select"), pHowMany);
		}
		
		if(pHouseHold != "")
		{
			generalFunctions.selectDropDownList(By.xpath("//label[contains(text(),'Wie viele Kinder leben in Ihrem Haushalt?')]//following-sibling::select"), pHouseHold);
		}
		generalFunctions.click(By.xpath("//div[@id='editHaveKids']//button[contains(text(),' Speichern')]"));		
		generalFunctions.waitForSeconds(3);
	}
	
	/**
	 * If Premium Popup appears in Dashboard page, close it
	 *            
	 */
	public static void ClosePremiumPopUp() {

		By by_Cancel_Button = By.xpath("//div[@class='modal fade in']//a[@class='promotion-dismiss']");
		if(generalFunctions.CheckIsControlAppear(by_Cancel_Button))
		{
			generalFunctions.click(By.xpath("//a[@class='promotion-dismiss']"));
			generalFunctions.waitForSeconds(3);
		}
	}
	
	
	/**
	 * If Premium Popup appears in Dashboard page, close it
	 *            
	 */
	public static void CloseTourGuidePopUp() {

		By by_Close_Button = By.xpath("//div[contains(@class,'tour-close')]");
		//if(!generalFunctions.isCookiePresent("hasSeenTourPopup"))
		if(generalFunctions.CheckIsControlAppear(by_Close_Button))
		{
			generalFunctions.click(by_Close_Button);
			generalFunctions.waitForSeconds(3);
		}	
		
	}
	
	/**
	 * If Premium Popup appears in Dashboard page, close it
	 *            
	 */
	public static void CloseRemindPicturePopUp() {

		By by_Close_Button = By.xpath("//div[@class='modal fade in']//div[contains(text(),'Fotos später hochladen')]");
		if(!generalFunctions.isCookiePresent("hasSeenRemindUploadAvatarPopup"))
		if(generalFunctions.CheckIsControlAppear(by_Close_Button))
		{
			generalFunctions.click(by_Close_Button);
			generalFunctions.waitForSeconds(3);
		}	
	}
	
	
	/**
	 * Get Username of account by its UserID
	 * 	               
	 */
	public static String DS_GetUserNameByUserID(String pUserID ) {
		String UserName = "";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "SELECT username FROM fos_user WHERE id='" + pUserID + "'" ;
			stmt = con.createStatement();
			//System.out.println("Query is: " + query + "\r\n");
			rs = stmt.executeQuery(query);
			rs.last();
	        //System.out.println(" total result set row is: " + rs.getRow() + "\r\n");
	        if (rs.getRow() > 0)
	        		{
	        			rs.first();
	        			UserName = rs.getString("username");
		        		//System.out.println("Order ID: " + OrderId + "has ordered for Usercode: " + pUserCode + "\r\n");	
	        		} 
	        else System.out.println("\r\n There is no username for this userID: " + pUserID);
	        }
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }	
		    
		}
		
		return UserName;					
	}
	
	/**
	 * Get the total number of all users in our system
	 * 	               
	 */
	public static int DS_GetToTalNumberOfAllUsers() {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		int userNumber = 0;
		try {
			con = generalFunctions.ConnectDataBase();
			String query = "SELECT count(*) as `number` FROM fos_user" ;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			userNumber = rs.getInt("number");
			System.out.println("********Total users for checking is : " + userNumber);
		}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }	
		    
		}
		
		return userNumber;					
	}
	
	/**
	 * Update the date of Complete_Profile_2 in Database
	 * @param pDate
	 *            Value to set complete_profile_2_at column: today, "19/04/2018"
	 * 	               
	 */
	public static void DS_UpdateCompleteProfile2(String pUserID,String pDate) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		String query = "";
		try 
		{
			con = generalFunctions.ConnectDataBase();
			if(pDate.equals("today"))
			{
				query = "Update fos_user set `complete_profile_2_at` = current_date() where id = '" + pUserID + "'";
			}
			else
			{
				query = "Update fos_user set `complete_profile_2_at` = '"+ pDate +"' where id = '" + pUserID + "'";
			}
			
			//System.out.println("Query is: " + query + "\r\n");
			stmt = con.createStatement();
    			stmt.executeUpdate(query);    
	     }
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }	
		}
	}
	
	/**
	 * Get Values of a column with SQL query
	 * 	               
	 */
	public static String DS_GetValuesInAColumn(String pQuery,String pColumnName ) {
		String ValueList = "";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try 
		{
			con = generalFunctions.ConnectDataBase();
			stmt = con.createStatement();
			//System.out.println("Query is: " + query + "\r\n");
			rs = stmt.executeQuery(pQuery);
			while (rs.next()) 
			{
				ValueList = ValueList + "," + rs.getString(pColumnName);
			}
		}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		        		con.close();
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }	
		    
		}
		if (ValueList.isEmpty())
			return ValueList;
		else return ValueList.substring(1);					
	}

	//--------------------------------------------------------------------------------------------
	/**
	 * Get Array of USER object which contains all value of a user in SQL Database
	 * @param pQuery
	 *            Select query needs to run. Ex: Select * from fos_user where...
	 * @param pArrayUser
	 *            Array User needs to add values and return	               
	 */
	public static Map<String, SQLUser> DS_GetValuesOfUsers(String pQuery, Map<String, SQLUser> pArrayDSUser) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		//ArrayList<User> pArrayUser = new ArrayList<User>();
		try 
		{
			con = generalFunctions.ConnectDataBase();
			stmt = con.createStatement();
			//System.out.println("Query is: " + pQuery + "\r\n");
			rs = stmt.executeQuery(pQuery);
	        //System.out.println(" total result set row is: " + rs.getRow() + "\r\n");
			
			while (rs.next()) 
			{
				SQLUser userObject = new SQLUser();
				userObject.setSQL_UserId(rs.getString("id"));
				userObject.setSQL_UserName(rs.getString("username"));
				userObject.setSQL_Age(rs.getString("dob"));
				userObject.setSQL_Gender(rs.getString("gender")); 
				userObject.setSQL_GenderSearch(rs.getString("gender_search"));
				userObject.setSQL_IncomeFrom(rs.getString("income_from"));
				if (userObject.getSQL_IncomeFrom() == null)
				{
					userObject.setSQL_IncomeFrom("empty");
				}
				userObject.setSQL_IncomeTo(rs.getString("income_to"));
				if (userObject.getSQL_IncomeTo() == null)
				{
					userObject.setSQL_IncomeTo("empty");
				}
				userObject.setSQL_Country(rs.getString("country"));		
				userObject.setSQL_Education(rs.getString("education_highest_degree"));
				pArrayDSUser.put(userObject.getSQL_UserId(), userObject);
            	}
	    	}
		catch(SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }	
		}
		return pArrayDSUser;
	}
	
	/**
	 * Get Array of USER object which contains all value of a user in SQL Database
	 * @param pQuery
	 *            Select query needs to run. Ex: Select * from fos_user where...
	 * @param pArrayUser
	 *            Array User needs to add values and return	               
	 */
	public static Map<String, ESUser> ES_GetValuesOfUsers(String pQuery, Map<String, ESUser> pESArrayUser) {
	
		RestClient client = generalFunctions.ConnectElasticSearch();
		JSONArray JsonArrayUser = generalFunctions.ES_RunSelectQuery(pQuery);
		try
		{
			//System.out.println("--------length-------"+JsonArrayUser.length());
			for(int i = 0; i < JsonArrayUser.length() ; i++)
			{
				
				//System.out.println(JsonArrayUser.get(0).toString());
				
				//String strHit = JsonArrayUser.getString(i);
				//JSONObject jsonUser = (new JSONObject(strHit)).getJSONObject("_source");	
		
				String strHit = JsonArrayUser.get(i).toString();
				
				JSONObject jsonUser = (new JSONObject(strHit)).getJSONObject("_source");
								
				ESUser user = new ESUser();
				
				user.setES_Age(jsonUser);
				user.setES_Country(jsonUser);
				user.setES_Gender(jsonUser);
				user.setES_GenderSearch();
				user.setES_UserId(jsonUser);
				user.setES_IncomeFrom(jsonUser);
				user.setES_IncomeTo(jsonUser);
				user.setES_Education(jsonUser);
				
				pESArrayUser.put(user.getES_UserId(), user);
				
			}
		} 
		catch(Exception e)
        {
        		System.out.println(e.toString());
        		System.out.println(e.getStackTrace());
        		
        }
		finally
		{
			 try {
				 client.close();
		        } catch (Exception e) { }

			 client = null;
		    
		}
		
		return pESArrayUser;
	}
	
	
	/**
	 * Get Correct Product IDs for list of users
	 * 	               
	 */
	public static void DS_GetRightProductIDsForUsers(String pUserIDs) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ArrayList<Product> ArrProduct = new ArrayList<Product>();
		try 
		{
			con = generalFunctions.ConnectDataBase();
			stmt = con.createStatement();
			String query = "SELECT `user_id`, `pid`,`product_price_gross`,`product_type`\r\n" + 
					"FROM (\r\n" + 
					"(SELECT z.`user_id` as `user_id`,\r\n" + 
					"       pro.`id` as `pid`,\r\n" + 
					"       pro.`product_price_gross` as `product_price_gross`,\r\n" + 
					"       pro.`product_type` as `product_type`\r\n" + 
					"FROM (\r\n" + 
					"  SELECT a.`user_id`,\r\n" + 
					"         p.`id` AS `product_id`,\r\n" + 
					"         p.`renewal_product_id`,\r\n" + 
					"         p.`product_price_gross`,\r\n" + 
					"         p.`product_type`\r\n" + 
					"  FROM (\r\n" + 
					"    SELECT `fu`.`id` AS `user_id`,\r\n" + 
					"           `up`.`gender`,\r\n" + 
					"           `up`.`gender_search`,\r\n" + 
					"           `up`.`country`,\r\n" + 
					"           # income rule\r\n" + 
					"           CASE\r\n" + 
					"             WHEN `up`.`income_from` = 0  AND `up`.`income_to` = 15000 THEN 1\r\n" + 
					"             WHEN `up`.`income_from` = 15000  AND `up`.`income_to` = 25000 THEN 2\r\n" + 
					"             WHEN `up`.`income_from` = 25000  AND `up`.`income_to` = 35000 THEN 3\r\n" + 
					"             WHEN `up`.`income_from` = 35000  AND `up`.`income_to` = 50000 THEN 4\r\n" + 
					"             WHEN `up`.`income_from` = 50000  AND `up`.`income_to` = 100000 THEN 5\r\n" + 
					"             ELSE 6\r\n" + 
					"           END AS `income`,\r\n" + 
					"           # age rules\r\n" + 
					"           CASE\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) > 0 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 24 THEN 1\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 25 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 30 THEN 2\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 31 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 35 THEN 6\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 36 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 45 THEN 3\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 46 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 55 THEN 4\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 56 THEN 5\r\n" + 
					"           END AS `age`,\r\n" + 
					"           # education rules\r\n" + 
					"           CASE\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Abgeschlossenes Studium' THEN 1\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Noch im Studium' THEN 2\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Einige Semester studiert (z.Z. nicht aktiv)' THEN 3\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Abitur' THEN 4\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Real-/Handels-/Fachschulabschluss' THEN 5\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Hauptschulabschluss' THEN 6\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Niedrigerer Abschluss' THEN 7\r\n" + 
					"           END AS `education`,\r\n" + 
					"            # country\r\n" + 
					"           CASE\r\n" + 
					"             WHEN `up`.`country` = 'germany' THEN 1\r\n" + 
					"             WHEN `up`.`country` = 'austria' THEN 2\r\n" + 
					"             WHEN `up`.`country` = 'switzerland' THEN 3\r\n" + 
					"           END AS `countries`\r\n" + 
					"    \r\n" + 
					"    FROM `fos_user` AS `fu`,\r\n" + 
					"         `user_profile` AS `up`\r\n" + 
					"    \r\n" + 
					"    WHERE `fu`.`id` = `up`.`user_id`\r\n" + 
					"          AND `fu`.`complete_profile_2_at` IS NOT NULL AND `fu`.`id` in ("+ pUserIDs +")) AS a\r\n" + 
					"    \r\n" + 
					"  INNER JOIN `product` p ON (a.`income` = p.`income_id`\r\n" + 
					"                             AND a.`age` = p.`age_group_id`\r\n" + 
					"                             AND a.`gender` = p.`gender_id`\r\n" + 
					"                             AND a.`gender_search` = p.`gender_search_id`\r\n" + 
					"                             AND a.`education` = p.`education_id`\r\n" + 
					"                             AND a.`countries` = p.`country_id`\r\n" + 
					"                             AND p.`single_parent_id` = 0\r\n" + 
					"                             AND p.`is_deactivated` = 0) \r\n" + 
					"   \r\n" + 
					"    ) AS z\r\n" + 
					"  \r\n" + 
					"INNER JOIN `product` AS pro ON \r\n" + 
					"pro.`id` = z.`product_id`\r\n" + 
					")\r\n" + 
					"UNION\r\n" + 
					"(SELECT z.`user_id` as `user_id`,\r\n" + 
					"       pro.`id` as `pid`,\r\n" + 
					"       pro.`product_price_gross` as `product_price_gross`,\r\n" + 
					"       pro.`product_type` as `product_type`\r\n" + 
					"FROM (\r\n" + 
					"  SELECT a.`user_id`,\r\n" + 
					"         p.`id` AS `product_id`,\r\n" + 
					"         p.`renewal_product_id`,\r\n" + 
					"         p.`product_price_gross`,\r\n" + 
					"         p.`product_type`\r\n" + 
					"  FROM (\r\n" + 
					"    SELECT `fu`.`id` AS `user_id`,\r\n" + 
					"           `up`.`gender`,\r\n" + 
					"           `up`.`gender_search`,\r\n" + 
					"           `up`.`country`,\r\n" + 
					"           # income rule\r\n" + 
					"           CASE\r\n" + 
					"             WHEN `up`.`income_from` = 0  AND `up`.`income_to` = 15000 THEN 1\r\n" + 
					"             WHEN `up`.`income_from` = 15000  AND `up`.`income_to` = 25000 THEN 2\r\n" + 
					"             WHEN `up`.`income_from` = 25000  AND `up`.`income_to` = 35000 THEN 3\r\n" + 
					"             WHEN `up`.`income_from` = 35000  AND `up`.`income_to` = 50000 THEN 4\r\n" + 
					"             WHEN `up`.`income_from` = 50000  AND `up`.`income_to` = 100000 THEN 5\r\n" + 
					"             ELSE 6\r\n" + 
					"           END AS `income`,\r\n" + 
					"           # age rules\r\n" + 
					"           CASE\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) > 0 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 24 THEN 1\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 25 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 30 THEN 2\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 31 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 35 THEN 6\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 36 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 45 THEN 3\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 46 AND TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) <= 55 THEN 4\r\n" + 
					"             WHEN TIMESTAMPDIFF(YEAR, fu.`dob`, CURDATE()) >= 56 THEN 5\r\n" + 
					"           END AS `age`,\r\n" + 
					"           # education rules\r\n" + 
					"           CASE\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Abgeschlossenes Studium' THEN 1\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Noch im Studium' THEN 2\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Einige Semester studiert (z.Z. nicht aktiv)' THEN 3\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Abitur' THEN 4\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Real-/Handels-/Fachschulabschluss' THEN 5\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Hauptschulabschluss' THEN 6\r\n" + 
					"             WHEN `up`.`education_highest_degree` = 'Niedrigerer Abschluss' THEN 7\r\n" + 
					"           END AS `education`,\r\n" + 
					"          # country\r\n" + 
					"           CASE\r\n" + 
					"             WHEN `up`.`country` = 'germany' THEN 1\r\n" + 
					"             WHEN `up`.`country` = 'austria' THEN 2\r\n" + 
					"             WHEN `up`.`country` = 'switzerland' THEN 3\r\n" + 
					"           END AS `countries`\r\n" + 
					"\r\n" + 
					"           \r\n" + 
					"    \r\n" + 
					"    FROM `fos_user` AS `fu`,\r\n" + 
					"         `user_profile` AS `up`\r\n" + 
					"    \r\n" + 
					"    WHERE `fu`.`id` = `up`.`user_id`\r\n" + 
					"          AND `fu`.`complete_profile_2_at` IS NOT NULL AND `fu`.`id` in ("+ pUserIDs +")) AS a\r\n" + 
					"    \r\n" + 
					"  INNER JOIN `product` p ON (a.`income` = p.`income_id`\r\n" + 
					"                             AND a.`age` = p.`age_group_id`\r\n" + 
					"                             AND a.`gender` = p.`gender_id`\r\n" + 
					"                             AND a.`gender_search` = p.`gender_search_id`\r\n" + 
					"                             AND a.`education` = p.`education_id`\r\n" + 
					"                             AND a.`countries` = p.`country_id`\r\n" + 
					"                             AND p.`single_parent_id` = 0\r\n" + 
					"                             AND p.`is_deactivated` = 0) \r\n" + 
					"   \r\n" + 
					"    ) AS z\r\n" + 
					"  \r\n" + 
					"INNER JOIN `product` AS pro ON \r\n" + 
					"pro.`id` = z.`renewal_product_id` \r\n" + 
					")) as m \r\n" + 
					"ORDER BY m.user_id,m.product_type,m.pid";
			
			//System.out.println("Query is: " + query + "\r\n");
			rs = stmt.executeQuery(query);
			if(generalFunctions.GetResultSetSize(rs)>0)
			{
				rs.beforeFirst();
				int i=1;
				Product mProduct = null;
				while (rs.next()) 
				{
					
					if(i==1)
					{
						mProduct = new Product();
						mProduct.setUserID(rs.getString("user_id"));
						mProduct.setProductID1(rs.getString("pid"));
						mProduct.setProductID1_PriceGross(rs.getString("product_price_gross"));
						i = i + 1;
					}
					else if(i==2)
					{
						mProduct.setProductID2(rs.getString("pid"));
						mProduct.setProductID2_PriceGross(rs.getString("product_price_gross"));
						i = i + 1;
					}
					else if(i==3)
					{
						mProduct.setProductID3(rs.getString("pid"));
						mProduct.setProductID3_PriceGross(rs.getString("product_price_gross"));
						i = i + 1;
					}
					else if(i==4)
					{
						mProduct.setProductRenewalID1(rs.getString("pid"));
						mProduct.setProductRenewalID1_PriceGross(rs.getString("product_price_gross"));
						i = i + 1;
					}
					else if(i==5)
					{
						mProduct.setProductRenewalID2(rs.getString("pid"));
						mProduct.setProductRenewalID2_PriceGross(rs.getString("product_price_gross"));
						i = i + 1;
					}
					else if(i==6)
					{
						mProduct.setProductRenewalID3(rs.getString("pid"));
						mProduct.setProductRenewalID3_PriceGross(rs.getString("product_price_gross"));
						i = 1;
						ArrProduct.add(mProduct);
					}
								
						//System.out.print("---" + rs.getString("pid") + "  " + rs.getString("product_price_gross"));	
				}
					
				writeLogFileProducts(ArrProduct);
				for(int j=0;j<ArrProduct.size();j++)
				{
					System.out.println("UserID: " + ArrProduct.get(j).getUserID());	
					System.out.println("-------Product1: " + ArrProduct.get(j).getProductID1() + "  Price_Gross: " + ArrProduct.get(j).getProductID1_PriceGross());	
					System.out.println("-------Product2: " + ArrProduct.get(j).getProductID2() + "  Price_Gross: " + ArrProduct.get(j).getProductID2_PriceGross());
					System.out.println("-------Product3: " + ArrProduct.get(j).getProductID3() + "  Price_Gross: " + ArrProduct.get(j).getProductID3_PriceGross());
					System.out.println("-------ProductRenewal1: " + ArrProduct.get(j).getProductRenewalID1() + "  Price_Gross: " + ArrProduct.get(j).getProductRenewalID1_PriceGross());
					System.out.println("-------ProductRenewal2: " + ArrProduct.get(j).getProductRenewalID1() + "  Price_Gross: " + ArrProduct.get(j).getProductRenewalID2_PriceGross());
					System.out.println("-------ProductRenewal3: " + ArrProduct.get(j).getProductRenewalID1() + "  Price_Gross: " + ArrProduct.get(j).getProductRenewalID3_PriceGross());

				}
			}
			else
			{
				System.out.println("CANT FIND ANY PRODUCTS FOR EXPECTED USERS");
			}
			
		
		}
		catch(SQLException ex)
		{
			   System.out.println("SQLException: " + ex.getMessage());
			   System.out.println("SQLState: " + ex.getSQLState());
			   System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		            con.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		       
		}
					
	}
	
	/**
	 * Get and Write list of 3 ProductIDs, 3 Renewal ProductIDs,Gross to a CVS file 
	 * 	               
	 */
	 public static void writeLogFileProducts(ArrayList<Product> pArrayProduct) {
	        try
	        {
			 	PrintWriter pw = new PrintWriter(new File("test.csv"));
		        StringBuilder sb = new StringBuilder();
		        sb.append("id");
		        sb.append(',');
		        sb.append("Product 1");
		        sb.append(',');
		        sb.append("Product Price Gross 1");
		        sb.append(',');
		        sb.append("Product 2");
		        sb.append(',');
		        sb.append("Product Price Gross 2");
		        sb.append(',');
		        sb.append("Product 3");
		        sb.append(',');
		        sb.append("Product Price Gross 3");
		        sb.append(',');
		        sb.append("Product Renewal 1");
		        sb.append(',');
		        sb.append("Product Renewal Price Gross 1");
		        sb.append(',');
		        sb.append("Product Renewal 2");
		        sb.append(',');
		        sb.append("Product Renewal Price Gross 2");
		        sb.append(',');
		        sb.append("Product Renewal 3");
		        sb.append(',');
		        sb.append("Product Renewal Price Gross 3");
		        sb.append('\n');
	
		        for(int i=0;i<pArrayProduct.size();i++)
		        {
		        		sb.append(pArrayProduct.get(i).getUserID());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductID1());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductID1_PriceGross());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductID2());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductID2_PriceGross());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductID3());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductID3_PriceGross());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductRenewalID1());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductRenewalID1_PriceGross());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductRenewalID2());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductRenewalID2_PriceGross());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductRenewalID3());
		        		sb.append(',');
		        		sb.append(pArrayProduct.get(i).getProductRenewalID3_PriceGross());
		        		sb.append('\n');
		        }
		        pw.write(sb.toString());
		        pw.close();
		        System.out.println("write file Expected Products done!");
	 		}
	        catch(Exception e)
	        {
	        		System.out.println(e.toString());
	        }
	    }
	 
	 /**
	  * Get a Random UserName,Password, UserId of a random user in system
	  * 	               
	  */
	 public static SQLUser DS_GetRandomAUser() {
			Connection con = null;
			ResultSet rs = null;
			Statement stmt = null;
			SQLUser user = new SQLUser();
			String query = "SELECT * FROM fos_user, (SELECT RAND() * (SELECT MAX(id)-10 FROM fos_user) AS tid) AS tmp WHERE fos_user.id >= tmp.tid and fos_user.complete_profile_2_at is not null and fos_user.username not like '%user_deleted%' LIMIT 1";
			try 
			{
				con = generalFunctions.ConnectDataBase();
				stmt = con.createStatement();
				//System.out.println("Query is: " + query + "\r\n");
				rs = stmt.executeQuery(query);
				rs.beforeFirst();
				while (rs.next()) 
				{
					user.setSQL_UserId(rs.getString("id"));
					user.setSQL_UserName(rs.getString("username"));	
					user.setSQL_Password("xxxxxxx");
				}
			}
			catch(SQLException ex)
			{
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			finally {
			    if (rs != null) {
			        try {
			        		con.close();
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			            con.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }	
			    
			}	
		 return user;
	 } 

	 /**
	  * Get a UserName,Password, UserId of a user in system
	  * 	               
	  */
	 public static SQLUser DS_GetUserObject() {
			Connection con = null;
			ResultSet rs = null;
			Statement stmt = null;
			SQLUser user = new SQLUser();
			String query = "";
			try 
			{
				con = generalFunctions.ConnectDataBase();
				stmt = con.createStatement();
				//System.out.println("Query is: " + query + "\r\n");
				rs = stmt.executeQuery(query);
				rs.beforeFirst();
				while (rs.next()) 
				{
					user.setSQL_UserId(rs.getString("id"));
					user.setSQL_UserName(rs.getString("username"));	
					user.setSQL_Password("xxxxxxx");
				}
			}
			catch(SQLException ex)
			{
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			finally {
			    if (rs != null) {
			        try {
			        		con.close();
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			            con.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }	
			    
			}	
		 return user;
	 } 
	 
}
