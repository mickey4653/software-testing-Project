package edu.umd.enpm614.assignment2.application;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WebApplication {
	private WebServer server;

	@Inject
	public WebApplication(WebServer server) {
		this.server = server;
	}

	public void run() {
		System.out.println("starting web application...");

		server.run();
		
		System.out.println("web application finished.");
	}
}
