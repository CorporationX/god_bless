package faang.school.godbless.BJS2_20220;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main {
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
        DaTa daTa2 = new DaTa(2, "Значение данных 2", LocalDateTime.now());
        main.addDaTa(daTa2);
        DaTa cacheDaTa = main.getDaTaById(2);
        assertEquals(daTa2, cacheDaTa);
        assertTrue(main.getCache().containsKey(2));

    }

    @Test
    public void testGetDaTaByIdWhenInCache() {
        DaTa daTa3 = new DaTa(3, "Значение данных 3", LocalDateTime.now());
        main.addDaTa(daTa3);
        DaTa cacheDaTa1 = main.getDaTaById(3);
        assertNotNull(cacheDaTa1);
        DaTa updatedDaTa = main.getDaTaById(3);
        assertNotNull(updatedDaTa);
        assertNotEquals(cacheDaTa1.getTimestamp(), updatedDaTa.getTimestamp());
    }

    @Test
    public void testLRU() {
        DaTa daTa1 = new DaTa(1, "Значение данных 1", LocalDateTime.now());
        DaTa daTa2 = new DaTa(2, "Значение данных 2", LocalDateTime.now());
        DaTa daTa3 = new DaTa(3, "Значение данных 3", LocalDateTime.now());
        DaTa daTa4 = new DaTa(4, "Значение данных 4", LocalDateTime.now());

        main.addDaTa(daTa1);
        main.addDaTa(daTa2);
        main.addDaTa(daTa3);

        main.getDaTaById(1);
        main.getDaTaById(2);
        main.getDaTaById(3);

        assertTrue(main.getCache().containsKey(1));
        assertTrue(main.getCache().containsKey(2));
        assertTrue(main.getCache().containsKey(3));

        main.addDaTa(daTa4);
        DaTa fetchedDaTa4 = main.getDaTaById(4);
        assertNotNull(fetchedDaTa4);

        assertTrue(main.getCache().containsKey(4));
        assertFalse(main.getCache().containsKey(1));
    }
}