package faang.school.godbless.BJS2_19746;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Test
    void addHouseTest() {
        assertEquals(4, main.getAllHouses().size());
        main.addHouse(new House("Test", "Test sigil"));
        assertEquals(5, main.getAllHouses().size());
        assertEquals("Test sigil", main.getSigil("Test"));
    }

    @Test
    void deleteHouseTest() {
        assertEquals(4, main.getAllHouses().size());

        boolean result = main.deleteHouse("Lanister");

        assertEquals(3, main.getAllHouses().size());
        assertTrue(result);
    }

    @Test
    void deleteNotExistingHouseTest() {
        assertEquals(4, main.getAllHouses().size());

        boolean result = main.deleteHouse("No house");

        assertEquals(4, main.getAllHouses().size());
        assertFalse(result);
    }

    @Test
    void getSigilTest() {
        assertEquals(main.getSigil("Stark"), "Frog");
    }

    @Test
    void getAllHousesTest() {
        assertEquals(4, main.getAllHouses().size());
        assertTrue(main.getAllHouses().contains("House name: Stark, Sigil: Frog"));
        assertTrue(main.getAllHouses().contains("House name: Lanister, Sigil: Tiger"));
    }
}