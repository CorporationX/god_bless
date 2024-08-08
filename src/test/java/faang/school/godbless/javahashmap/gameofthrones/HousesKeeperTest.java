package faang.school.godbless.javahashmap.gameofthrones;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HousesKeeperTest {

    private static final String STARK_HOUSENAME = "Stark";
    private static final String LANNISTER_HOUSENAME = "Lannister";
    private static final String BARATHEON_HOUSENAME = "Baratheon";
    private static final House STARK_HOUSE = new House(STARK_HOUSENAME, "Direwolf");
    private static final House LANNISTER_HOUSE = new House(LANNISTER_HOUSENAME, "Lion");
    private static final House BARATHEON_HOUSE = new House(BARATHEON_HOUSENAME, "Deer");

    private static final String LANNISTER_INFO = "House(name=Lannister, sigil=Lion)\r\n";
    private static final String ALL_HOUSES_INFO = """
            House(name=Lannister, sigil=Lion)\r
            House(name=Baratheon, sigil=Deer)\r
            House(name=Stark, sigil=Direwolf)\r
            """;
    private static final String HOUSE_NOT_FOUND_INFO = "House not found\r\n";

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Test
    void testAddHouse() {
        HousesKeeper housesKeeper = getFilledHousesKeeper();

        HashMap<String, House> houses = housesKeeper.getDeepCopyOfHouses();
        assertEquals(3, houses.size());
        assertEquals(STARK_HOUSE, houses.get(STARK_HOUSENAME));
        assertEquals(LANNISTER_HOUSE, houses.get(LANNISTER_HOUSENAME));
        assertEquals(BARATHEON_HOUSE, houses.get(BARATHEON_HOUSENAME));
    }

    @Test
    void testRemoveHouse() {
        HousesKeeper housesKeeper = getFilledHousesKeeper();

        housesKeeper.removeHouse(LANNISTER_HOUSENAME);

        HashMap<String, House> houses = housesKeeper.getDeepCopyOfHouses();
        assertEquals(2, houses.size());
        assertEquals(STARK_HOUSE, houses.get(STARK_HOUSENAME));
        assertNull(houses.get(LANNISTER_HOUSENAME));
        assertEquals(BARATHEON_HOUSE, houses.get(BARATHEON_HOUSENAME));
    }

    @Test
    void testRemoveHouseThatNotExist() {
        HousesKeeper housesKeeper = new HousesKeeper();
        housesKeeper.addHouse(STARK_HOUSE);
        housesKeeper.addHouse(BARATHEON_HOUSE);

        housesKeeper.removeHouse(LANNISTER_HOUSENAME);

        HashMap<String, House> houses = housesKeeper.getDeepCopyOfHouses();
        assertEquals(2, houses.size());
        assertEquals(STARK_HOUSE, houses.get(STARK_HOUSENAME));
        assertNull(houses.get(LANNISTER_HOUSENAME));
        assertEquals(BARATHEON_HOUSE, houses.get(BARATHEON_HOUSENAME));
    }

    @Test
    void testFindAndPrintHouse() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        HousesKeeper housesKeeper = getFilledHousesKeeper();

        housesKeeper.findAndPrintHouse(LANNISTER_HOUSENAME);

        assertEquals(LANNISTER_INFO, outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void testFindAndPrintHouseNotExisted() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        HousesKeeper housesKeeper = new HousesKeeper();
        housesKeeper.addHouse(STARK_HOUSE);
        housesKeeper.addHouse(BARATHEON_HOUSE);

        housesKeeper.findAndPrintHouse(LANNISTER_HOUSENAME);

        assertEquals(HOUSE_NOT_FOUND_INFO, outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void testPrintAllHousesInfo() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        HousesKeeper housesKeeper = getFilledHousesKeeper();

        housesKeeper.printAllHousesInfo();

        assertEquals(ALL_HOUSES_INFO, outContent.toString());
        System.setOut(originalOut);
    }

    private HousesKeeper getFilledHousesKeeper() {
        HousesKeeper housesKeeper = new HousesKeeper();
        housesKeeper.addHouse(STARK_HOUSE);
        housesKeeper.addHouse(LANNISTER_HOUSE);
        housesKeeper.addHouse(BARATHEON_HOUSE);
        return housesKeeper;
    }
}