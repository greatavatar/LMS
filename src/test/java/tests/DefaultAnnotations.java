package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import functions.generalFunctions;
//import io.qameta.allure.Attachment;
import variables.TCResult;
import variables.ConstantLib.TestGroup;
import variables.ConstantLib;
import variables.ConstantLib.Constants;
import org.w3c.dom.Element;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import org.openqa.selenium.Dimension;

/*import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import bsh.Console;*/

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DefaultAnnotations {

	public TCResult Result;

	@BeforeMethod(groups = { TestGroup.Initialization })
	public void beforeMethod() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();	
		switch(Constants.RemoteEnvironment)
		{
			case "saucelab_chrome":
				DesiredCapabilities dc1 = DesiredCapabilities.chrome();
				dc1.setCapability("platform", "Windows 10");
				dc1.setCapability("version", "56.0");
				dc1.setCapability("screenResolution", "1280x800");
				dc1.setCapability("name", "Web Driver demo Test");
				dc1.setCapability("tags", "Tag1");
					
			    Constants.Driver  = new RemoteWebDriver(new URL(ConstantLib.TestGroup.RemoteSourceInformation.URL), dc1);
				
				//Constants.Driver.manage().window().fullscreen();
				Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);
	
			    break;
		    
			case "browserstack_chrome":
				
				dc.setCapability("browser", "Chrome");
				dc.setCapability("browser_version", "63.0");
				dc.setCapability("os", "Windows");
				dc.setCapability("os_version", "10");
				dc.setCapability("resolution", "1280x800");
				dc.setCapability("browserstack.debug", "true");
				dc.setCapability("browserstack.networkLogs", "true");
				dc.setCapability("browserstack.selenium_version", "3.5.2");
				dc.setCapability("browserstack.debug", "true");
			
			    Constants.Driver  = new RemoteWebDriver(new URL(ConstantLib.TestGroup.RemoteInformation.URL), dc);
				
				Constants.Driver.manage().window().fullscreen();
				Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);

			    break;
				
			case "browserstack_firefox":
				dc.setCapability("os", "Windows");
				dc.setCapability("os_version", "10");
				dc.setCapability("browser", "Firefox");
				dc.setCapability("browser_version", "57.0");
				dc.setCapability("resolution", "1280x800");
				dc.setCapability("browserstack.networkLogs", "true");
				dc.setCapability("browserstack.selenium_version", "3.5.2");
				dc.setCapability("browserstack.debug", "true");
			    Constants.Driver  = new RemoteWebDriver(new URL(ConstantLib.TestGroup.RemoteInformation.URL), dc);
				//Can't not run fullscreen in browserstack firefox, have no idea, investigating
				//Constants.Driver.manage().window().fullscreen();
				Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);
			    
			    break;	
				
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Constants.Init_Folder + "/chromedriver.exe");
				dc.setCapability("requireWindowFocus", true);
				dc.setJavascriptEnabled(true);
				ChromeOptions Chrome_options = new ChromeOptions();
				if (Constants.HeadlessMode.equals("yes")){			
					Chrome_options.addArguments("headless");
					//Chrome_options.addArguments("enable-automation");
					//Chrome_options.addArguments("--disable-infobars");
					//Chrome_options.addArguments("--disable-extensions");
				}
				Chrome_options.merge(dc);   
				Constants.Driver = new ChromeDriver(Chrome_options);
				//Have to set Size after new Driver, can't set with IF command above
				if (Constants.HeadlessMode.equals("yes")){
					// Can't set FULLSCREEN in Headless mode, need to set specific size for running some function like SetDegree
					Constants.Driver.manage().window().setSize(new Dimension(1920,1080)); 
					//Dimension d = Constants.Driver.manage().window().getSize(); 
					//System.out.println("\r\n window dimension: "+ d);	
				}
				else Constants.Driver.manage().window().fullscreen();
				
				Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
			
				Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);
				break;
			
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Constants.Init_Folder + "/geckodriver");
				dc.setCapability("requireWindowFocus", true);
				dc.setJavascriptEnabled(true);
				
				dc.setCapability("marionette", true);
				//set Marionette log file = null to not display
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
				
				FirefoxOptions Firefox_options = new FirefoxOptions();
				if (Constants.HeadlessMode.equals("yes")){
					//Firefox_options.addArguments("headless");
					//Firefox_options.addArguments("--headless");
					Firefox_options.setHeadless(true);

				}		
				Firefox_options.merge(dc);   
				Constants.Driver = new FirefoxDriver(Firefox_options);
				
				Constants.Driver.manage().window().fullscreen();
				Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);
				break;	
				
			default:
				System.setProperty("webdriver.chrome.driver", Constants.Init_Folder + "/chromedriver");
				dc.setCapability("requireWindowFocus", true);
				dc.setJavascriptEnabled(true);
				ChromeOptions Chromeoptions = new ChromeOptions();
				Chromeoptions.merge(dc);   
				Constants.Driver = new ChromeDriver(Chromeoptions);
				
				Constants.Driver.manage().window().fullscreen();
				Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
				Constants.Wait = new WebDriverWait(Constants.Driver, Constants.TimeOut);
				break;
		}
		
		//DOES NOT WORK ON MAC OS
		//Constants.Driver.manage().window().maximize(); 
		Constants.OriginalHandle = Constants.Driver.getWindowHandle();
		Result = new TCResult();
		
		
		
	}

	@AfterMethod(groups = { TestGroup.Initialization })
	public void afterMethod(ITestResult IResult) {	
		try
		{
			if(Constants.RemoteEnvironment.contains("saucelab"))
			{
				((JavascriptExecutor) Constants.Driver).executeScript("sauce:job-result=" + (Result.Result ? "passed" : "failed"));
				((JavascriptExecutor) Constants.Driver).executeScript("sauce:context=" + Result.Message);
			}
			
			if(Constants.RemoteEnvironment.contains("browserstack"))
			{
				
				generalFunctions.MarkStatusForBrowserStack(Result, IResult.getMethod().getMethodName());
			}
			
			System.out.println ("\r\n Testcase was run is " + IResult.getMethod().getMethodName());
			
		}
		catch(Exception e)
		{
			System.out.println("AFTER METHOD: Exception occurred");
			System.out.println(e.getMessage());
		}
		
		finally{
			//Constants.Driver.close();
			Constants.Driver.quit();
		}
		
		/*//To avoid error Tried to run command without establishing a connection in FIREFOX
		if(Constants.RemoteEnvironment == "firefox" || Constants.RemoteEnvironment == "browserstack_firefox")
		{
			Constants.Driver.close();
		}
		else
		{
			Constants.Driver.close();
			Constants.Driver.quit();
		}*/
	
	}

	@BeforeSuite(groups = { TestGroup.Initialization })
	public void beforeTest() {
		try {
			File inputFile = new File(Constants.Init_Folder + "/Init.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			NodeList nList = doc.getElementsByTagName("lms");
			Constants.Url = ((Element) nList.item(0)).getElementsByTagName("URL").item(0).getTextContent();
			Constants.EmailDomain = ((Element) nList.item(0)).getElementsByTagName("EmailDomain").item(0).getTextContent();
			Constants.RemoteEnvironment = ((Element) nList.item(0)).getElementsByTagName("RemoteEnvironment").item(0).getTextContent();
			Constants.HeadlessMode = ((Element) nList.item(0)).getElementsByTagName("HeadlessMode").item(0).getTextContent();
			//--Get SSH Parameters
			Constants.SSHHost = ((Element) nList.item(0)).getElementsByTagName("SSHHost").item(0).getTextContent();
			Constants.SSHUser = ((Element) nList.item(0)).getElementsByTagName("SSHUser").item(0).getTextContent();
			Constants.SSHPort = ((Element) nList.item(0)).getElementsByTagName("SSHPort").item(0).getTextContent();
			//--Get SQL Parameters
			Constants.DataBaseDriverName = ((Element) nList.item(0)).getElementsByTagName("DataBaseDriverName").item(0).getTextContent();
			Constants.DataBase2Url = ((Element) nList.item(0)).getElementsByTagName("DataBase2Url").item(0).getTextContent();
			Constants.DatabaseUsr = ((Element) nList.item(0)).getElementsByTagName("DatabaseUsr").item(0).getTextContent();
			Constants.DatabasePwd = ((Element) nList.item(0)).getElementsByTagName("DatabasePwd").item(0).getTextContent();
			//--Get ES Parameters
			Constants.ESIp = ((Element) nList.item(0)).getElementsByTagName("ESIp").item(0).getTextContent();
			Constants.ESPort = ((Element) nList.item(0)).getElementsByTagName("ESPort").item(0).getTextContent();
			Constants.ESProtocal = ((Element) nList.item(0)).getElementsByTagName("ESProtocal").item(0).getTextContent();
			
			// Catching value of parameter running by command in JENKIN
			if(System.getProperty("browser") != null)
			{
				Constants.RemoteEnvironment = System.getProperty("browser");
			}
			
			if(System.getProperty("headless") != null)
			{
				Constants.HeadlessMode = System.getProperty("headless");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite(groups = { TestGroup.Initialization })
	public void afterTest() {

	}
	
}