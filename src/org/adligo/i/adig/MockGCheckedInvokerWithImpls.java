package org.adligo.i.adig;

/**
 * this is what a impl should look like
 * you should be able to upcast it to I_MockParam I_MockReturn exc;
 * 
 * @author scott
 *
 */
public class MockGCheckedInvokerWithImpls extends BaseGInvoker implements I_GCheckedInvoker<MockParam, MockReturn>{

	public MockGCheckedInvokerWithImpls() {
		super(MockParam.class, MockReturn.class);
	}
	
	@Override
	public MockReturn invoke(MockParam valueObject) {
		// TODO Auto-generated method stub
		return new MockReturn();
	}

}
