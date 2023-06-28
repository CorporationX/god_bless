package distributed_army;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    void testCalculateTotalPower() {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        assertEquals(135, totalPower);
    }

    @Test
    public void testCalculateTotalPowerWithNoUnits() {
        Army army = new Army();

        int totalPower = army.calculateTotalPower();
        Assertions.assertEquals(0, totalPower);
    }
}