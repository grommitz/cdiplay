package com.grommitz.cdiplay.web;

import com.codahale.metrics.MetricRegistry;
import com.grommitz.cdiplay.Metrics;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;

/**
 * Created by martin on 08/12/17.
 */
@WebListener("metrics")
public class MetricsServlet extends com.codahale.metrics.servlets.MetricsServlet.ContextListener {

	@Inject
	Metrics metrics;

	protected MetricRegistry getMetricRegistry() {
		return metrics.getMetricRegistry();
	}
}