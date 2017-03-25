package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {
    private static final String ANY_NAME = "Pedro";
    private static final int ANY_NUMBER = 1;

    @Property
    public void theNumberOfMaxibonsAssignedIsPositiveOrZero(int numberOfMaxibons) {
        System.out.println(numberOfMaxibons);
        Developer developer = new Developer(ANY_NAME, numberOfMaxibons);
        System.out.println(developer.toString());
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("");
    }

    @Test
    public void testExpectedMaxibons() {
        assertEquals(1, Karumies.ALBERTO.getNumberOfMaxibonsToGrab());
        assertEquals(3, Karumies.PEDRO.getNumberOfMaxibonsToGrab());
        assertEquals(0, Karumies.DAVIDE.getNumberOfMaxibonsToGrab());
        assertEquals(2, Karumies.SERGIO.getNumberOfMaxibonsToGrab());
        assertEquals(1, Karumies.JORGE.getNumberOfMaxibonsToGrab());
    }
}
