package com.grommitz.cdiplay.intercept;

import com.grommitz.cdiplay.Metrics;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Created by martin on 08/12/17.
 */
@Timestamped
@Interceptor
public class TimestampedInterceptor implements Serializable {

	@Inject
	Metrics metrics;

	@AroundInvoke
	public Object intercept(InvocationContext invocationContext)
			throws Exception {

		metrics.addGauge(invocationContext.getMethod().getName(), System.currentTimeMillis());

		System.out.println("intercepted call to " + invocationContext.getMethod().getName());

		return invocationContext.proceed();
	}



}
