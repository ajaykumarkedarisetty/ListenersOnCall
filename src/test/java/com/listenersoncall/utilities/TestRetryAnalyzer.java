/**
 * 
 */
package com.listenersoncall.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author ajaykumar.k
 *
 */
public class TestRetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retryMaxLimit  = Integer.valueOf(PropertiesOperation.getPropertyValueByKey("retryCount"));
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retryMaxLimit) {
			counter++;
			return true;
		}
		return false;
	}

}