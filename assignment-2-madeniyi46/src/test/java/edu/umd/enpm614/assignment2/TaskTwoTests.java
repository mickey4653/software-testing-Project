package edu.umd.enpm614.assignment2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static edu.umd.enpm614.assignment2.Assignment2Application.TASK_2_ENV;

@SpringBootTest
@ActiveProfiles(TASK_2_ENV)
class TaskTwoTests {

    @Test
    void contextLoads() {
    }

}
