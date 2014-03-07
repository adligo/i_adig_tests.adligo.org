package org.adligo.i.adig_tests;

import org.adligo.i.adig_tests.shared.GRegistryAssertions;
import org.adligo.tests.ATest;
import org.adligo.tests.shared.AssertionStats;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GRegistryTests extends ATest {
	private static GRegistryAssertions assertions = new GRegistryAssertions();
	
	@AfterClass
	public static void afterClass() {
		AssertionStats.logAssertionStats(GRegistryTests.class, assertions);
	}
	
	public GRegistryTests() {
		assertions.setTest(this);
	}
	
	@Test
	public void testGetInvokerParameterExceptions() {
		assertions.getInvokerParameterExceptionsAssertions();
	}
	
	@Test
	public void testGetCheckedInvokerParameterExceptions() {
		assertions.getCheckedInvokerParameterExceptionsAssertions();
	}
	
	@Test
	public void testAddAndGetSimpleCheckedInvokerAssertions() throws Exception {
		assertions.addAndGetSimpleCheckedInvokerAssertions();
	}
	
	@Test
	public void testAddAndGetSimpleInvokerAssertions() throws Exception {
		assertions.addAndGetSimpleInvokerAssertions();
	}
	
	@Test
	public void testGetAndAddSimpleCheckedInvokerAssertions() throws Exception {
		assertions.getAndAddSimpleCheckedInvokerAssertions();
	}
	
	@Test
	public void testGetAndAddSimpleInvokerAssertions() throws Exception {
		assertions.getAndAddSimpleCheckedInvokerAssertions();
	}
	
	@Test
	public void testGetAndGetSimpleCheckedInvokerMismatchAssertions() throws Exception {
		assertions.getAndGetSimpleCheckedInvokerMismatchAssertions();
	}
	
	@Test
	public void testGetAndGetSimpleInvokerMismatchAssertions() throws Exception {
		assertions.getAndGetSimpleInvokerMismatchAssertions();
	}
	
	@Test
	public void testAddAndGetSimpleInvokerMismatchAssertions() throws Exception {
		assertions.addAndGetSimpleInvokerMismatchAssertions();
	}
	
	@Test
	public void testAddAndGetSimpleCheckedInvokerMismatchAssertions() throws Exception {
		assertions.addAndGetSimpleCheckedInvokerMismatchAssertions();
	}
	
	@Test
	public void testGetAndAddSimpleInvokerParamMismatchAssertions() throws Exception {
		assertions.getAndAddSimpleInvokerParamMismatchAssertions();
	}
	
	@Test
	public void testGetAndAddSimpleInvokerReturnMismatchAssertions() throws Exception {
		assertions.getAndAddSimpleInvokerReturnMismatchAssertions();
	}
	
	@Test
	public void testGetAndAddSimpleCheckedInvokerParamMismatchAssertions() throws Exception {
		assertions.getAndAddSimpleCheckedInvokerParamMismatchAssertions();
	}
	
	@Test
	public void testGetAndAddSimpleCheckedInvokerReturnMismatchAssertions() throws Exception {
		assertions.getAndAddSimpleCheckedInvokerReturnMismatchAssertions();
	}
	/*
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
		IllegalStateException s = null;
		try {
			@SuppressWarnings("unused")
			I_GCheckedInvoker<MockParam, I_MockReturn>  theInvoker2 = 
				GRegistry.getCheckedInvoker("somePlugin", MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					IllegalStateException.class ,c.getClass() );
			s = (IllegalStateException) c;
		}
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"somePlugin\n" +
				"had a param class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"and this parameter class is;\n" +
				"null\n" +
				"Please fix the code or talk to your architect.", 
			s.getMessage(), this);
		
		s = null;
		try {
			@SuppressWarnings("unused")
			I_GCheckedInvoker<I_MockParam, MockReturn>  theInvoker2 = 
				GRegistry.getCheckedInvoker("somePlugin", I_MockParam.class, MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					IllegalStateException.class ,c.getClass() );
			s = (IllegalStateException) c;
		}
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"somePlugin\n" +
				"had a return class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"and this return class is;\n" +
				"null\n" +
				"Please fix the code or talk to your architect.", 
			s.getMessage(), this);
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
		IllegalStateException s = null;
		try {
			@SuppressWarnings("unused")
			I_GInvoker<MockParam, I_MockReturn>  theInvoker2 = 
				GRegistry.getInvoker("somePlugin", MockParam.class, I_MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					IllegalStateException.class ,c.getClass() );
			s= (IllegalStateException) c;
		}
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
					"getInvoker(String key, Class param, Class return)\n" +
					"with key;\n" +
					"somePlugin\n" +
					"had a param class;\n" +
					"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
					"and this parameter class is;\n" +
					"null\n" +
					"Please fix the code or talk to your architect.", 
				s.getMessage(), this);
		
		s = null;
		try {
			@SuppressWarnings("unused")
			I_GInvoker<I_MockParam, MockReturn>  theInvoker2 = 
				GRegistry.getInvoker("somePlugin", I_MockParam.class, MockReturn.class);
		} catch (Exception c) {
			assertEquals("Should have thrown a InvokerRequestException", 
					IllegalStateException.class ,c.getClass() );
			s = (IllegalStateException) c;
		}
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"somePlugin\n" +
				"had a return class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"and this return class is;\n" +
				"null\n" +
				"Please fix the code or talk to your architect.", 
			s.getMessage(), this);
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
	8
	*/
}
