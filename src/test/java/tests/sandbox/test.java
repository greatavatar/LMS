package tests.sandbox;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;
import org.testng.Assert;
import org.testng.annotations.Test;
import functions.*;
import interfaces.I_HomePage;
import variables.ConstantLib;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AWSVerification;
import verificationFunctions.generalVerification;

//import io.qameta.allure.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import variables.CommandLine;

public class test extends tests.DefaultAnnotations
{
	
	
	@Test(groups = { Priority.Critical, TestSuite.Test, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	//@Severity(SeverityLevel.CRITICAL)
    //@Description("Test Description: Login test with empty username and empty password.")
    //@Story("Empty username and password login test")

	public void TC00xx1_Test() 
	{
	//F_Navigation.goTolmsURL();
		
		//Normally login
		/*F_Account.LoginUser(ConstantLib.Constants.Email,ConstantLib.Constants.Password);
		generalVerification.verifyElementVisible(I_HomePage.lik_MyProfile, "My Profile icon", Result);
		F_Account.LogOutUser();*/
	Constants.EmailDomain = "@cmail.club";

	
	/*
	// UserID of user need to check perfect mail 
	String AccountUserID = "150";
	String AccountReceiveMail = "testtest";
	//Find user name new perfect match for xxxxxxx_male_6345/49490 
	//String UserPerfectMatchID = F_AWS.GetPerfectMatchUserID("49490");
	//String UserPerfectMatctMail = F_Account.DS_GetUserNameByUserID(UserPerfectMatchID).split("@")[0];
	//System.out.println("\r\n Mail PerfectMatch Partner: " + UserPerfectMatctMail);
	
	//Delete all messages in mail and web before receive message
	F_Account.DeleteAllSpamMail(AccountReceiveMail, Constants.EmailDomain);
	
	F_AWS.SendWorker_Email_New_Matching(AccountUserID);
	F_AWSVerification.Verify_Receive_Mail_From_AWS_Email_New_Matching(AccountReceiveMail, Constants.EmailDomain, Result);
	Assert.assertTrue(Result.Result, Result.Message);	*/
		
	
	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Test, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	//@Severity(SeverityLevel.CRITICAL)
    //@Description("Test Description: Login test with empty username and empty password.")
    //@Story("Empty username and password login test")

	public void TC00xx_Test() 
	{
		
		/*Runtime rt = Runtime.getRuntime();
		CommandLine rte = new CommandLine();
	    	printOutput errorReported, outputMessage;
 
		try {
			Process proc = rt.exec("ls /Users/<username>/Desktop");
			// Process proc = rt.exec("mkdir /Users/<username>/Desktop/test1");
			// Process proc = rt.exec("ping https://crunchify.com");
			errorReported = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
			outputMessage = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
			errorReported.start();
			outputMessage.start();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//F_AWS.GetPerfectMatchUserID("49490");
		
		//CommandLine obj = new CommandLine();

		//String domainName = "google.com";
		
		
		//in mac oxs
		/*String command = "ping -c 3 " + domainName;
		String output = obj.executeCommand(command);*/
		
		//String command1 = "cd Documents/Automation/uat/lms/";
	
		//String output = obj.executeCommand(command1);
		
		//command1 = "cd Documents/Automation/uat/lms/ && allure serve allure-results/";
		
		//output = obj.executeCommand(command1);
		
		
		//String command = "xxxxxxxxxxxxxxxxxxxxxxxxxcurrent/bin/console lms:matching:query 49490 --matcher=perfect_match --limit=5 --cache=false";
		//String command = "ls -la";
		//String output = obj.executeCommand(command);

		//System.out.println(output);
		
		
		Assert.assertTrue(Result.Result, Result.Message);
	}
	



	
	
}



//mvn clean test -DsuiteXmlFile=testSuite.xml -Dbrowser="firefox" -Dheadless="no"
//allure serve allure-results/