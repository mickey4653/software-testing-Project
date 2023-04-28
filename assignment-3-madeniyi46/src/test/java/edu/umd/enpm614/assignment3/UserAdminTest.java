package edu.umd.enpm614.assignment3;

import mockit.Expectations;
import mockit.Verifications;
import mockit.Mocked;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAdminTest {
    UserAdmin userAdmin;

    @Mocked
    DBConnection dbConnection;

    @BeforeEach
    public void setUp() {
        userAdmin = new UserAdmin(dbConnection);
    }

    @AfterEach
    public void tearDown() {
        userAdmin = null;
    }

    @Test
    void createUser() throws SQLException {
        new Expectations(){{
            dbConnection.userExists("something");
            result = false;
        }};

        assertTrue(userAdmin.createUser("something", "something"));
        new Verifications(){{
            dbConnection.userExists("something");
        }};

    }

    @Test
    void createUser1() throws SQLException {
        new Expectations(){{
            dbConnection.userExists("something");
            result = true;
        }};

        assertFalse(userAdmin.createUser("something", "something"));
        new Verifications(){{
            dbConnection.userExists("something");
        }};

    }
    @Test
    void createUser2() throws SQLException {
        new Expectations(){{
            dbConnection.userExists("Michael");
            result = false;
        }};
        assertTrue(userAdmin.createUser("Michael", "ps1234"));
        new Verifications(){{
           dbConnection.userExists("Michael");
           times = 1;
        }};
    }

    @Test
    void createUser3() throws SQLException {
        new Expectations(){{
            dbConnection.userExists("Michael");
            result = true;
        }};
        assertFalse(userAdmin.createUser("Michael", "ps1234"));
        new Verifications(){{
            dbConnection.userExists("Michael");
            times = 1;
        }};
    }

    @Test
    void createUser4() throws SQLException {
        new Expectations(){{
            dbConnection.userExists("Michael");
            result = new SQLException();

            // adding SQL injection test here
            dbConnection.userExists("'SELECT * FROM Users'");
            result = new SQLException();
        }};
       userAdmin.createUser("Michael", "ps1234");

        // adding SQL injection test here
        userAdmin.createUser("'SELECT * FROM Users'", "*");
        new Verifications(){{
            dbConnection.userExists("Michael");
            times = 1;

            // adding SQL injection test here
            dbConnection.userExists("'SELECT * FROM Users'");
            times = 1;
        }};
    }

    @Test
    void removeUser() throws SQLException{
        new Expectations(){{

            dbConnection.userExists("something");
            result = true;
            dbConnection.isAdmin("something");
            result = true;
            dbConnection.userExists("something1");
            result = false;

        }};
        assertFalse(userAdmin.removeUser("something"));
        assertFalse(userAdmin.removeUser("something1"));
        new Verifications(){{
            dbConnection.userExists("something");
            times=1;
            dbConnection.userExists("something1");
            times=1;
        }};

    }
    @Test
    void removeUser1() throws SQLException {
        new Expectations(){{

            dbConnection.userExists("something");
            result = false;
            dbConnection.userExists("userAdmin");
            result = true;
        }};
        assertFalse(userAdmin.removeUser("something"));
        assertTrue(userAdmin.removeUser("userAdmin"));
        new Verifications(){{
            dbConnection.userExists("something");
            times=1;
           dbConnection.userExists("userAdmin");
           times=1;
        }};
    }
    @Test
    void removeUser2() throws SQLException{
        new Expectations(){{
            dbConnection.userExists("Michael")
;            result = true;
            dbConnection.isAdmin("Michael");
            result = true;

            dbConnection.userExists("Mike");
            result = false;

        }};
        assertFalse(userAdmin.removeUser("Michael"));
        assertFalse(userAdmin.removeUser("Mike"));
        new Verifications(){{
            dbConnection.userExists("Michael");
            times=1;
            dbConnection.userExists("Mike");
            times=1;
        }};
    }

    @Test
    void removeUser3() throws SQLException{
        new Expectations(){{
            dbConnection.userExists("Michael");
            result = false;
            dbConnection.userExists("anonymous");
            result = true;
        }};
        assertFalse(userAdmin.removeUser("Michael"));
        assertTrue(userAdmin.removeUser("anonymous"));
        new Verifications(){{
            dbConnection.userExists("Michael");
            times=1;
            dbConnection.userExists("anonymous");
            times=1;
        }};
    }

    @Test
    void removeUser4() throws SQLException{
        new Expectations(){{
            dbConnection.userExists("Michael");
            result = new SQLException();

            // removing SQL injection test here
            dbConnection.userExists("'SELECT * FROM Users'");
            result = new SQLException();
        }};
        assertFalse(userAdmin.removeUser("Michael"));


        assertFalse(userAdmin.removeUser("'SELECT * FROM Users'"));
        new Verifications(){{
            dbConnection.userExists("Michael");
            times=1;


            dbConnection.userExists("'SELECT * FROM Users'");
            times=1;
        }};
    }
    @Test
    void runUserReport()throws SQLException {
        User test0 = new User("something", "something");
        List<User> userList = new ArrayList<User>();
        userList.add(test0);
        new Expectations(){{
            dbConnection.getUsers();
            result = userList;
        }};
        userAdmin.runUserReport();
        new Verifications(){{
            dbConnection.getUsers();
            times = 1;
        }};
    }
    @Test
    void runUserReport1()throws SQLException {
        User user12 = new User("something", "something");
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < 15; i++){
            user12.setPassword(user12.getPassword()+i);
            userList.add(user12);
        }
        new Expectations(){{
            dbConnection.getUsers();
            result = userList;
        }};
        userAdmin.runUserReport();
        new Verifications(){{
            dbConnection.getUsers();
            times = 1;
        }};
    }

    @Test
    void runUserReport2() throws SQLException {
        new Expectations(){{
            dbConnection.getUsers();

            //For Empty List
            result = new ArrayList();
        }};
        userAdmin.runUserReport();
        new Verifications(){{
            dbConnection.getUsers();
            times = 1;
        }};
    }

    @Test
    void runUserReport3() throws SQLException {
        User test = new User("Michael", "ps1234");
        List<User> userList = new ArrayList<User>();
        userList.add(test);
        new Expectations(){{
            dbConnection.getUsers();
            result = userList;
        }};
        userAdmin.runUserReport();
        new Verifications(){{
            dbConnection.getUsers();
            times = 1;
        }};
    }

    @Test
    void runUserReport4() throws SQLException {
        User user1 = new User("Michael", "ps1234");
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < 15; i++){
            user1.setPassword(user1.getPassword()+i);
            userList.add(user1);
        }
        new Expectations(){{
            dbConnection.getUsers();
            result = userList;
        }};
        userAdmin.runUserReport();
        new Verifications(){{
            dbConnection.getUsers();
            times = 1;
        }};
    }


    @Test
    void runUserReport5() throws SQLException {

        new Expectations(){{
            dbConnection.getUsers();
            result = new SQLException();
        }};
        userAdmin.runUserReport();
        new Verifications(){{
            dbConnection.getUsers();
            times = 1;
        }};
    }

}