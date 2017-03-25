package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {

    private Chat mockChat;
    private KarumiHQs karumiHQs;

    @Before
    public void setUp() throws Exception {
        mockChat = mock(Chat.class);
        karumiHQs = new KarumiHQs(mockChat);
    }

    @Property(trials = 1000)
    public void theNumberOfMaxibonsLeftIsBiggerThanTwo(@From(HungryDevelopersGenerator.class) Developer developer) {
        System.out.println("Comiendo maxibons: " + developer.toString());
        karumiHQs.openFridge(developer);
        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);
        assertTrue(maxibonsLeft >= 2);

        showDelimeterForTestExecution();
    }

    @Property(trials = 1000)
    public void theNumberOfMaxibonsLeftIsBiggerThanTwoWhenGroupOfDevs(
            List<@From(KarumiesGenerator.class) Developer> developers) {
        System.out.println("Comiendo maxibons " + developers.size() + " developers");
        karumiHQs.openFridge(developers);

        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);
        assertTrue(maxibonsLeft >= 2);

        showDelimeterForTestExecution();
    }

    @Property(trials = 1000)
    public void theNumberOfMaxibonsLeftIsBiggerThanTwoAndSendMessage(
            @From(HungryDevelopersGenerator.class) Developer developer) {
        System.out.println("Comiendo maxibons: " + developer.toString());
        karumiHQs.openFridge(developer);

        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);
        assertTrue(maxibonsLeft >= 2);

        verify(mockChat).sendMessage("Hi guys, I'm " + developer.getName() + ". We need more maxibons!");
        showDelimeterForTestExecution();
    }

    @Property(trials = 1000)
    public void theNumberOfMaxibonsLeftIsBiggerThanTwoAndSendMessageWhenNotSoHungryDevs(
            @From(NotSoHungryDevelopersGenerator.class) Developer developer) {
        System.out.println("Comiendo maxibons: " + developer.toString());
        karumiHQs.openFridge(developer);

        final int maxibonsLeft = karumiHQs.getMaxibonsLeft();
        System.out.println("MAXIBONS LEFT: " + maxibonsLeft);

        assertTrue(maxibonsLeft >= 2);
        verifyNoMoreInteractions(mockChat);

        showDelimeterForTestExecution();
    }

    private void showDelimeterForTestExecution() {
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("");
    }
}
