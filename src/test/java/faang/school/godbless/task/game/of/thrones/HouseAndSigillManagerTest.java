package faang.school.godbless.task.game.of.thrones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseAndSigillManagerTest {
    HouseAndSigillManager houseAndSigillManager;
    Object expected;
    Object actual;

    private House house1 = new House("Lannister", "Yellow Lion");
    private House house2 = new House("Baratheon", "Reindeer");
    private House house3 = new House("Stark", "Wolf");
    private House house4 = new House("Targaryen", "Dragon");

    @BeforeEach
    void setUp() {
        houseAndSigillManager = new HouseAndSigillManager();
        houseAndSigillManager.addNewHouse(house1);
        houseAndSigillManager.addNewHouse(house2);
        houseAndSigillManager.addNewHouse(house3);
        houseAndSigillManager.addNewHouse(house4);
    }

    @Test
    void testAddNewHouse() {
        expected = "Catfish";
        houseAndSigillManager.addNewHouse(new House("Tully", "Catfish"));
        actual = houseAndSigillManager.findSigillByHouseName("Tully");

        assertEquals(expected, actual);
    }

    @Test
    void testDeleteHouseByName() {
        expected = null;
        houseAndSigillManager.deleteHouseByName(house1.name());
        actual = houseAndSigillManager.findSigillByHouseName(house1.name());

        assertEquals(expected, actual);
    }

    @Test
    void testFindSigillByHouseName() {
        expected = house3.sigill();
        actual = houseAndSigillManager.findSigillByHouseName(house3.name());

        assertEquals(expected, actual);
    }

    @Test
    void testGetAllHouseAndSigill() {
        ArrayList<String> expectedList = new ArrayList<>(List.of(
                "Name: " + house1.name() + "; Sigill: " + house1.sigill(),
                "Name: " + house2.name() + "; Sigill: " + house2.sigill(),
                "Name: " + house3.name() + "; Sigill: " + house3.sigill(),
                "Name: " + house4.name() + "; Sigill: " + house4.sigill()
        ));
        List<String> actualList = houseAndSigillManager.getAllHouseAndSigill();
        Collections.sort(expectedList);
        Collections.sort(actualList);

        assertEquals(expectedList, actualList);
    }
}
