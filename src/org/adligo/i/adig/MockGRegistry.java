package org.adligo.i.adig;

public class MockGRegistry {

	public static synchronized void removeCheckedInvoker(String key){
		GRegistry.removeCheckedInvoker(key);
	}
	
	public static synchronized void removeInvoker(String key){
		GRegistry.removeInvoker(key);
	}
}
