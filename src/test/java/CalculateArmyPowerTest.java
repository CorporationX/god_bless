import faang.school.godbless.BJS2_10938.Archer;
import faang.school.godbless.BJS2_10938.Army;
import faang.school.godbless.BJS2_10938.Mage;
import faang.school.godbless.BJS2_10938.Swordsman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateArmyPowerTest {

    @Test
    void calculateArmyPowerTest() throws InterruptedException {
        Army army = new Army();

        army.addUnitToArmy(new Archer(), 10);
        army.addUnitToArmy(new Swordsman(), 10);
        army.addUnitToArmy(new Mage(), 10);

        int res = army.calculateTotalArmyPower();

        assertEquals(300, res);
    }
}
