package faang.school.godbless.BJS211122;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmyTest {
    @Test
    void testCalculateTotalPower() {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(35));
        army.addUnit(new Mage(10));

        int actual = army.calculateTotalPower();
        int expected = 25 + 35 + 10 * 2;

        assertEquals(expected, actual);
    }
}
