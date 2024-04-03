package functions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import functions.generalFunctions;
import variables.ConstantLib.Constants;

public class F_API {

	/**
	 * Call a API GET
	 */
	public static String API_GET(String pURL) {
		String entireResponse = new String();
		try {
			URL url = new URL(pURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				//throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
				System.out.println("----API return status <> 200 ");
				//return arr_ListMatching = null;
			}
			Scanner scan = new Scanner(url.openStream());
			while (scan.hasNext())
				entireResponse += scan.nextLine();
			scan.close();
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entireResponse;
	}
	
	/**
	 * Call a API POST
	 */
	public static String API_POST(String pURL,String pBody) {
		String entireResponse = new String();
		try {
			URL url = new URL("https://staging-api.lms.com/oauth/v2/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			BufferedWriter httpRequestBodyWriter = 
			            new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			    httpRequestBodyWriter.write(pBody);
			    httpRequestBodyWriter.close();
			Scanner scan = new Scanner(conn.getInputStream());
			while (scan.hasNextLine())
				entireResponse += scan.nextLine();			
			scan.close();
			conn.disconnect();	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return entireResponse;
	}
	
//--------------------------------------------------------------------------------------------


	/**
	 * Call API matching list, return JSON list of Matching Users
	 */
	public static JSONArray GetMatchingListOfAUser(String pAccess_token) {
		JSONArray arr_ListMatching = null;
		String url = "xxxxxxxsecurity/matching/suggestion?view_suggestion_action=1&from=0&limit=10000&access_token=" + pAccess_token;
		String entireResponse = API_GET(url);
		JSONObject obj = new JSONObject(entireResponse);
		JSONObject obj_data = obj.getJSONObject("data");
		arr_ListMatching = obj_data.getJSONArray("listMatching");
		return arr_ListMatching;
	
	}
	
	/**
	 * Call API matching list, return JSON list of Matching Users
	 */
	public static String GetAccessTokenOfAUser(String pUserName, String pPassword) {
		try
		{
		pUserName = URLEncoder.encode(pUserName, "UTF-8");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		String AccessToken = "";
		String url = "https://staging-api.lms.com/oauth/v2/token";
		String body = "client_id=2_58huv8djfo08440sco8w40okokcgco400ws0c0wk0okokw8ck8&client_secret=3iyajo9jd1gk84gscc0gwcg8o4csc0w80oswk8ow0wsskk8gc&grant_type=password&username="+ pUserName +"&password="+ pPassword;
		String entireResponse = API_POST(url, body);
		JSONObject obj = new JSONObject(entireResponse);
		AccessToken = obj.getString("access_token");
		
		if (AccessToken.equals(""))
		{
			System.out.println("++++++++++++++Account " + pUserName + " Error with blank token");
		}
		return AccessToken;
	}

	/**
	 * Call API matching list, return a number of total matching partners
	 */
	public static int GetTotalNumberMatchingNumber(String pAccess_token)
	{
		int totalNumberUser = 0;
		JSONArray arr_ListMatching = null;
		String url = "xxxxxxxsecurity/matching/suggestion?view_suggestion_action=1&from=0&limit=1&access_token=" + pAccess_token;
		String entireResponse = API_GET(url);
		JSONObject obj = new JSONObject(entireResponse);
		try
		{
			JSONObject obj_data = obj.getJSONObject("data");
			totalNumberUser = obj_data.getInt("total");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			totalNumberUser = 0;
		}
		return totalNumberUser;
	}

}