package edu.umd.enpm614.assignment2;

import edu.umd.enpm614.assignment2.application.WebApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;

@SpringBootApplication
public class Assignment2Application implements ApplicationRunner {
	public static final String TASK_1_ENV = "task1";
	public static final String TASK_2_ENV = "task2";

	@Inject
	WebApplication webApplication;

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		webApplication.run();
	}
}
