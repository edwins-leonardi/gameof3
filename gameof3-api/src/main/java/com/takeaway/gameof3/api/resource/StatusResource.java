package com.takeaway.gameof3.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/status")
public class StatusResource {
	
	@GET
	public String getStatus(){
		return "ok";
	}
}
