package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.FileSystem;
import org.springframework.stereotype.Component;

public class FileSystemNTFS implements FileSystem {
	@Override
	public String getType() {
		return "NTFS FileSystem";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
