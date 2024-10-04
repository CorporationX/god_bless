package game_of_thrones;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void addHouse() {
        Main.addHouse(new House("Stark", "lannister sigil"));

        assertEquals(1, Main.getHouses().size());

        Main.removeHouseByName("Stark");
    }

    @Test
    void removeHouseByName() {
        Main.addHouse(new House("Stark", "lannister sigil"));
        Main.removeHouseByName("Stark");

        assertEquals(0, Main.getHouses().size());
    }

    @Test
    void searchAndPrintHouseByName() {
        Main.addHouse(new House("Stark", "lannister sigil"));
        Main.searchAndPrintHouseByName("Stark");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.searchAndPrintHouseByName("Stark");

        assertEquals(
                "House: Stark, Sigil: lannister sigil\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        Main.removeHouseByName("Stark");
    }

    @Test
    void printAllData() {
        Main.addHouse(new House("Stark", "lannister sigil"));
        Main.searchAndPrintHouseByName("Stark");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.printAllData();

        assertEquals(
                "House: Stark, Sigil: lannister sigil\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        Main.removeHouseByName("Stark");
    }
}