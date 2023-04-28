package edu.umd.enpm.assignment1;

import org.junit.jupiter.api.*;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DataSetTest {
    private DataPoint dp1;
    private DataPoint dp2;
    private DataPoint dp3;
    private DataPoint dp4;
    private DataSet ds1;
    private DataSet ds2;

    @BeforeEach
    void setUp() {
        dp1 = new DataPoint(10,20);
        dp2 = new DataPoint(50,80);
        dp3 = new DataPoint(10,20);
        dp4 = new DataPoint(50,80);
        ds1 = new DataSet();
        ds2 = new DataSet();
        ds1.addPoint(this.dp1);
        ds1.addPoint(this.dp2);
        ds2.addPoint(this.dp3);
        ds2.addPoint(this.dp4);
    }

    @AfterEach
    void tearDown() {
        dp1 = null;
        dp2 = null;
        dp3 = null;
        dp4 = null;
        ds1 = null;
        ds2 = null;
    }

    @Test
    void testGetDataPoints(){
        assertEquals(ds1.getDataPoints(),ds2.getDataPoints());

        DataPoint newDP1 = new DataPoint(4, 5);
        ds2.addPoint(newDP1);
        assertNotEquals(ds1.getDataPoints(), ds2.getDataPoints());
        assertNotNull(ds1);
        assertNotNull(ds2);
    }

    @Test
    void testAddPoint(){
        ds1.addPoint(this.dp2);
        ds2.addPoint(this.dp4);
        assertEquals(ds1.getDataPoints(), ds2.getDataPoints());

        //testing if values are sorted
        assertEquals("10, 20 50, 80 50, 80",ds1.toString());
        assertEquals("10, 20 50, 80 50, 80",ds2.toString());
        assertTrue(ds2.getDataPoints().get(0).compareTo(ds2.getDataPoints().get(1)) < 0);

    }

    @Test
    void testSubsumes(){
        DataPoint dpT1 = new DataPoint(120, 150);
        DataPoint dpT2 = new DataPoint(120, 150);

        DataSet dsT1 = new DataSet();
        DataSet dsT2 = new DataSet();
        dsT1.addPoint(dpT1);
        dsT1.addPoint(dpT2);

        //Success case of subsuming
        assertTrue(dsT1.subsumes(dsT2));

        dpT1.setXValue(75);
        dsT2.addPoint(dpT1);
        dsT2.addPoint(dpT2);

        //Failed Case
        assertFalse(dsT2.subsumes(ds1));
        assertNotNull(dsT1);
        assertNotNull(dsT2);


    }

    @Test
    void testEquals() {
        DataPoint newDpT1 = new DataPoint(80, 130);
        assertEquals(ds1, ds2);

        //Failed case
        ds1.addPoint(newDpT1);
        assertNotEquals(ds1, ds2);
        assertNotNull(ds1);
        assertNotNull(ds2);
    }

    @Test
    void testHashCode() {
        assertEquals(ds1.hashCode(), ds2.hashCode());

        DataPoint newDP = new DataPoint(40, 60);
        ds1.addPoint(newDP);
        assertNotEquals(ds1.hashCode(), ds2.hashCode());

        ds2.addPoint(newDP);

        HashSet<DataSet> hs = new HashSet<DataSet>();
        HashSet<DataSet> hs2 = new HashSet<DataSet>();
        hs.add(ds1);
        hs2.add(ds2);
        assertEquals(hs.hashCode(), hs2.hashCode());

        DataPoint newDP1 = new DataPoint(40, 60);
        ds1.addPoint(newDP1);
        assertNotEquals(hs.hashCode(), hs2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals(ds1.toString(),"10, 20 50, 80");
        assertNotEquals(ds1.toString(), "10, 50 20, 80");
        assertNotNull(ds1);
        assertNotNull(ds2);
    }

    @Test
    void testCompareTo() {
        assertEquals(0,ds1.compareTo(ds2));

        DataPoint tempDP1 = new DataPoint(65, 85);
        ds1.addPoint(tempDP1);
        assertEquals(1,ds1.compareTo(ds2));
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