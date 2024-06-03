package faang.school.godbless.game_of_thrones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testListHouses() {
        System.out.println("Test List Houses in Westeros");
        new Main().listHouses();
    }

    @Test
    public void testAddHouse() {
        Main westerosHouses = new Main();
        System.out.println("Test Add House");
        westerosHouses.listHouses();
        westerosHouses.addHouse(new House("Lannister", "Lion"));
        westerosHouses.listHouses();
    }

    @Test
    public void testRemoveHouse() {
        Main westerosHouses = new Main();
        System.out.println("Test Remove House");
        westerosHouses.listHouses();
        westerosHouses.removeHouse("Stark");
        westerosHouses.listHouses();
    }

    @Test
    public void testGetSigil() {
        Main westerosHouses = new Main();
        System.out.println("Test get sigil");
        System.out.println(westerosHouses.getSigil("Stark"));
    }
}