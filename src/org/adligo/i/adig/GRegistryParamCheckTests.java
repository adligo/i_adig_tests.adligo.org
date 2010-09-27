package org.adligo.i.adig;

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
						"I_GCheckedInvoker<org.adligo.i.adig.I_MockParam,org.adligo.i.adig.I_MockReturn> " +
						"which is not assignable to " +
						"I_GCheckedInvoker<org.adligo.i.adig.MockParam,org.adligo.i.adig.I_MockReturn, " +
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
						"I_GCheckedInvoker<org.adligo.i.adig.I_MockParam,org.adligo.i.adig.I_MockReturn> " +
						"which is not assignable to " +
						"I_GCheckedInvoker<org.adligo.i.adig.I_MockParam,org.adligo.i.adig.MockReturn, " +
						"please fix your coding error or talk to your architect. ", 
				x.getMessage() );
		GRegistry.removeCheckedInvoker("somePlugin");
		
		x = null;
		try {
			theInvoker = 
				GRegistry.getCheckedInvoker("somePlugin", I_MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					InvokerRequestException.class ,c.getClass() );
			x = (InvokerRequestException) c;
		}
		assertEquals("Your call to the GRegistry's method " + GRegistry.GET_CHECKED_INVOKER_METHOD_NAME +
				" obtained a  null for key 'somePlugin', please put something in the GRegistry for this key.", x.getMessage());
	}
}
