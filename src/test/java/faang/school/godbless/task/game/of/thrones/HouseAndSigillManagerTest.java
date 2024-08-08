package faang.school.godbless.task.game.of.thrones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HouseAndSigillManagerTest {
    private final House house1 = new House("Lannister", "Yellow Lion");
    private final House house2 = new House("Baratheon", "Reindeer");
    private final House house3 = new House("Stark", "Wolf");
    private final House house4 = new House("Targaryen", "Dragon");

    private HouseAndSigillManager houseAndSigillManager;

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
        houseAndSigillManager.addNewHouse(new House("Tully", "Catfish"));
        houseAndSigillManager.findSigillByHouseName("Tully");
    }

    @Test
    void testAddNewHouseNullValue() {
        assertThrows(NoSuchElementException.class, () -> houseAndSigillManager.addNewHouse(null));
    }

    @Test
    void testDeleteHouseByName() {
        String name = house1.name();
        houseAndSigillManager.deleteHouseByName(name);
        assertThrows(NoSuchElementException.class,
                () -> houseAndSigillManager.findSigillByHouseName(name));
    }

    @Test
    void testFindSigillByHouseName() {
        houseAndSigillManager.findSigillByHouseName(house3.name());
    }

    @Test
    void testGetAllHouseAndSigill() {
        houseAndSigillManager.printAllHouseAndSigill();
    }
}
