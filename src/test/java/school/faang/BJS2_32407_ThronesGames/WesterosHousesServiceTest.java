package school.faang.BJS2_32407_ThronesGames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WesterosHousesServiceTest {
    WesterosHousesService service;
    House stark;
    House lannister;
    House baratheon;

    @BeforeEach
    void setUp() {
        service = new WesterosHousesService();

        stark = new House("Stark", "A grey direwolf on a white field");
        lannister = new House("Lannister", "A golden lion on a crimson field");
        baratheon = new House("Baratheon", "A crowned black stag on a gold field");

        service.addHouse(stark);
        service.addHouse(lannister);
        service.addHouse(baratheon);
    }

    @Test
    @DisplayName("Adding new houses info")
    void testAddHouse() {
        assertEquals(3, service.getHousesCount());
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
        service.removeHouse(lannister.getName());
        assertEquals(2, service.getHousesCount());
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