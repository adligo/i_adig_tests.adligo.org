package org.adligo.i.adig;

/**
 * this is what a impl should look like
 * 
 * @author scott
 *
 */
public class MockGInvoker extends BaseGInvoker implements I_GInvoker<I_MockParam, I_MockReturn>{

	public MockGInvoker() {
		super(I_MockParam.class, I_MockReturn.class);
	}
	
	@Override
	public I_MockReturn invoke(I_MockParam valueObject) {
		// TODO Auto-generated method stub
		return new MockReturn();
	}

}
