package org.adligo.i.adig_tests.shared;

import org.adligo.i.adig.client.GRegistry;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.adig.client.I_GInvoker;
import org.adligo.i.adig.client.InvokerRequestException;
import org.adligo.tests.ATest;

public class GRegistryParamCheckTests extends ATest {

	public void testGetCheckedInvoker() {
		InvokerRequestException x = null;
		
		try {
			GRegistry.getCheckedInvoker(null, null, null);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_CHECKED_INVOKER_METHOD_NAME +" passed a null for the key parameter.", 
				x.getMessage() );
		
		x = null;
		
		try {
			GRegistry.getCheckedInvoker("hey", null, null);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_CHECKED_INVOKER_METHOD_NAME +" passed a null for the param parameter.", 
				x.getMessage() );
		
		x = null;
		
		try {
			GRegistry.getCheckedInvoker("hey", String.class, null);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_CHECKED_INVOKER_METHOD_NAME +" passed a null for the returnType parameter.", 
				x.getMessage() );
		
		GRegistry.addCheckedInvoker("somePlugin", new MockGCheckedInvoker());
		 //did it work?
		I_GCheckedInvoker<I_MockParam, I_MockReturn> theInvoker = 
			GRegistry.getCheckedInvoker("somePlugin", I_MockParam.class, I_MockReturn.class);
		
		assertNotNull(theInvoker);
		//yep sure did
		x = null;
		try {
			@SuppressWarnings("unused")
			I_GCheckedInvoker<MockParam, I_MockReturn>  theInvoker2 = 
				GRegistry.getCheckedInvoker("somePlugin", MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_CHECKED_INVOKER_METHOD_NAME +" obtained a " +
						"I_GCheckedInvoker<org.adligo.i.adig.tests.I_MockParam,org.adligo.i.adig.tests.I_MockReturn> " +
						"which is not assignable to " +
						"I_GCheckedInvoker<org.adligo.i.adig.tests.MockParam,org.adligo.i.adig.tests.I_MockReturn, " +
						"please fix your coding error or talk to your architect. ", 
				x.getMessage() );
		
		x = null;
		try {
			@SuppressWarnings("unused")
			I_GCheckedInvoker<I_MockParam, MockReturn>  theInvoker2 = 
				GRegistry.getCheckedInvoker("somePlugin", I_MockParam.class, MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_CHECKED_INVOKER_METHOD_NAME +" obtained a " +
						"I_GCheckedInvoker<org.adligo.i.adig.tests.I_MockParam,org.adligo.i.adig.tests.I_MockReturn> " +
						"which is not assignable to " +
						"I_GCheckedInvoker<org.adligo.i.adig.tests.I_MockParam,org.adligo.i.adig.tests.MockReturn, " +
						"please fix your coding error or talk to your architect. ", 
				x.getMessage() );
		MockGRegistry.removeCheckedInvoker("somePlugin");
		
		x = null;
		try {
			theInvoker = 
				GRegistry.getCheckedInvoker("somePlugin", I_MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertNotNull(theInvoker);
		
		MockGRegistry.deleteCheckedInvoker("somePlugin");
		GRegistry.addCheckedInvoker("somePlugin", new MockGCheckedInvokerWithImpls());
		
	}
	
	
	public void testGetInvoker() {
		InvokerRequestException x = null;
		
		try {
			GRegistry.getInvoker(null, null, null);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_INVOKER_METHOD_NAME +" passed a null for the key parameter.", 
				x.getMessage() );
		
		x = null;
		
		try {
			GRegistry.getInvoker("hey", null, null);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_INVOKER_METHOD_NAME +" passed a null for the param parameter.", 
				x.getMessage() );
		
		x = null;
		
		try {
			GRegistry.getInvoker("hey", String.class, null);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_INVOKER_METHOD_NAME +" passed a null for the returnType parameter.", 
				x.getMessage() );
		
		GRegistry.addInvoker("somePlugin", new MockGInvoker());
		 //did it work?
		I_GInvoker<I_MockParam, I_MockReturn> theInvoker = 
			GRegistry.getInvoker("somePlugin", I_MockParam.class, I_MockReturn.class);
		
		assertNotNull(theInvoker);
		//yep sure did
		x = null;
		try {
			@SuppressWarnings("unused")
			I_GInvoker<MockParam, I_MockReturn>  theInvoker2 = 
				GRegistry.getInvoker("somePlugin", MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_INVOKER_METHOD_NAME +" obtained a " +
						"I_GInvoker<org.adligo.i.adig.tests.I_MockParam,org.adligo.i.adig.tests.I_MockReturn> " +
						"which is not assignable to " +
						"I_GInvoker<org.adligo.i.adig.tests.MockParam,org.adligo.i.adig.tests.I_MockReturn, " +
						"please fix your coding error or talk to your architect. ", 
				x.getMessage() );
		
		x = null;
		try {
			@SuppressWarnings("unused")
			I_GInvoker<I_MockParam, MockReturn>  theInvoker2 = 
				GRegistry.getInvoker("somePlugin", I_MockParam.class, MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + 
				GRegistry.GET_INVOKER_METHOD_NAME +" obtained a " +
						"I_GInvoker<org.adligo.i.adig.tests.I_MockParam,org.adligo.i.adig.tests.I_MockReturn> " +
						"which is not assignable to " +
						"I_GInvoker<org.adligo.i.adig.tests.I_MockParam,org.adligo.i.adig.tests.MockReturn, " +
						"please fix your coding error or talk to your architect. ", 
				x.getMessage() );
		MockGRegistry.removeInvoker("somePlugin");
		
		x = null;
		try {
			theInvoker = 
				GRegistry.getInvoker("somePlugin", I_MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertNotNull(theInvoker);
		
		MockGRegistry.deleteInvoker("somePlugin");
		GRegistry.addInvoker("somePlugin", new MockGInvokerWithImpls());
		
	}
}
