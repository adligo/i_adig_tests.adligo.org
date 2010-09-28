package org.adligo.i.adig;

import org.adligo.i.adi.client.InvocationException;

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
	public MockReturn invoke(MockParam valueObject) throws InvocationException {
		// TODO Auto-generated method stub
		return new MockReturn();
	}

}
