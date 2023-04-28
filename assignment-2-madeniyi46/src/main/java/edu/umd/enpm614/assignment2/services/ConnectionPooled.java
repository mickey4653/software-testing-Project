package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Connection;
import org.springframework.stereotype.Component;

public class ConnectionPooled implements Connection {
	@Override
	public String getType() {
		return "Pooled Connection";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
