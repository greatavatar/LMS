package functions;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.concurrent.atomic.AtomicInteger;



public class C_RetryAnalyzer implements IRetryAnalyzer {

	//int counter = 0;
	//int retryLimit = 2;
	/*
	 * 
	 * This method decides how many times a test needs to be rerun.
	 * TestNg will call this method every time a test fails. So we 
	 * can put some code in here to decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried
	 * and false it not.
	 *
	 */

	/*@Override
	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}*/
//--------------------------------------------------------------------------------	
	private static int MAX_RETRY_COUNT = 2;

	AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

	public boolean isRetryAvailable() {
	    return (count.intValue() > 0);
	}

	@Override
	public boolean retry(ITestResult result) {
	    boolean retry = false;
	    if (isRetryAvailable()) {
	        System.out.println("------------------Going to retry test case: " + result.getMethod() + ", " + (MAX_RETRY_COUNT - count.intValue() + 1) + " out of " + MAX_RETRY_COUNT);
	        retry = true;
	        count.decrementAndGet();
	    }
	    return retry;
	}
	
}


