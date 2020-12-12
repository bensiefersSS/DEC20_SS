package com.ss.basics.line;

import static org.junit.Assert.*;
/*
 Author: Ben Siefers
 Date: 12/12/2020
 Purpose: basics of unit testing
 */
public class LineTest {
    Line l1 = new Line(0,0, 1,1);
    Line l2 = new Line(3,5, 10,-21);
    Line l3 = new Line(-1, -1, 0,0);
    @org.junit.Test
    public void getSlope() {

        assertEquals(1.0000, l1.getSlope(), .0001);
        assertEquals(-3.7142, l2.getSlope(), .0001);
    }

    @org.junit.Test
    public void getDistance() {
        assertEquals(1.4142, l1.getDistance(), .0001);
        assertEquals(26.9258, l2.getDistance(), .0001);
    }

    @org.junit.Test
    public void parallelTo() {
        assert(!l1.parallelTo(l2));
        assert(!l2.parallelTo(l1));

        assert(l1.parallelTo(l3));
        assert(l3.parallelTo(l1));
    }
}