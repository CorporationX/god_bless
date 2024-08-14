package faang.school.godbless.BJS2_20220;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private DaTa daTa;

    @BeforeEach
    void setUp() {
        main = new Main();
        daTa = new DaTa(1, "Значение данных 1", LocalDateTime.now());
        main.addDaTa(daTa);
    }

    @Test
    void testAddDaTa() {
        assertTrue(main.getDaTaMap().containsKey(1));
        assertEquals("Значение данных 1", main.getDaTaMap().get(1).getValue());

    }

    @Test
    void testGetDaTaByIdWhenOutCache() {
        DaTa daTaTwo = new DaTa(2, "Значение данных 2", LocalDateTime.now());
        main.addDaTa(daTaTwo);
        DaTa cacheDaTa = main.getDaTaById(2);
        assertEquals(daTaTwo, cacheDaTa);
        assertTrue(main.getCache().containsKey(2));

    }

    @Test
    public void testGetDaTaByIdWhenInCache() {
        DaTa daTaThree = new DaTa(3, "Значение данных 3", LocalDateTime.now());
        main.addDaTa(daTaThree);
        DaTa cacheDaTaOne = main.getDaTaById(3);
        assertNotNull(cacheDaTaOne);
        DaTa updatedDaTa = main.getDaTaById(3);
        assertNotNull(updatedDaTa);
        assertNotEquals(cacheDaTaOne.getTimestamp(), updatedDaTa.getTimestamp());
    }

    @Test
    public void testLRU() {
        DaTa daTaOne = new DaTa(1, "Значение данных 1", LocalDateTime.now());
        DaTa daTaTwo = new DaTa(2, "Значение данных 2", LocalDateTime.now());
        DaTa daTaThree = new DaTa(3, "Значение данных 3", LocalDateTime.now());
        DaTa daTaFour = new DaTa(4, "Значение данных 4", LocalDateTime.now());

        main.addDaTa(daTaOne);
        main.addDaTa(daTaTwo);
        main.addDaTa(daTaThree);

        main.getDaTaById(1);
        main.getDaTaById(2);
        main.getDaTaById(3);

        assertTrue(main.getCache().containsKey(1));
        assertTrue(main.getCache().containsKey(2));
        assertTrue(main.getCache().containsKey(3));

        main.addDaTa(daTaFour);
        DaTa cachedDaTa = main.getDaTaById(4);
        assertNotNull(cachedDaTa);

        assertTrue(main.getCache().containsKey(4));
        assertFalse(main.getCache().containsKey(1));
    }
}