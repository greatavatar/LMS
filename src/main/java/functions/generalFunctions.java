package functions;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import variables.ConstantLib;
import variables.TCResult;
import variables.ConstantLib.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amazonaws.services.elasticbeanstalk.model.SystemStatus;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.client.config.RequestConfig;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;


public class generalFunctions {

	/**
	 * Random a 5-character string
	 * 
	 * @param pPrefix
	 *            Prefix of the string
	 * @param mSuffix
	 *            Suffix of the string
	 * @return
	 */
	public static String randomString(String pPrefix, String mSuffix, int mlength) {

		String mSet1 = randomAlphabetic(mlength).toLowerCase();
		return pPrefix + mSet1 + mSuffix;
	}

	/**
	 * Randomize a number and return as a string
	 * 
	 * @param plength
	 *            Length of string
	 * @return Return a number as a String
	 */
	public static String randomNumber(int plength) {
		Random mRan = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < plength; i++) {
			int num = mRan.nextInt(10);
			sb.append(num);
		}

		return sb.toString();
	}


	/**
	 * Wait for specified time in seconds
	 */
	public static void waitForSeconds(double pSecond) {
		try {
			Thread.sleep((long) (pSecond * 1000));
		} catch (Exception e) {
		}
	}

	/**
	 * Click on a control on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void click(By pBy) {
		
		waitForControlVisible(pBy);
		WebElement mElement = Constants.Driver.findElement(pBy);
		mElement.click();
	}
	

	/**
	 * Click on a control on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void clickbyJavascript(By pBy) {
		
		WebElement element = Constants.Driver.findElement(pBy);
		//((JavascriptExecutor) ConstantLib.Constants.Driver).executeScript("arguments[0].click();",element);
		
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		  
		// Execute the Java Script for the element which we find out
		((JavascriptExecutor) ConstantLib.Constants.Driver).executeScript(js, element);
		 
		// Click on element
		 
		element.click();
		
	}
	
	/**
	 * Set true on a radio button on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void SetRadioButtonByJavascript(By pBy) {
		
		WebElement element = Constants.Driver.findElement(pBy);
		((JavascriptExecutor) Constants.Driver).executeScript("arguments[0].checked = true;", element);
		((JavascriptExecutor) Constants.Driver).executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Select Drop down by hovering
	 */
	public static void selectDropdownByHover(By pDropdown, By pValue) {

		Actions action = new Actions(Constants.Driver);
		WebElement mDropdown = Constants.Driver.findElement(pDropdown);
		action.moveToElement(mDropdown).build().perform();
		generalFunctions.waitForSeconds(3);
		generalFunctions.clickbyJavascript(pValue);
	}

	/**
	 * Attempts to click on an element multiple times (to avoid stale element
	 * exceptions caused by rapid DOM refreshes)
	 *
	 * @param by
	 *            By element locator
	 */
	public static void waitAndClick(By pBy) {
		final int MAX_STALE_ELEMENT_RETRIES = 2;
		int retries = 0;
		while (retries < 2) {
			try {
				Constants.Wait.until(ExpectedConditions.elementToBeClickable(pBy)).click();
				return;
			} catch (Exception e) {
				if (retries < MAX_STALE_ELEMENT_RETRIES) {
					retries++;
					generalFunctions.waitForSeconds(2);
					continue;
				} else {
					System.out.println("Click - " + pBy + " Retry: " + retries);
				}
			}
		}
	}

	/**
	 * Enter value to element on web application
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Value to enter
	 */
	public static void sendKeys(By pBy, String pValue) {
		WebElement mElement = Constants.Driver.findElement(pBy);
		try {
			Constants.Wait.until(ExpectedConditions.visibilityOf(mElement));
		} catch (Exception e) {
		}
		mElement.clear();		
		mElement.sendKeys(pValue);
	}

	/**
	 * Capture a element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @return Return a WebElement object
	 */
	public static WebElement captureInterface(By pBy) {
		try {
			return Constants.Driver.findElement(pBy);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Wait for a element visible
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void waitForElementVisible(By pBy) {
		try {
			Constants.Wait.until(ExpectedConditions.visibilityOfElementLocated(pBy));
		} catch (Exception e) {

		}
	}
	
	/**
	 * Wait for a element visible
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void waitForElementVisible(WebElement pElement) {
		try {
			Constants.Wait.until(ExpectedConditions.visibilityOf(pElement));
		} catch (Exception e) {

		}
	}

	/**
	 * Wait for a element invisible
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void waitForElementNotVisible(By pBy) {
		try {
			WebDriverWait Wait = new WebDriverWait(Constants.Driver, 10);
			Wait.until(ExpectedConditions.invisibilityOfElementLocated(pBy));
		} catch (Exception e) {
			System.out.println(pBy + " Not InVisible");
		}
	}

	/**
	 * Wait for a value is populated in an element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Expected value to wait for
	 */
	public static void waitForElementValue(By pBy, String pValue) {
		try {
			Constants.Wait.until(ExpectedConditions.attributeToBe(pBy, "value", pValue));
		} catch (Exception e) {
		}
	}

	/**
	 * Wait for a value is selected in an element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Expected value to wait for
	 */
	public static void waitForElementValueSelected(By pBy, String pValue) {
		String mId;
		mId = generalFunctions.getElementID(pBy);
		By mBy = By.xpath("//*[@id = '" + mId + "']/following-sibling::*[1]/ul/li[@class='active']");
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 10000) {
			try {
				Constants.Wait.until(ExpectedConditions.attributeToBe(mBy, "innerText", pValue));
			} catch (Exception e) {
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
				}
			}
		}

	}

	/**
	 * Get id of element
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @return Return id of element
	 */
	public static String getElementID(By pBy) {
		WebElement mElement;
		String mId;
		try {
			mId = generalFunctions.captureInterface(pBy).getAttribute("id");
		} catch (StaleElementReferenceException e) {
			mElement = generalFunctions.captureInterface(pBy);
			mId = mElement.getAttribute("id");
		}
		return mId;
	}
	

	/**
	 * Get text of an element
	 * 
	 * @param pBy
	 *            Element need to get text value
	 * @return Return text value of element
	 */
	public static String getTextOfElement(By pBy) {	
		WebElement mElement = generalFunctions.captureInterface(pBy);
		return mElement.getText();
	}

	/**
	 * Wait for element enabled
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void waitForElementEnabled(By pBy) {
		try {
			Constants.Wait.until(ExpectedConditions.elementToBeClickable(pBy));
		} catch (Exception e) {
		}
	}

	/**
	 * Wait for element disabled
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 */
	public static void waitForElementDisabled(By pBy) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < Constants.TimeOut * 1000) {
			WebElement mElement = generalFunctions.captureInterface(pBy);
			try {
				if (!mElement.getAttribute("disabled").contains("true")) {
					generalFunctions.waitForSeconds(2);
				} else {
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * Select a value of a Dropdownlist
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pValue
	 *            Expected value to select
	 */
	public static void selectDropDownList(By pBy, String pValue) {
		
		Select sel = new Select(Constants.Driver.findElement(pBy));
         //sel.selectByValue(pValue); 
         sel.selectByVisibleText(pValue);
		}
	
	/**
	 * Select a random value of a Dropdownlist
	 * 
	 * @param pBy
	 *            A mechanism by which to find elements within a document
	 * @param pIndex
	 *            Expected value to select
	 */
	public static void selectRandomInDropDownList(By pBy, int pIndexStart) {
		
		Select sel = new Select(Constants.Driver.findElement(pBy));
		int lengthSelect = sel.getOptions().size();
		int randomIndex = generalFunctions.getRandomInt(pIndexStart, lengthSelect-1);
        sel.selectByIndex(randomIndex);
		}
	
	/**
	 * Close all tabs except the first tab
	 * 
	 * @param pOriginalHandle
	 *            
	 */
	public static void CloseAllOtherTabs(String pOriginalHandle) {
		
		for(String handle : Constants.Driver.getWindowHandles()) {
	        if (!handle.equals(pOriginalHandle)) {
	        	Constants.Driver.switchTo().window(handle);
	        Constants.Driver.close();
	        }
	    }

	    Constants.Driver.switchTo().window(pOriginalHandle);
	}
	
	/**
	 * Switch to Second Opened Window
	 *            
	 */
	public static void SwitchToNewTab(String pOriginalHandle) {
		
		//Workaround for firefox browserstack
		generalFunctions.waitForSeconds(3);
				
		for(String handle : Constants.Driver.getWindowHandles()) {
	        if (!handle.equals(pOriginalHandle)) {
	        	Constants.Driver.switchTo().window(handle);
	        }
	    }
	}
	
	/**
	 * Wait for control Visible
	 *            
	 */
	public static void waitForControlVisible(By pBy) {
		
		//Work around for BrowserStack FireFox
		//generalFunctions.waitForSeconds(0.5);
		Constants.Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
		WebElement mElement = Constants.Driver.findElement(pBy);
		Constants.Wait.until(ExpectedConditions.elementToBeClickable(mElement));
		Constants.Wait.until(ExpectedConditions.visibilityOfElementLocated(pBy));
		
		} catch (Exception e) {
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		
	}
	
	
	/**
	 * Wait for control Visible
	 *            
	 */
	public static void waitForControlVisible(WebElement pElement)  {
		
		//Work around for BrowserStack FireFox
		Constants.Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Constants.Wait.until(ExpectedConditions.elementToBeClickable(pElement));
			Constants.Wait.until(ExpectedConditions.visibilityOf(pElement));
			} 
		catch (Exception e) {
		}
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * Connect to DATABASE through SSH key
	 *            
	 */
	public static Connection ConnectDataBase() throws SQLException {
        
		//String privateKey = "~/.ssh/lms_dev.pem";
		String privateKey = Constants.Init_Folder + "/lms_dev.pem";
        //String passphrase = "passph123";

		Connection connection = null;
        Session session= null;
        
        String host = Constants.SSHHost;
        String servUser = Constants.SSHUser;
        int port = Integer.parseInt(Constants.SSHPort);
        String driverName = Constants.DataBaseDriverName;
        String db2Url = Constants.DataBase2Url;
        String dbUsr = Constants.DatabaseUsr;
        String dbPwd = Constants.DatabasePwd;
               	
        try {
            
        		if(!host.equals("54.93.55.38"))
        		{
        				/*JSch jsch = new JSch();
                    // Get SSH session
                    session = jsch.getSession(servUser, host, port);
                    session.setPassword(servPwd);*/
                    
                    JSch jsch = new JSch();
                    // Set the ssh file and the passphrase
                    jsch.addIdentity(privateKey);
                    // Get SSH session
                    session = jsch.getSession(servUser, host, port);
                    
                    java.util.Properties config = new java.util.Properties();
                    // Never automatically add new host keys to the host file
                    config.put("StrictHostKeyChecking", "no");
                    session.setConfig(config);
                    // Connect to remote server
                    session.connect();
                    //System.out.println ("Session is " + session.isConnected());
                    // Apply the port forwarding
                    //session.setPortForwardingL(lport, rhost, rport); 
                
        		}
            // Connect to remote database
            Class.forName(driverName);
            connection = DriverManager.getConnection(db2Url, dbUsr, dbPwd);
            //System.out.println ("Connection to database established!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
//            if(connection != null && !connection.isClosed()){
//                connection.close();
//            }
            if(session !=null && session.isConnected()){
                session.disconnect();
            }
        }
        return connection;
    }
	
	
	/**
	 * Use RestAPI to update status from Selenium to Browserstack.
	 *            
	 */
	public static void MarkStatusForBrowserStack(TCResult pResult, String pMethodName) throws URISyntaxException, UnsupportedEncodingException, IOException {
		String session = ((RemoteWebDriver) Constants.Driver).getSessionId().toString();
		URI uri = new URI("https://lms1:hXmFjdySq6TgvqgQzzzy@api.browserstack.com/automate/sessions/"+session+".json");
		HttpPut putRequest = new HttpPut(uri);
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		if(pResult.Result==false)
		{
			nameValuePairs.add((new BasicNameValuePair("status", "failed")));
			nameValuePairs.add((new BasicNameValuePair("reason", pResult.Message)));
			nameValuePairs.add((new BasicNameValuePair("name", pMethodName )));
			
		}
		else
		{
			nameValuePairs.add((new BasicNameValuePair("status", "passed")));
			nameValuePairs.add((new BasicNameValuePair("reason", "")));
			nameValuePairs.add((new BasicNameValuePair("name", pMethodName)));
		}
		
		putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		//HttpClientBuilder.create().build().execute(putRequest);
		}
		
	/**
	 * Wait for Loading control disappear
	 *            
	 */
	public static void waitForLoadingIconDisappear() {
		//generalFunctions.waitForElementNotVisible(By.xpath("//div[contains(@class,'spinner')]"));
		Constants.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		generalFunctions.waitForSeconds(1);
		generalFunctions.waitForElementNotVisible(By.xpath("//*[contains(@class,'spinner')]"));
		//generalFunctions.waitForElementNotVisible(By.xpath("//i[contains(@class,'spinner')]"));
		Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);	
	}
	
	/**
	 * Check is a Control exist. Return true false value
	 */
	public static boolean CheckIsControlAppear(By pBy) {
		Constants.Driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		if(Constants.Driver.findElements(pBy).size() > 0 ) 
		{
			Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);	
			return true;
		}
		else 
		{
			Constants.Driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);	
			return false;		
		}
	
	}
	
	/**
	 * Connect to SSH Staging through SSH key
	 *            
	 */
	public static Session ConnectSSH() {
        
		//String privateKey = "~/.ssh/lms_dev.pem";
		String privateKey = Constants.Init_Folder + "/lms_dev.pem";
        //String passphrase = "passph123";
		
        Session session= null;
        
        String host = "52.221.53.2";
        String servUser = "ubuntu";
        int port = 22;
             
        try {
            
            JSch jsch = new JSch();
            // Set the ssh file and the passphrase
            jsch.addIdentity(privateKey);
            // Get SSH session
            session = jsch.getSession(servUser, host, port);
            
            java.util.Properties config = new java.util.Properties();
            // Never automatically add new host keys to the host file
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            // Connect to remote server
            session.connect();
            //System.out.println ("Session is " + session.isConnected());
            
         
            /*String command = "xxxxxxxxxxxxxxxxxxxxxxxxxcurrent/bin/console lms:matching:query 49490 --matcher=perfect_match --limit=5 --cache=false";
            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
             
            InputStream input = channel.getInputStream();
            channel.connect();
             
            System.out.println("Channel Connected to machine " + host + " server with command: " + command ); 
             
            try{
                InputStreamReader inputReader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line = null;
                 
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
                bufferedReader.close();
                inputReader.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
             
            channel.disconnect();
            session.disconnect();*/
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return session;
    
    }
	
	/**
	 * Get a random number from  MIN value - Max value
	 */
	public static int getRandomInt(int min, int max) {
	    Random random = new Random();

	    return random.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * Return an array which contains random and NonRepeating numbers in range MIN value - Max value 
	 */
	public static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,
	        int max) {
	    ArrayList<Integer> numbers = new ArrayList<Integer>();

	    while (numbers.size() < size) {
	        int random = getRandomInt(min, max);

	        if (!numbers.contains(random)) {
	            numbers.add(random);
	        }
	    }

	    return numbers;
	}
	
	/**
	 * Check is a Cookie name exist or not
	 */
	public static boolean isCookiePresent(String cookieName)
	{
	    return Constants.Driver.manage().getCookieNamed(cookieName) != null;
	}
	
	
	/**
	 * Connect to ELASTIC SEARCH
	 */
	public static RestClient ConnectElasticSearch()
	{
		RestClient client = null;
		try {
				String Ip = Constants.ESIp;
				int Port = Integer.parseInt(Constants.ESPort);
				String Protocal = Constants.ESProtocal;
				
				/*String Ip = "52.221.53.2";
				int Port = 9200;
				String Protocal = "http";*/
				
				
				
				client = RestClient.builder(new HttpHost(Ip, Port, Protocal), new HttpHost(Ip, Port, Protocal))
			//client = RestClient.builder(new HttpHost("52.221.53.2", 9200, "http"), new HttpHost("52.221.53.2", 9200, "http"))
				.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
					@Override
 	               	public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
 	                    return requestConfigBuilder.setConnectTimeout(5000).setSocketTimeout(30000);
 	                }
				}).setMaxRetryTimeoutMillis(30000)
 	            .build();
		
		}
		catch(Exception e)
		{
    			System.out.println(e.toString());
    			System.out.println("Can't connect to Elastic Search. Something is error");
		}	
		return client;
	}
	
	/**
	 * Run a SELECT query in Elastic Search
	 * 
	 * @param pQuery
	 *            Query example format: String query = "{\"query\":{\"match\":{\"user_id\":\"" + 2838 + "\"}}}"
	 */
	public static JSONArray ES_RunSelectQuery(String pQuery)
	{
		JSONArray arrHitsLevel2 = null;
	  	RestClient client = ConnectElasticSearch();
	  	try
     	{
	  		//String pQuery = "{\"query\":{\"match\":{\"user_id\":\"" + 2838 + "\"}}}";
	  		Response response = client.performRequest(
	  				"GET",
	  				"lms/profile/_search",
	  				new Hashtable<>(),
	  				new StringEntity(pQuery));
    	 
	  		HttpEntity entity = response.getEntity();
	  		String json = EntityUtils.toString(entity);
	  		JSONObject obj = new JSONObject(json);
			JSONObject objectHitsLevel1 = obj.getJSONObject("hits");
			arrHitsLevel2 = objectHitsLevel1.getJSONArray("hits");
	  		client.close();
     	}
	  	catch(Exception e)
		{
    			System.out.println(e.toString());
    			System.out.println("Can't run Select Query in Elastic Search. Something is error");
		}	
	  	return arrHitsLevel2;
	}
	
	/**
	 * Get is RESULT SET record size number
	 * 
	 */
	public static int GetResultSetSize(ResultSet pResult) 
	{
		
		int size = 0;
		try
		{
			if (pResult != null)   
			{  
				pResult.beforeFirst();  
				pResult.last();  
				size = pResult.getRow();
				pResult.beforeFirst();
			}
			else
			{
				System.out.println("ResultSet has record size = 0");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		return size;
	}
}