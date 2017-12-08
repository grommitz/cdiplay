package com.grommitz.cdiplay.web;

import com.grommitz.cdiplay.ServiceBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by martin on 08/12/17.
 */
@Stateless
@Path("/service")
public class ServiceResource {

	@Inject
	ServiceBean serviceBean;

	@GET
	public Response get() {
		return Response.status(200).entity(serviceBean.interceptedMethod()).build();
	}

	@GET
	@Path("2")
	public Response get2() {
		return Response.status(200).entity(serviceBean.eventRaisingMethod()).build();
	}



}
