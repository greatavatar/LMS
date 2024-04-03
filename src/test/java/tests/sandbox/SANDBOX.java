package tests.sandbox;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SANDBOX {
	@Test
	public void aptTestingGET() throws Exception {
		try {
			URL url = new URL("xxxxxxxsecurity/matching/suggestion?view_suggestion_action=1&from=0&limit=10&access_token=Y2RhNzE2MzgyZmY0MzlkNWFjOTZhYjcxYzVjNWY1NTU0MjAwOTBlZjgxZjA3MzhlNzM1YWIwNDBhMGQ5MDc5MA");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}
			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();
			System.out.println("Response : " + entireResponse);
			scan.close();
			JSONObject obj = new JSONObject(entireResponse);
			JSONObject obj_data = obj.getJSONObject("data");
			JSONArray arr_ListMatching = obj_data.getJSONArray("listMatching");
			System.out.println(arr_ListMatching.length());
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	@Test
	public void aptTestingPOST() throws Exception {
		try {
			URL url = new URL(xxxxx);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");

			 BufferedWriter httpRequestBodyWriter = 
			            new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			    httpRequestBodyWriter.write("xxxxxx");
			    httpRequestBodyWriter.close();
			 
			/*if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}*/
			
			Scanner scan = new Scanner(conn.getInputStream());
			String entireResponse = new String();
			while (scan.hasNextLine())
				entireResponse += scan.nextLine();
			scan.close();
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}