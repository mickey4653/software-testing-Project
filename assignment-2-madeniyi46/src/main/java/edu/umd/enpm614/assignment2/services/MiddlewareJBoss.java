package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Middleware;
import org.springframework.stereotype.Component;

public class MiddlewareJBoss implements Middleware {
	@Override
	public String getType() {
		return "JBoss Middleware";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
