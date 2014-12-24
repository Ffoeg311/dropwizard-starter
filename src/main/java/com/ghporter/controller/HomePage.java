package com.ghporter.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ghporter.views.StaticPage;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomePage {
	
	@GET
	public StaticPage getPage() {
		return new StaticPage("/resources/home.mustache");
	}

}
