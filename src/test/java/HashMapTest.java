import hashmap.got.House;
import hashmap.got.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    private static Map<String, House> housesMap;
    
    @BeforeEach
    void setUp() {
        housesMap = new HashMap<>();
    }
    @Test
    @DisplayName("Adding house to map")
    void hashMapTest_AddingHouse() {
        House testHouse = new House("Test", "Test");

        Main.addToMap(housesMap, testHouse);

        assertTrue(housesMap.containsKey(testHouse.getName()));
    }

    @Test
    @DisplayName("Adding null house")
    void hashMapTest_AddingNullHouse() {
        House testHouse = null;

        assertThrows(NullPointerException.class, () -> Main.addToMap(housesMap, testHouse));
    }

    @Test
    @DisplayName("Remove house from map")
    void hashMapTest_RemoveHouse() {
        House testHouse = new House("Test", "Test");

        Main.addToMap(housesMap, testHouse);
        assertTrue(housesMap.containsKey(testHouse.getName()));

        Main.removeFromMap(housesMap, testHouse.getName());
        assertFalse(housesMap.containsKey(testHouse.getName()));
    }

    @Test
    @DisplayName("Remove null house from map")
    void hashMapTest_RemoveNullHouse() {
        String name = null;

        assertThrows(NullPointerException.class, () -> Main.removeFromMap(housesMap, name));
    }

    @Test
    @DisplayName("Searching house in the map")
    void hashMapTest_SearchingHouse() {
        House testHouse = new House("Test", "Test");

        Main.addToMap(housesMap, testHouse);
        House result = Main.searchingHouse(housesMap, testHouse.getName());

        assertEquals(testHouse, result);
    }

    @Test
    @DisplayName("Searching null house in the map")
    void hashMapTest_SearchingNullHouse() {
        String name = null;

        assertThrows(NullPointerException.class, () -> Main.searchingHouse(housesMap, name));
    }
}
