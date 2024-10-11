package school.faang.game.of.thrones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {

    private GameOfThrones gameOfThrones;
    private House house1;
    private House house2;

    @BeforeEach
    public void setUp() {
        house1 = new House("House 1", "Sigil 1");
        house2 = new House("House 2", "Sigil 2");

        gameOfThrones = new GameOfThrones();
        gameOfThrones.addHouse(house1);
        gameOfThrones.addHouse(house2);
    }

    @Test
    public void addHouseTest() {
        House house3 = new House("House 3", "Sigil 3");
        gameOfThrones.addHouse(house3);
        House retrievedHouse = gameOfThrones.findHouse("House 3");
        assertEquals("Sigil 3", retrievedHouse.getSigil());
    }

    @Test
    public void deleteHouseTest() {
        gameOfThrones.deleteHouse("House 2");
        House deletedHouse = gameOfThrones.findHouse("House 2");
        assertNull(deletedHouse);
    }

    @Test
    public void printAllHousesTest() {
        gameOfThrones.printAllHouses();
    }
}
