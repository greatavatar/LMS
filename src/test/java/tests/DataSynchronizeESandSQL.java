package tests;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import org.testng.annotations.Test;

import functions.generalFunctions;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AccountVerification;


public class DataSynchronizeESandSQL extends tests.DefaultAnnotations
{
	
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })

	public void TC001_Verify_Data_For_All_Users_Between_ES_And_MySQL() 
	{
		F_AccountVerification.ES_DS_Verify_Data_Synchronize_Between_ES_MYSQL_For_All_Users(Result);
		Assert.assertTrue(Result.Result, Result.Message);
	
	}
	

	
}
