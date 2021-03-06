package org.adligo.i.adig_tests.shared;

import org.adligo.i.adig.shared.GRegistry;


public class MockGRegistry extends GRegistry {

	public static synchronized void removeCheckedInvoker(String key){
		GRegistry.removeCheckedInvoker(key);
	}
	
	public static synchronized void removeInvoker(String key){
		GRegistry.removeInvoker(key);
	}
	
	public static synchronized void deleteCheckedInvoker(String key){
		GRegistry.deleteCheckedInvoker(key);
	}
	
	public static synchronized void deleteInvoker(String key){
		GRegistry.deleteInvoker(key);
	}
}
