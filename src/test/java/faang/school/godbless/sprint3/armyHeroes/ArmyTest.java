package faang.school.godbless.sprint3.armyHeroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {
    private Army army;
    private int totalPower;

    @BeforeEach
    void setUp() {
        army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        totalPower = army.calculateTotalPower();
    }

    @Test
    void calculateTotalPower() {
        int expected = 405;
        assertEquals(totalPower, expected);
    }

    @Test
    void calculateArcherPower() {
        int archerPower = army.getUnitPowers().get("Archer");
        int expected = 75;
        assertEquals(archerPower, expected);
    }

    @Test
    void calculateSwordsmanPower() {
        int swordsmanPower = army.getUnitPowers().get("Swordsman");
        int expected = 120;
        assertEquals(swordsmanPower, expected);
    }

    @Test
    void calculateMagePower() {
        int magePower = army.getUnitPowers().get("Mage");
        int expected = 210;
        assertEquals(magePower, expected);
    }
}