package school.faang.BJS2_32428;

import org.junit.jupiter.api.Test;
import school.faang.firstStream.BJS2_32428.House;
import school.faang.firstStream.BJS2_32428.Main;

import static org.junit.jupiter.api.Assertions.*;

public class HousesTest {
    @Test
    void testAddHousePositive() {
        House house = new House("Stark", "A grey dire wolf on a white field");

        Main.addHouse(house);
        assertEquals(house.getSigil(), Main.findHouse(house.getName()));
    }

    @Test
    void testAddHouseNegative() {
        assertThrows(IllegalArgumentException.class, () -> Main.addHouse(null));
        assertThrows(IllegalArgumentException.class, () ->
                Main.addHouse(new House("", "A grey dire wolf on a white field")));
        assertThrows(IllegalArgumentException.class, () ->
                Main.addHouse(new House("Stark", "")));
    }

    @Test
    void testRemoveHouse() {
        House house = new House("Stark", "A grey dire wolf on a white field");

        Main.addHouse(house);
        Main.removeHouse(house.getName());

        assertNull(Main.findHouse(house.getName()));
    }

    @Test
    void findHouse() {
        House house = new House("Stark", "A grey dire wolf on a white field");

        Main.addHouse(house);

        assertEquals(house.getSigil(), Main.findHouse(house.getName()));
    }
}
