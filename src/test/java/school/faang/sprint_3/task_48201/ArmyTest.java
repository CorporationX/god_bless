package school.faang.sprint_3.task_48201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    void testAddCharacter() {
        Army army = new Army();
        Archer archer = new Archer(25);
        army.addCharacter(archer);

        assertEquals(1, army.getHeroes().size());
        assertEquals(25, army.getHeroes().get(0).getPower());
    }

    @Test
    void testCalculateTotalPower() throws InterruptedException {
        Army army = new Army();
        army.addCharacter(new Archer(25));
        army.addCharacter(new Swordsman(40));
        army.addCharacter(new Mage(50));

        int totalPower = army.calculateTotalPower();
        assertEquals(115, totalPower);
    }

    @Test
    void testCalculateTotalPowerWithNoCharacters() throws InterruptedException {
        Army army = new Army();
        int totalPower = army.calculateTotalPower();
        assertEquals(0, totalPower);
    }
}
