package faang.school.godbless.task.hashmap.game.of.thrones;

import faang.school.godbless.task.hashmap.game.thrones.House;
import faang.school.godbless.task.hashmap.game.thrones.HouseAndSigillManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Add new house")
    void testAddNewHouse() {
        houseAndSigillManager.addNewHouse(new House("Tully", "Catfish"));
        houseAndSigillManager.printSigillByHouseName("Tully");
    }

    @Test
    @DisplayName("Add new house as null")
    void testAddNewHouseNullValue() {
        assertThrows(NullPointerException.class, () -> houseAndSigillManager.addNewHouse(null));
    }

    @Test
    @DisplayName("Delete house by name")
    void testDeleteHouseByName() {
        String name = house1.name();
        houseAndSigillManager.deleteHouseByName(name);
        assertThrows(NoSuchElementException.class,
                () -> houseAndSigillManager.printSigillByHouseName(name));
    }

    @Test
    @DisplayName("Print sigill by house name")
    void testPrintSigillByHouseName() {
        houseAndSigillManager.printSigillByHouseName(house3.name());
    }

    @Test
    @DisplayName("Get all house and sigill")
    void testGetAllHouseAndSigill() {
        houseAndSigillManager.printAllHouseAndSigill();
    }
}
