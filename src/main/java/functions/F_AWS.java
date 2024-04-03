package functions;


///import org.json.simple.JSONObject;

import functions.generalFunctions;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.services.sqs.AmazonSQS;

import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;
import com.amazonaws.AmazonClientException;

import com.amazonaws.regions.Regions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class F_AWS {

	/**
	 * Connect to lms AWS
	 */
	public static AmazonSQS ConnectSQS() {
		
		BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJQFFO2HNRKS7UGBA", "smnXg1+puzYJxVpGMAR+b9djDEnJ7cW/oHla8DbC");
   
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.AP_SOUTH_1).build();

		return sqs;
		
	}
	
	/**
	 * Send message to worker staging-email-premium-zero-promotion
	 * @param pUserID
	 *            User ID of user who will receive mail
	 * @param pMailType
	 *            Type of mail to send : DAY_1, DAY_4, DAY_28, STUDENT_DAY_1, STUDENT_DAY_28, NEXT_SUNDAY_AFTER_DAY_4, NEXT_NEXT_SUNDAY_AFTER_DAY_4
	 */
	public static void  SendWorker_Premium_Zero_Promotion(String pUserID, String pMailType) {
		
		AmazonSQS sqs = ConnectSQS();
	    try {
	    		// Send a message.
	    		System.out.println("Sending a message to staging-email-premium-zero-promotion " + pMailType + "\n");
	        sqs.sendMessage(new SendMessageRequest("https://sqs.ap-southeast-1.amazonaws.com/495045559872/staging-email-premium-zero-promotion","{\"userId\":"+ pUserID +",\"emailType\":\""+ pMailType +"\",\"source\":\"staging_email_premium_zero_promotion\",\"sentAt\":\"2018-05-10\"}"));            	            
	    		} catch (final AmazonServiceException ase) {
	    			System.out.println("\r\n Caught an AmazonServiceException, which means " +
	                    "your request made it to Amazon SQS, but was " +
	                    "rejected with an error response for some reason.");
	            System.out.println("\r\n Error Message:    " + ase.getMessage());
	            System.out.println("\r\n HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("\r\n AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("\r\n Error Type:       " + ase.getErrorType());
	            System.out.println("\r\n Request ID:       " + ase.getRequestId());
	        } catch (final AmazonClientException ace) {
	            System.out.println("\r\n Caught an AmazonClientException, which means " +
	                    "the client encountered a serious internal problem while " +
	                    "trying to communicate with Amazon SQS, such as not " +
	                    "being able to access the network.");
	            System.out.println("\r\n Error Message: " + ace.getMessage());
	        }
	    }
		
	/**
	 * Send message to worker staging-email-price-promotion
	 * @param pUserID
	 *            User ID of user who will receive mail
	 * @param pMailType
	 *            Type of mail to send : DAY_0, DAY_6, DAY_7, DAY_13

	 */
	public static void  SendWorker_Email_Price_Promotion(String pUserID, String pMailType) {
		
		AmazonSQS sqs = ConnectSQS();
	    try {
	    		// Send a message.
	    		System.out.println("Sending a message to email-price-promotion " +  pMailType + "\n");
	        sqs.sendMessage(new SendMessageRequest("https://sqs.ap-southeast-1.amazonaws.com/495045559872/staging-email-price-promotion","{\"userId\":"+ pUserID +",\"emailType\":\""+ pMailType +"\",\"source\":\"staging_email_price_promotion\",\"sentAt\":\"2018-05-10\"}"));
   	            
	    		} catch (final AmazonServiceException ase) {
	    			System.out.println("\r\n Caught an AmazonServiceException, which means " +
	                    "your request made it to Amazon SQS, but was " +
	                    "rejected with an error response for some reason.");
	            System.out.println("\r\n Error Message:    " + ase.getMessage());
	            System.out.println("\r\n HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("\r\n AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("\r\n Error Type:       " + ase.getErrorType());
	            System.out.println("\r\n Request ID:       " + ase.getRequestId());
	        } catch (final AmazonClientException ace) {
	            System.out.println("\r\n Caught an AmazonClientException, which means " +
	                    "the client encountered a serious internal problem while " +
	                    "trying to communicate with Amazon SQS, such as not " +
	                    "being able to access the network.");
	            System.out.println("\r\n Error Message: " + ace.getMessage());
	        }
	    }
	
	/**
	 * Get UserID of Perfect Match ID for a user
	 */
	public static String GetPerfectMatchUserID(String pUserID) {
		
		Session session = generalFunctions.ConnectSSH();
		String userIDPerfectMatch ="";
		String command = "xxxxxxxxxxxxxxxxxxxxxxxxxcurrent/bin/console lms:matching:query "+ pUserID +" --matcher=perfect_match --limit=100 --cache=false";
        	
		try {
			Channel channel = session.openChannel("exec");
        		((ChannelExec)channel).setCommand(command);
        		channel.setInputStream(null);
        		((ChannelExec)channel).setErrStream(System.err);
          
        		InputStream input = channel.getInputStream();
        		channel.connect();
          
        		System.out.println("Channel Connected to machine 52.221.53.2 Staging server with command: " + command ); 
          
        		try{
        			InputStreamReader inputReader = new InputStreamReader(input);
        			BufferedReader bufferedReader = new BufferedReader(inputReader);
        			/*String line = null;
        			while((line = bufferedReader.readLine()) != null){
        				System.out.println(line);
        			}*/
        			
        			for(int x = 0; x < 7; x++){
        				bufferedReader.readLine();
        			}
        				
        			userIDPerfectMatch = bufferedReader.readLine().split("                ")[0].split("_")[1];
        			
        			bufferedReader.close();
        			inputReader.close();
        			}
        		catch(IOException ex){
        			ex.printStackTrace();
        			}
        		
        		channel.disconnect();
        		session.disconnect();
			}
        			
        catch(Exception ex)
		{
        		ex.printStackTrace();
        }
		return userIDPerfectMatch;
     }
	
	/**
	 * Get UserID of Perfect Match ID for a user
	 */
	public static String GetNewMatchingUserID(String pUserID) {
		
		Session session = generalFunctions.ConnectSSH();
		String userIDPerfectMatch ="";
		String command = "xxxxxxxxxxxxxxxxxxxxxxxxxcurrent/bin/console lms:matching:query "+ pUserID +" --matcher=new_match --limit=100 --cache=false";
        	
		try {
			Channel channel = session.openChannel("exec");
        		((ChannelExec)channel).setCommand(command);
        		channel.setInputStream(null);
        		((ChannelExec)channel).setErrStream(System.err);
          
        		InputStream input = channel.getInputStream();
        		channel.connect();
          
        		System.out.println("Channel Connected to machine 52.221.53.2 Staging server with command: " + command ); 
          
        		try{
        			InputStreamReader inputReader = new InputStreamReader(input);
        			BufferedReader bufferedReader = new BufferedReader(inputReader);
        			/*String line = null;
        			while((line = bufferedReader.readLine()) != null){
        				System.out.println(line);
        			}*/
        			
        			for(int x = 0; x < 7; x++){
        				bufferedReader.readLine();
        			}
        				
        			userIDPerfectMatch = bufferedReader.readLine().split("                    ")[0].split("_")[1];
        			
        			bufferedReader.close();
        			inputReader.close();
        			}
        		catch(IOException ex){
        			ex.printStackTrace();
        			}
        		
        		channel.disconnect();
        		session.disconnect();
			}
        			
        catch(Exception ex)
		{
        		ex.printStackTrace();
        }
		return userIDPerfectMatch;
     }
	
	/**
	 * Send message to worker staging-email-premium-zero-promotion
	 * @param pUserID
	 *            User ID of user who will receive mail
	 */
	public static void SendWorker_Email_New_Perfect(String pUserID) {
	
		AmazonSQS sqs = ConnectSQS();
		
	 	/*JSONObject obj = new JSONObject();
	 	
	 	obj.put("userId", pUserID);
	 	obj.put("source", "staging_email_new_perfect");*/
	    try {
	    		// Send a message.
	    		System.out.println("Sending a message to staging_email_new-perfect\n");
	        sqs.sendMessage(new SendMessageRequest("https://sqs.ap-southeast-1.amazonaws.com/495045559872/staging-email-new-perfect_new","{\"userId\":"+ pUserID +",\"source\":\"staging_email_new_perfect\"}"));            	            
	        //sqs.sendMessage(new SendMessageRequest("https://sqs.ap-southeast-1.amazonaws.com/495045559872/staging-email-new-perfect",obj.toJSONString()));
	    		} catch (final AmazonServiceException ase) {
	    			System.out.println("\r\n Caught an AmazonServiceException, which means " +
	                    "your request made it to Amazon SQS, but was " +
	                    "rejected with an error response for some reason.");
	            System.out.println("\r\n Error Message:    " + ase.getMessage());
	            System.out.println("\r\n HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("\r\n AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("\r\n Error Type:       " + ase.getErrorType());
	            System.out.println("\r\n Request ID:       " + ase.getRequestId());
	        } catch (final AmazonClientException ace) {
	            System.out.println("\r\n Caught an AmazonClientException, which means " +
	                    "the client encountered a serious internal problem while " +
	                    "trying to communicate with Amazon SQS, such as not " +
	                    "being able to access the network.");
	            System.out.println("\r\n Error Message: " + ace.getMessage());
	        }
	    }
	
	/**
	 * Send message to worker staging_email_new_matching
	 * @param pUserID
	 *            User ID of user who will receive mail
	 */
	public static void SendWorker_Email_New_Matching(String pUserID) {
		
		AmazonSQS sqs = ConnectSQS();
		
	    try {
	    		// Send a message.
	    		System.out.println("Sending a message to staging_email_new-matching\n");
	        sqs.sendMessage(new SendMessageRequest("https://sqs.ap-southeast-1.amazonaws.com/495045559872/staging-email-new-matching_new","{\"userId\":"+ pUserID +",\"source\":\"staging_email_new_matching\"}"));            	            
	    		} catch (final AmazonServiceException ase) {
	    			System.out.println("\r\n Caught an AmazonServiceException, which means " +
	                    "your request made it to Amazon SQS, but was " +
	                    "rejected with an error response for some reason.");
	            System.out.println("\r\n Error Message:    " + ase.getMessage());
	            System.out.println("\r\n HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("\r\n AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("\r\n Error Type:       " + ase.getErrorType());
	            System.out.println("\r\n Request ID:       " + ase.getRequestId());
	        } catch (final AmazonClientException ace) {
	            System.out.println("\r\n Caught an AmazonClientException, which means " +
	                    "the client encountered a serious internal problem while " +
	                    "trying to communicate with Amazon SQS, such as not " +
	                    "being able to access the network.");
	            System.out.println("\r\n Error Message: " + ace.getMessage());
	        }
	    }
	
}
