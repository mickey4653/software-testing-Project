package edu.umd.enpm614.assignment2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_1_ENV;

@SpringBootTest
@ActiveProfiles(TASK_1_ENV)
class TaskOneTests {

	@Test
	void contextLoads() {
	}

}
