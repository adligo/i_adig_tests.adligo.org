package org.adligo.i.adig_tests.shared;

import org.adligo.i.adig.shared.BaseGInvoker;
import org.adligo.i.adig.shared.I_GInvoker;

public class MockGClock extends BaseGInvoker implements I_GInvoker<Object, Long> {
	public static final MockGClock INSTANCE = new MockGClock();
	
	private long time = 0;
	
	private MockGClock() {
		super(Object.class, Long.class);
	}

	@Override
	public Long invoke(Object valueObject) {
		return time;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	
}
