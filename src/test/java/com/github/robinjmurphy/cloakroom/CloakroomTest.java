package com.github.robinjmurphy.cloakroom;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CloakroomTest {

    private Cloakroom<String> cloakroom;

    @Before
    public void setUp() {
        cloakroom = new Cloakroom<String>();
    }

    @Test
    public void checkInReturnsToken() {
        String line1 = "It was the best of times, it was the worst of times...";
        Token token = cloakroom.checkIn(line1);
        assertNotNull(token);
    }

    @Test
    public void pickUpReturnsTheOriginalObject() {
        String line2 = "...it was the age of wisdom, it was the age of foolishness...";
        Token token = cloakroom.checkIn(line2);
        String checkedInObject = cloakroom.pickUp(token);
        assertEquals(line2, checkedInObject);
    }

    @Test
    public void pickUpWithAKeyReturnsTheOriginalObject() {
        String line3 = "...it was the epoch of belief...";
        cloakroom.checkIn("line3", line3);
        String checkedInObject = cloakroom.pickUp("line3");
        assertEquals(line3, checkedInObject);
    }

}
