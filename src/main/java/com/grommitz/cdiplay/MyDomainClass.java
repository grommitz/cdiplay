package com.grommitz.cdiplay;

/**
 * Created by martin on 08/12/17.
 */
public class MyDomainClass {

	private final Long epochMillis;

	public MyDomainClass(Long millis) {
		this.epochMillis = millis;
	}

	public Long getEpochMillis() {
		return epochMillis;
	}

	@Override
	public String toString() {
		return "Epoch Millis = " + epochMillis;
	}
}
