package com.saucelab.retry.in;



	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;

	public class RetryLogic implements IRetryAnalyzer {

		

		    private int retryCount = 0;
		    private static final int maxRetryCount = 2;

		    @Override
		    public boolean retry(ITestResult result) {

		        if (retryCount < maxRetryCount) {
		            retryCount++;

		            System.out.println(
		                "Retrying test: " + result.getName()
		                + " | Retry: " + retryCount
		            );

		            return true;
		        }

		        return false;
		    }
		}
	

