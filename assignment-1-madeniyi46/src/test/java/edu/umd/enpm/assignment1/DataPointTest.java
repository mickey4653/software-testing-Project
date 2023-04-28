package edu.umd.enpm.assignment1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DataPointTest {
    private DataPoint dp1;
    private DataPoint dp2;
    private DataPoint dp3;
    private DataPoint dp4;
    @BeforeEach
    void setUp() {
    dp1= new DataPoint(10,20);
    dp2 = new DataPoint(10,20);
    dp3= new DataPoint(2,8);
    dp4 = new DataPoint(2,6);
    }

    @AfterEach
    void tearDown() {
        dp1 = null;
        dp2 = null;
        dp3 = null;
        dp4 = null;
    }

    @Test
    void testEquals() {
//for constructed objects
        assertEquals(dp1,dp2);

        // for false case
       assertNotEquals(dp3,dp4);
    }

    @Test
    void testHashCode() {
        //for constructed objects
        assertEquals(dp1.hashCode(), dp2.hashCode());
  //testing for false case
        assertNotEquals(dp3.hashCode(),dp4.hashCode());
    }

    @Test
    void testToString() {
        //successful case
        assertEquals(dp1.toString(),"10, 20");

        //false case when space is removed
        assertNotEquals(dp1.toString(), "10,20");
        assertNotNull(dp1);
    }

    @Test
    void testGetXValue() {
        assertEquals(dp1.getXValue(),10);
        assertEquals(dp3.getXValue(),2);
        assertNotEquals(dp4.getXValue(),6);
        assertNotNull(dp3);
        assertNotNull(dp4);


    }
    @Test
    void testSetXValue() {
        dp1.setXValue(15);
        assertEquals(dp1.getXValue(),15);

        dp1.setXValue(24);
        assertNotEquals(dp1.getXValue(), 12);
    }



    @Test
    void testGetYValue() {
        assertEquals(dp1.getYValue(),20);
        assertEquals(dp3.getYValue(),8);
        assertEquals(dp4.getYValue(),6);
        assertNotNull(dp1);
        assertNotNull(dp3);
        assertNotNull(dp4);

    }
    @Test
    void testSetYValue() {
        dp1.setValue(18);
        assertEquals(dp1.getYValue(),18);

        //False case for when comparing the value that is not set
        dp1.setValue(40);
        assertNotEquals(dp1.getXValue(), 18);
    }
    @Test
    void testCompareTo() {
        assertEquals(0,dp1.compareTo(dp2));
        assertEquals(8,dp2.compareTo(dp3));
        assertNotEquals(0,dp3.compareTo(dp4));
    }


    @BeforeAll
    static void setUpClass(){
        System.out.println("Before Class Set Up...");
    }
    @AfterAll
    static void tearDownClass(){
        System.out.println("After Class Tear Down...");
    }
}
