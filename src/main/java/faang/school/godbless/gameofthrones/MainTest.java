package faang.school.godbless.gameofthrones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void addNewHouse() {
        main.addNewHouse(new House("Targaryen", "Dragon"));

        String expected = "House[name=Targaryen, sigil=Dragon]";
        List<String> actual = main.getHouses();
        assertTrue(actual.contains(expected));
    }

    @Test
    void removeHouseByName() {
        main.removeHouseByName("Stark");

        String expected = "House[name=Stark, sigil=Direwolf]";
        List<String> actual = main.getHouses();
        assertFalse(actual.contains(expected));
    }

    @Test
    void getSigilByHouseName() {
        String expected = "Direwolf";
        String actual = main.getSigilByHouseName("Stark");
        assertEquals(expected, actual, "Return Direwolf for House Stark");

        actual = main.getSigilByHouseName("Targaryen");
        assertNull(actual, "Return null for not existed House");
    }

    @Test
    void getHouses() {
        List<String> actual = main.getHouses();

        assertEquals(3, actual.size());
        assertTrue(actual.contains("House[name=Stark, sigil=Direwolf]"));
        assertTrue(actual.contains("House[name=Lannister, sigil=Lion]"));
        assertTrue(actual.contains("House[name=Baratheon, sigil=Stag]"));
    }
}