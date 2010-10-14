package org.adligo.i.adig;

public class TestGRegistry {

	public static synchronized void removeCheckedInvoker(String key){
		GRegistry.removeCheckedInvoker(key);
	}
	
	public static synchronized void removeInvoker(String key){
		GRegistry.removeInvoker(key);
	}
}
