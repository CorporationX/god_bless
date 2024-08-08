import faang.school.godbless.BJS2_19915.House;
import faang.school.godbless.BJS2_19915.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseHashTest {
    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testAddNewHouse() {
        House newHouse = new House("NewHouse", "   /\\ \n  /  \\ \n /____\\\n");
        main.addNewHouse("NewHouse", newHouse);

        assertEquals(newHouse, main.housesOfWesteros.get("NewHouse"));
    }

    @Test
    void testRemoveHouseByName() {
        main.removeHouseByName("Baratheon");
        assertEquals(null, main.housesOfWesteros.get("Baratheon"));
    }
}
