package faang.school.godbless.distributed_army;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {
    Army army;

    @BeforeEach
    void setUp() {
        army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4
    }

    @Test
    void test_calculationTotalPowerOfArmy() {
        int totalPower = army.calculateTotalPower();
        assertEquals(135, totalPower);
    }
}