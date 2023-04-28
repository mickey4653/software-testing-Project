package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Connection;
import edu.umd.enpm614.assignment2.interfaces.FileSystem;
import edu.umd.enpm614.assignment2.interfaces.Persistence;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PersistenceMySQL implements Persistence {

	private final FileSystem fileSys;
	private final Connection conn;


	@Inject
	public PersistenceMySQL(FileSystem fileSys, Connection conn){
		this.fileSys = fileSys;
		this.conn = conn;
	}



	@Override
	public String getType() {
		return "MySQL Persistence";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		fileSys.run();
		conn.run();
		return true;
	}
}
