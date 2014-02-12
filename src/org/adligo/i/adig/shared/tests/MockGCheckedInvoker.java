package org.adligo.i.adig.shared.tests;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;

/**
 * this is what a impl should look like
 * 
 * @author scott
 *
 */
public class MockGCheckedInvoker extends BaseGInvoker implements I_GCheckedInvoker<I_MockParam, I_MockReturn>{

	public MockGCheckedInvoker() {
		super(I_MockParam.class, I_MockReturn.class);
	}
	
	@Override
	public I_MockReturn invoke(I_MockParam valueObject) throws InvocationException {
		// TODO Auto-generated method stub
		return new MockReturn();
	}

}
