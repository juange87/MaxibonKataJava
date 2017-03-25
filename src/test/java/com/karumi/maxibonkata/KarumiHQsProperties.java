package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {

    @Property()
    public void theNumberOfMaxibonsLeftIsBiggerThanTwo(@From(HungryDevelopersGenerator.class) Developer developer) {
        System.out.println("Comiendo maxibons: " + developer.toString());
        KarumiHQs karumiHQs = new KarumiHQs();
        karumiHQs.openFridge(developer);
        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);
        assertTrue(maxibonsLeft >= 2);
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("");
    }
}
