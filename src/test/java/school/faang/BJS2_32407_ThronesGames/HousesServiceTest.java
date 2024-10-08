package school.faang.BJS2_32407_ThronesGames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HousesServiceTest {
    HousesService service;
    House stark;
    House lannister;

    @BeforeEach
    void setUp() {
        service = new HousesService();

        stark = new House("Stark", "A grey direwolf on a white field");
        lannister = new House("Lannister", "A golden lion on a crimson field");
    }

    @Test
    @DisplayName("Adding new houses info")
    void testAddHouse() {
        service.addHouse(stark);
        service.addHouse(lannister);

        assertEquals(2, service.getHousesCount());
    }

    @Test
    @DisplayName("Adding null house")
    void testAddNullHouse() {
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> service.addHouse(null));
        assertEquals("House can't be null.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Removing house")
    void testRemoveHouse() {
        service.addHouse(stark);
        service.addHouse(lannister);
        service.removeHouse(lannister.getName());

        assertEquals(1, service.getHousesCount());
    }

    @Test
    @DisplayName("Removing null house")
    void testRemoveNullHouse() {
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> service.removeHouse(null));
        assertEquals("Invalid data.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Finding house with null houseName")
    void findAndPrintNullHouseName() {
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> service.findAndPrintHouse(null));
        assertEquals("Invalid data.", argumentException.getMessage());
    }
}