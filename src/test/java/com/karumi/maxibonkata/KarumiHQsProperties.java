package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {
    private KarumiHQs karumiHQs;

    @Before
    public void setUp() throws Exception {
        karumiHQs = new KarumiHQs();
    }

    @Property(trials = 1000)
    public void theNumberOfMaxibonsLeftIsBiggerThanTwo(@From(HungryDevelopersGenerator.class) Developer developer) {
        System.out.println("Comiendo maxibons: " + developer.toString());
        karumiHQs.openFridge(developer);
        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);
        assertTrue(maxibonsLeft >= 2);
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("");
    }

    @Property(trials = 1000)
    public void theNumberOfMaxibonsLeftIsBiggerThanTwoWhenGroupOfDevs(List<@From(KarumiesGenerator.class) Developer> developers) {
        System.out.println("Comiendo maxibons " + developers.size() + " developers");
        karumiHQs.openFridge(developers);
        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);
        assertTrue(maxibonsLeft >= 2);
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("");
    }
}
