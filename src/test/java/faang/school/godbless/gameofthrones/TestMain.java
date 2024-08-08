package faang.school.godbless.gameofthrones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {

    Main housesOfWesteros;

    @BeforeEach
    void init() {
        housesOfWesteros = new Main();
    }

    @Test
    @DisplayName("Main initialization")
    public void testInit() {
        Assertions.assertEquals(8, housesOfWesteros.getHouseNamesAndSigils().size());
    }

    @Test
    @DisplayName("Add house")
    public void testAddHouse() {
        housesOfWesteros.addHouse("Бастарды", new House("Бастарды", "Меч"));

        Assertions.assertEquals(9, housesOfWesteros.getHouseNamesAndSigils().size());
    }

    @Test
    @DisplayName("Delete house")
    public void testDelHouse() {
        housesOfWesteros.delHouse("Бастарды");

        Assertions.assertEquals(8, housesOfWesteros.getHouseNamesAndSigils().size());
    }

    @Test
    @DisplayName("Get Sigil")
    void getSigilTest() {
        assertEquals(housesOfWesteros.getSigil("Старки"), "Волк");
    }

    @Test
    @DisplayName("Get House Names and Sigils")
    void testGetHouseNamesAndSigils() {
        assertTrue(housesOfWesteros.getHouseNamesAndSigils().contains("name: Талли, sigil: Рыба"));
    }
}
