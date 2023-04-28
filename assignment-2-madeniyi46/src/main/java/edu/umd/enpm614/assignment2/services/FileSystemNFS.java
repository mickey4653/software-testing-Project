package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.FileSystem;
import org.springframework.stereotype.Component;

public class FileSystemNFS implements FileSystem {
	@Override
	public String getType() {
		return "NFS FileSystem";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
