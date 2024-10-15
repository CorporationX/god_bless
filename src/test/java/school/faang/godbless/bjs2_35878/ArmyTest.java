package school.faang.godbless.bjs2_35878;

import org.junit.jupiter.api.Test;
import school.faang.godbless.bjs2_35878.units.Archer;
import school.faang.godbless.bjs2_35878.units.Assassin;
import school.faang.godbless.bjs2_35878.units.Mage;
import school.faang.godbless.bjs2_35878.units.Swordsman;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {

    @Test
    void testCalculateTotalPower() {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        assertEquals(135, army.calculateTotalPower(10));
    }

    @Test
    void testCalculateTotalPowerThreadsNumber() {
        int armySize = 300;
        int unitPower = 200;
        Army army = new Army();
        for (int i = 0; i < armySize; ++i) {
            army.addUnit(new Assassin(unitPower));
        }
        int expected = unitPower * armySize;

        assertEquals(expected, army.calculateTotalPower(7));
    }
}