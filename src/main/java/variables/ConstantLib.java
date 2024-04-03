package variables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstantLib {

	public static class Constants {
		public static int TimeOut = 90;
		public static String Init_Folder = "Init";

		public static String Url;
		public static String EmailDomain;
		public static String RemoteEnvironment;
		public static String HeadlessMode;

		public static String Email = "XXXX@discard.email";
		public static String EmailLinks = "XXXX@discard.email";
		public static String EmailFacebook = "XXXX";
		public static String EmailGoogle = "XXXX";
		public static String Password = "XXXXX";
		public static String PasswordFacebook = "XXXXX";
		public static String PasswordGoogle = "XXX?z";
		
		public static WebDriver Driver;
		public static WebDriverWait Wait;
		public static String OriginalHandle;
			
		public static String SSHHost;
		public static String SSHUser;
		public static String SSHPort;
		
		public static String DataBaseDriverName;
		public static String DataBase2Url;
		public static String DatabaseUsr;
		public static String DatabasePwd;
		
		public static String ESIp;
		public static String ESPort;
		public static String ESProtocal;
	}
	
	public static class UserInit{
		
		//----------INIT ACCOUNT FOR TESTCASES-------------------
		
		public static String AccountReceiveMessage = "auto_receivemessage";
		public static String AccountSendMessage = "auto_sendmessage";
		public static String UserCodeSendMessage = "XX";
		public static String UserCodeReceiveMessage = "XXX";
		
		public static String AccountReceiveInterest = "interest_receive_user";
		public static String AccountVisitInterest = "interest_visit_user";
		public static String UserCodeReceiveInterest = "XX";
		public static String UserCodeVisitInterest  = "XXX";
		public static String NameAccountVisitInterest  = "account a";
		public static String NameAccountReceiveInterest  = "account b";
		
		public static String AccountPayment = "auto_buypayment";
		public static String UserCodeAccountPayment = "XX";
		
		public static String Worker_AccountZeroPrice = "XX";
		public static String Worker_UserIDAccountZeroPrice = "XX";
		
		public static String Worker_AccountPricePromotion = "XXX";
		public static String Worker_UserIDAccountPricePromotion = "XXX";
		
		public static String AccountHelloFemale = "XXX";
		public static String UserCodeHelloFemale = "XXX";
		
		/*
		 *  Female, No Avatar, Basic, Has first message from user "auto_sendmessage" and also reply first message
		 */
		public static String AccountFemaleNoAvatar = "XXX";
		public static String UserCodeFemaleNoAvatar = "XX";
		

		public static String AccountHelloMale = "XXX";
		public static String UserCodeHelloMale = "XXX";
		
		public static String AccountMaleNoAvatar = "XXX";
		public static String UserCodeMaleNoAvatar = "XX";
		
		public static String AccountPotentialP0 = "XX";
		public static String UserCodePotentialP0 = "XX";
	}
	
	public static class PaymentInit{
		
		//----------INIT PAYMENT INFORMATION FOR TESTCASES-------------------
		
		public static String BasicBundle = "BASIC";
		public static String SmartBundle = "SMART";
		public static String ComfortBundle = "COMFORT";
		public static String MontlyFrequency = "Monthly";
		public static String QuarterlyFrequency = "Quarterly";
		public static String SemiAnnualFrequency = "Semiannual";
		public static String OnetimeFrequency = "Onetime";
		public static String CardNumber = "XXXX";
		public static String IBAN = "XXX";
		public static String BIC = "XXX";
	
	}
	
	public class TestGroup {
		public static final String Initialization = "Initialization";

		public class AppFunction {
			public static final String Account = "Account";
			public static final String Message = "Message";
		}

		public class Priority {
			public static final String Critical = "Critical";
			public static final String High = "High";
			public static final String Medium = "Medium";
			public static final String Low = "Low";
		}

		public class Owner {
			public static final String xxxxxxxNguyen = "xxxxxxx Nguyen";
		}

		public class TestSuite {
			public static final String SmokeTest = "Smoke Test";
			public static final String Regression = "Regression";
			public static final String Test = "Test";
		}
		
		public class RemoteInformation {
			//Information for connecting BROWSERSTACK
			public static final String USERNAME = "XXX";
			public static final String AUTOMATE_KEY = "XXX";
			public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		}	
		
		public class RemoteSourceInformation {
			//Information for connecting SOURCELAB
			
			public static final String USERNAME = "XX";
			public static final String ACCESS_KEY = "XXX";
			public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		}	
		
	}
}
