package org.adligo.i.adig_tests.shared;

import org.adligo.i.adig.shared.GRegistry;
import org.adligo.i.adig.shared.I_GCheckedInvoker;
import org.adligo.i.adig.shared.I_GInvoker;
import org.adligo.i.adig.shared.InitalProxyMarker;
import org.adligo.i.util_tests.shared.utils.LineTextAssertions;
import org.adligo.tests.shared.AAssertions;

public class GRegistryAssertions extends AAssertions {

	@Override
	public String getPackage() {
		return GRegistry.class.getPackage().getName();
	}

	
	public void getInvokerParameterExceptionsAssertions() {
		IllegalStateException caught = null;
		
		try {
			GRegistry.getInvoker(null, String.class, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		assertEquals("The key passed to "
				+ "getInvoker(String key, Class param, Class returnType) "
				+ "was null.",caught.getMessage());
			
		caught = null;
		try {
			GRegistry.getInvoker("key", null, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		assertEquals("The param passed to "
				+ "getInvoker(String key, Class param, Class returnType) "
				+ "was null.",caught.getMessage());
		
		caught = null;
		try {
			GRegistry.getInvoker("key", String.class, null);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		assertEquals("The returnType passed to "
				+ "getInvoker(String key, Class param, Class returnType) "
				+ "was null.",caught.getMessage());
	}
	
	public void getCheckedInvokerParameterExceptionsAssertions() {
		IllegalStateException caught = null;
		
		try {
			GRegistry.getCheckedInvoker(null, String.class, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		assertEquals("The key passed to "
				+ "getCheckedInvoker(String key, Class param, Class returnType) "
				+ "was null.",caught.getMessage());
			
		caught = null;
		try {
			GRegistry.getCheckedInvoker("key", null, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		assertEquals("The param passed to "
				+ "getCheckedInvoker(String key, Class param, Class returnType) "
				+ "was null.",caught.getMessage());
		
		caught = null;
		try {
			GRegistry.getCheckedInvoker("key", String.class, null);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		assertEquals("The returnType passed to "
				+ "getCheckedInvoker(String key, Class param, Class returnType) "
				+ "was null.",caught.getMessage());
	}
	
	public void addAndGetSimpleInvokerAssertions() {
		GRegistry.addInvoker("addAndGetSimpleInvokerAssertions", new MockGInvoker());
		I_GInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getInvoker(
				"addAndGetSimpleInvokerAssertions", 
				I_MockParam.class, I_MockReturn.class);
		I_MockReturn ret = inv.invoke(new MockParam());
		assertEquals(MockReturn.MOCK_RETURN,ret.getId());
	}
	
	public void addAndGetSimpleCheckedInvokerAssertions() throws Exception {
		GRegistry.addCheckedInvoker("addAndGetSimpleCheckedInvokerAssertions", new MockGCheckedInvoker());
		I_GCheckedInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getCheckedInvoker(
				"addAndGetSimpleCheckedInvokerAssertions", 
				I_MockParam.class, I_MockReturn.class);
		I_MockReturn ret = inv.invoke(new MockParam());
		assertEquals(MockReturn.MOCK_RETURN,ret.getId());
		
	}
	
	
	public void getAndAddSimpleInvokerAssertions() {
		I_GInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getInvoker(
				"getAndAddSimpleInvokerAssertions", 
				I_MockParam.class, I_MockReturn.class);
		GRegistry.addInvoker("getAndAddSimpleInvokerAssertions", new MockGInvoker());
		
		I_MockReturn ret = inv.invoke(new MockParam());
		assertEquals(MockReturn.MOCK_RETURN,ret.getId());
	}
	
	public void getAndAddSimpleCheckedInvokerAssertions() throws Exception {
		I_GCheckedInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getCheckedInvoker(
				"getAndAddSimpleCheckedInvokerAssertions", 
				I_MockParam.class, I_MockReturn.class);
		GRegistry.addCheckedInvoker("getAndAddSimpleCheckedInvokerAssertions", new MockGCheckedInvoker());
		
		I_MockReturn ret = inv.invoke(new MockParam());
		assertEquals(MockReturn.MOCK_RETURN,ret.getId());
		
	}
	
	public void getAndGetSimpleInvokerMismatchAssertions() {
		I_GInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getInvoker(
				"getAndGetSimpleInvokerMismatchAssertions", 
				I_MockParam.class, I_MockReturn.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.getInvoker(
					"getAndGetSimpleInvokerMismatchAssertions", 
					String.class, I_MockReturn.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndGetSimpleInvokerMismatchAssertions\n" +
				"had a param class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"and this parameter class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
		
		caught = null;
		try {
			GRegistry.getInvoker(
					"getAndGetSimpleInvokerMismatchAssertions", 
					I_MockParam.class, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndGetSimpleInvokerMismatchAssertions\n" +
				"had a return class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"and this return class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	public void getAndGetSimpleCheckedInvokerMismatchAssertions() throws Exception {
		I_GCheckedInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getCheckedInvoker(
				"getAndGetSimpleCheckedInvokerMismatchAssertions", 
				I_MockParam.class, I_MockReturn.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.getCheckedInvoker(
					"getAndGetSimpleCheckedInvokerMismatchAssertions", 
					String.class, I_MockReturn.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndGetSimpleCheckedInvokerMismatchAssertions\n" +
				"had a param class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"and this parameter class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
		
		caught = null;
		try {
			GRegistry.getCheckedInvoker(
					"getAndGetSimpleCheckedInvokerMismatchAssertions", 
					I_MockParam.class, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndGetSimpleCheckedInvokerMismatchAssertions\n" +
				"had a return class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"and this return class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	
	public void addAndGetSimpleInvokerMismatchAssertions() {
		GRegistry.addInvoker(
				"addAndGetSimpleInvokerMismatchAssertions", 
				new MockGInvoker());
		
		IllegalStateException caught = null;
		try {
			GRegistry.getInvoker(
					"addAndGetSimpleInvokerMismatchAssertions", 
					String.class, I_MockReturn.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"addAndGetSimpleInvokerMismatchAssertions\n" +
				"had a param class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"and this parameter class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
		
		caught = null;
		try {
			GRegistry.getInvoker(
					"addAndGetSimpleInvokerMismatchAssertions", 
					I_MockParam.class, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"addAndGetSimpleInvokerMismatchAssertions\n" +
				"had a return class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"and this return class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	public void addAndGetSimpleCheckedInvokerMismatchAssertions() throws Exception {
		I_GCheckedInvoker<I_MockParam, I_MockReturn> inv = GRegistry.getCheckedInvoker(
				"addAndGetSimpleCheckedInvokerMismatchAssertions", 
				I_MockParam.class, I_MockReturn.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.getCheckedInvoker(
					"addAndGetSimpleCheckedInvokerMismatchAssertions", 
					String.class, I_MockReturn.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"addAndGetSimpleCheckedInvokerMismatchAssertions\n" +
				"had a param class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"and this parameter class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
		
		caught = null;
		try {
			GRegistry.getCheckedInvoker(
					"addAndGetSimpleCheckedInvokerMismatchAssertions", 
					I_MockParam.class, String.class);
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"addAndGetSimpleCheckedInvokerMismatchAssertions\n" +
				"had a return class;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"and this return class is;\n" +
				"class java.lang.String\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	
	public void getAndAddSimpleInvokerParamMismatchAssertions() {
		@SuppressWarnings("unused")
		I_GInvoker<String, I_MockReturn> invoker = GRegistry.getInvoker(
				"getAndAddSimpleInvokerParamMismatchAssertions", 
				String.class, I_MockReturn.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.addInvoker(
					"getAndAddSimpleInvokerParamMismatchAssertions", 
					new MockGInvoker());
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndAddSimpleInvokerParamMismatchAssertions\n" +
				"had a param class;\n" +
				"class java.lang.String\n" +
				"and this parameter class is;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	public void getAndAddSimpleInvokerReturnMismatchAssertions() {
		@SuppressWarnings("unused")
		I_GInvoker<I_MockParam, String> invoker = GRegistry.getInvoker(
				"getAndAddSimpleInvokerReturnMismatchAssertions", 
				I_MockParam.class, String.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.addInvoker(
					"getAndAddSimpleInvokerReturnMismatchAssertions", 
					new MockGInvoker());
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndAddSimpleInvokerReturnMismatchAssertions\n" +
				"had a return class;\n" +
				"class java.lang.String\n" +
				"and this return class is;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	public void getAndAddSimpleCheckedInvokerParamMismatchAssertions() {
		@SuppressWarnings("unused")
		I_GCheckedInvoker<String, I_MockReturn> invoker = GRegistry.getCheckedInvoker(
				"getAndAddSimpleCheckedInvokerParamMismatchAssertions", 
				String.class, I_MockReturn.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.addCheckedInvoker(
					"getAndAddSimpleCheckedInvokerParamMismatchAssertions", 
					new MockGCheckedInvoker());
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndAddSimpleCheckedInvokerParamMismatchAssertions\n" +
				"had a param class;\n" +
				"class java.lang.String\n" +
				"and this parameter class is;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockParam\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
	
	public void getAndAddSimpleCheckedInvokerReturnMismatchAssertions() {
		@SuppressWarnings("unused")
		I_GCheckedInvoker<I_MockParam, String> invoker = GRegistry.getCheckedInvoker(
				"getAndAddSimpleCheckedInvokerReturnMismatchAssertions", 
				I_MockParam.class, String.class);
		
		IllegalStateException caught = null;
		try {
			GRegistry.addCheckedInvoker(
					"getAndAddSimpleCheckedInvokerReturnMismatchAssertions", 
					new MockGCheckedInvoker());
		} catch (IllegalStateException x) {
			caught = x;
		}
		assertNotNull(caught);
		Throwable cause = caught.getCause();
		assertNotNull(cause);
		assertEquals(InitalProxyMarker.class, cause.getClass());
		LineTextAssertions.compaireFileText("The inital call to the GRegistry's method\n" +
				"getCheckedInvoker(String key, Class param, Class return)\n" +
				"with key;\n" +
				"getAndAddSimpleCheckedInvokerReturnMismatchAssertions\n" +
				"had a return class;\n" +
				"class java.lang.String\n" +
				"and this return class is;\n" +
				"interface org.adligo.i.adig_tests.shared.I_MockReturn\n" +
				"Please fix the code or talk to your architect."
				, caught.getMessage(), this);
	}
}
