package com.grommitz.cdiplay;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * Created by martin on 08/12/17.
 */
@ApplicationScoped
public class Metrics {

	MetricRegistry metricRegistry;

	@PostConstruct
	public void init() {
		metricRegistry = new MetricRegistry();
	}

	public void addGauge(String name, final Long value) {
		Gauge gauge = metricRegistry.getGauges().get(name);

		if (gauge != null) {
			metricRegistry.remove(name);
		}
		metricRegistry.register(name, new Gauge<Long>() {
			public Long getValue() {
				return value;
			}
		});
	}

	public void catchEvent(@Observes final MyDomainClass payload) {
		System.out.println("Caught event with payload: " + payload);
		addGauge("systemTime", payload.getEpochMillis());

	}

	public MetricRegistry getMetricRegistry() {
		return metricRegistry;
	}
}
