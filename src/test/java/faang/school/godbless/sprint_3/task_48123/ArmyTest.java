package faang.school.godbless.sprint_3.task_48123;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArmyTest {

    private static final Unit CORRECT_UNIT_1 = new Archer(25);
    private static final Unit CORRECT_UNIT_2 = new Swordsman(40);
    private static final Unit CORRECT_UNIT_3 = new Mage(50);
    private static final Unit CORRECT_UNIT_4 = new Mage(20);

    private static final Unit INCORRECT_UNIT = new Archer(0);

    private static final List<Unit> UNITS = List.of(CORRECT_UNIT_1, CORRECT_UNIT_2, CORRECT_UNIT_3, CORRECT_UNIT_4);

    private final Army army = new Army();

    @Test
    void testAddUnit() {
        assertDoesNotThrow(() -> army.addUnit(CORRECT_UNIT_1));
        assertThrows(IllegalArgumentException.class, () -> army.addUnit(INCORRECT_UNIT));
    }

    @Test
    void testCalculateTotalPower() {
        int totalPower = 0;
        for (Unit unit : UNITS) {
            totalPower += unit.getPower();
        }
        UNITS.forEach(army::addUnit);
        assertEquals(totalPower, army.calculateTotalPower());
    }
}