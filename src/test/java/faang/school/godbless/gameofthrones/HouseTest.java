package faang.school.godbless.gameofthrones;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void canAddAndDeleteHouse() {
        House.addHouse("Stark", "wolf");
        House foundHouse = House.searchHouse("Stark");
        assertEquals("Stark", foundHouse.getName());
        assertEquals("wolf", foundHouse.getSigil());
        House.deleteHouse("Stark");
        assertNull(House.searchHouse("Stark"));
    }

    @Test
    void canPrintAllHouses() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        House.addHouse("Stark", "wolf");
        House.addHouse("Lannister", "lion");
        House.addHouse("Baratheon", "deer");

        House.printAllHouses();
        String expected = "House(name=Lannister, sigil=lion)\n" +
                "House(name=Baratheon, sigil=deer)\n" +
                "House(name=Stark, sigil=wolf)\n";
        assertEquals(expected, output.toString());
        System.setOut(null);
    }
}