package school.faang.sprint_3.task_47765;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmyTest {
    Army army;

    @BeforeEach
    void setUpArmy() {
        army = new Army();
    }

    @Test
    void testCalculateTotalPowerBaseCase() {
        army.addHero(new Archer(25));
        army.addHero(new Swordsman(70));
        army.addHero(new Mage(50));
        army.addHero(new Mage(40));
        army.addHero(new Archer(25));
        army.addHero(new Swordsman(70));
        army.addHero(new Mage(50));
        army.addHero(new Mage(40));
        army.addHero(new Archer(25));
        army.addHero(new Swordsman(70));
        army.addHero(new Mage(50));
        army.addHero(new Mage(40));
        army.addHero(new Archer(25));
        army.addHero(new Swordsman(70));
        army.addHero(new Mage(50));
        army.addHero(new Mage(40));
        var expect = 740;

        var actual = army.calculateTotalPower();

        assertEquals(expect, actual);
    }

    @Test
    void testCalculateTotalPowerEmptyListHeroes() {
        int expect = 0;

        int actual = army.calculateTotalPower();

        assertEquals(expect, actual);
    }
}
