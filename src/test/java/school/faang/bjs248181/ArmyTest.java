package school.faang.bjs248181;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs248181.characters.Archer;
import school.faang.bjs248181.characters.Mage;
import school.faang.bjs248181.characters.Swordsman;

class ArmyTest {

    @Test
    public void calculateTotalPowerTest() {
        Army army = new Army();
        for (int i = 0; i < 100; i++) {
            army.addUnit(new Archer());
            army.addUnit(new Swordsman());
            army.addUnit(new Mage());
        }

        int totalPower = army.calculateTotalPower();
        Assertions.assertEquals(17500, totalPower);
    }
}