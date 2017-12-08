package com.grommitz.cdiplay.web;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by martin on 08/12/17.
 */
@ApplicationPath("rest")
public class JerseyApp extends ResourceConfig {

	public JerseyApp() {
		packages("com.grommitz.cdiplay.web");
	}

}
