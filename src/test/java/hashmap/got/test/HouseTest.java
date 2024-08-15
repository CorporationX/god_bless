package hashmap.got.test;

import hashmap.got.House;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseTest {
    @Test
    @DisplayName("Create house with null name")
    void houseTest_createNullNameHouse() {
        assertThrows(NullPointerException.class, () -> new House(null, "Test"));
    }

    @Test
    @DisplayName("Create house with null sigil")
    void houseTest_createNullSigilHouse() {
        assertThrows(NullPointerException.class, () -> new House("Test", null));
    }
}
