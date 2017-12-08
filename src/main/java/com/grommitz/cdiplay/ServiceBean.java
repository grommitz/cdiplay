package com.grommitz.cdiplay;

import com.grommitz.cdiplay.intercept.Timestamped;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by martin on 08/12/17.
 */
@Stateless
public class ServiceBean {

	@Timestamped(name = "myMethod")
	public String interceptedMethod() {
		MyDomainClass result = new MyDomainClass(System.currentTimeMillis());
		return result.toString();
	}

	@Inject
	Event<MyDomainClass> event;

	public String eventRaisingMethod() {
		MyDomainClass result = new MyDomainClass(System.currentTimeMillis());
		event.fire(result);
		return result.toString();
	}

}
