package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Authentication;
import edu.umd.enpm614.assignment2.interfaces.Frontend;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
@Component
public class FrontendGWT implements Frontend {

	private final Authentication auth;


	@Inject
	public FrontendGWT(Authentication auth){
		this.auth = auth;
	}

	@Override
	public String getType() {
		return "GWT Frontend";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		auth.run();

		return true;
	}
}
