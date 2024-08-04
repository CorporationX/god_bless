import hashmap.got.House;
import hashmap.got.Main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    @Test
    @DisplayName("Adding house to map")
    void hashMapTest_AddingHouse() {
        House testHouse = new House("Test", "Test");

        Main.addToMap(testHouse);

        assertTrue(Main.HOUSES_MAP.containsKey(testHouse.getName()));
        Main.removeFromMap(testHouse.getName());
    }

    @Test
    @DisplayName("Adding null house")
    void hashMapTest_AddingNullHouse() {
        House testHouse = null;

        assertThrows(NullPointerException.class, () -> Main.addToMap(testHouse));
    }

    @Test
    @DisplayName("Remove house from map")
    void hashMapTest_RemoveHouse() {
        House testHouse = new House("Test", "Test");

        Main.addToMap(testHouse);
        Main.removeFromMap(testHouse.getName());

        assertFalse(Main.HOUSES_MAP.containsKey(testHouse.getName()));
    }

    @Test
    @DisplayName("Remove null house from map")
    void hashMapTest_RemoveNullHouse() {
        String name = null;

        assertThrows(NullPointerException.class, () -> Main.removeFromMap(name));
    }

    @Test
    @DisplayName("Searching house in the map")
    void hashMapTest_SearchingHouse() {
        House testHouse = new House("Test", "Test");

        Main.addToMap(testHouse);
        House result = Main.searchingHouse(testHouse.getName());

        assertEquals(testHouse, result);
        Main.removeFromMap(testHouse.getName());
    }

    @Test
    @DisplayName("Searching null house in the map")
    void hashMapTest_SearchingNullHouse() {
        String name = null;

        assertThrows(NullPointerException.class, () -> Main.searchingHouse(name));
    }
}
