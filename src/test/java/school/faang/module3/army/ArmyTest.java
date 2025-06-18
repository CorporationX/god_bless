package school.faang.module3.army;

import org.junit.jupiter.api.Test;
import school.faang.module3.army.entity.Archer;
import school.faang.module3.army.entity.Mage;
import school.faang.module3.army.entity.Squad;
import school.faang.module3.army.entity.Swordsman;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmyTest {
    private static final int SWORDSMAN_DEFAULT_POWER = 30;
    private static final int ARCHER_DEFAULT_POWER = 25;
    private static final int MAGE_DEFAULT_POWER = 50;
    private static final Random RANDOM = new Random();
    private static final int ORIGIN = 1;
    private static final int BOUND = 7;
    private static final int UNIT_COUNT = 5;

    @Test
    public void testCalculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        Squad swordsmanSquad = new Squad();
        for (int i = 0; i < UNIT_COUNT; i++) {
            int power = SWORDSMAN_DEFAULT_POWER + i * RANDOM.nextInt(ORIGIN, BOUND);
            assertTrue(swordsmanSquad.addUnit(new Swordsman(power)));
            totalPower += power;
        }

        int swordsmenPower = totalPower;

        Squad archerSquad = new Squad();
        for (int i = 0; i < UNIT_COUNT; i++) {
            int power = ARCHER_DEFAULT_POWER + i + RANDOM.nextInt(ORIGIN, BOUND);
            totalPower += power;
            assertTrue(archerSquad.addUnit(new Archer(power)));
        }

        int archersPower = totalPower - swordsmenPower;

        Squad mageSquad = new Squad();
        for (int i = 0; i < UNIT_COUNT; i++) {
            int power = MAGE_DEFAULT_POWER + i + RANDOM.nextInt(ORIGIN, BOUND);
            assertTrue(mageSquad.addUnit(new Mage(power)));
            totalPower += power;
        }

        int magesPower = totalPower - swordsmenPower - archersPower;

        Army army = new Army();
        assertTrue(army.addSquad(swordsmanSquad));
        assertTrue(army.addSquad(archerSquad));
        assertTrue(army.addSquad(mageSquad));
        assertEquals(totalPower, army.calculateTotalPower());
    }
}
