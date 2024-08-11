package faang.school.godbless.game.of.trones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testAdd() {
        int mapSize = Main.houseMap.size();
        Main.add(new House("Tallis", "Fish"));

        Assertions.assertEquals(mapSize + 1, Main.houseMap.size());
        Assertions.assertTrue(Main.houseMap.containsKey("Tallis"));
    }

    @Test
    void testRemove() {
        int mapSize = Main.houseMap.size();
        Assertions.assertTrue(Main.houseMap.containsKey("Boltons"));
        Main.remove("Boltons");

        Assertions.assertEquals(mapSize - 1, Main.houseMap.size());
        Assertions.assertFalse(Main.houseMap.containsKey("Boltons"));
    }

    @Test
    void addWithException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Main.add(null));
        Assertions.assertEquals("House can't be null", exception.getMessage());
    }

    @Test
    void removeWithException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Main.remove(null));
        Assertions.assertEquals("House name can't be null or empty", exception.getMessage());
    }
}
