package org.adligo.i.adig;

public class MockReturn implements I_MockReturn {
	public static final Integer MOCK_RETURN = 1;
	
	@Override
	public Integer getId() {
		return MOCK_RETURN;
	}
}
