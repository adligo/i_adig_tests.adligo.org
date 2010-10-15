package org.adligo.i.adig;

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