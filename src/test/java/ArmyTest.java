import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs248536.Archer;
import school.faang.bjs248536.Army;
import school.faang.bjs248536.Mage;
import school.faang.bjs248536.Swordsman;
import school.faang.bjs248536.Unit;

import java.util.List;

public class ArmyTest {

    @Test
    public void testAddUnit() {
        Army army = new Army();
        Unit unit = new Archer(50);

        army.addUnit(unit);

        List<Unit> units = army.getUnits();
        Assertions.assertNotNull(units, "The list of units should not be null");
        Assertions.assertEquals(1, units.size(), "The list of units should be contain exactly one unit");
        Assertions.assertTrue(units.contains(unit), "The list of units should contain the added unit");
    }

    @Test
    public void testMultiAddUnit() {
        Army army = new Army();
        Unit unit1 = new Archer(50);
        Unit unit2 = new Mage(40);
        Unit unit3 = new Swordsman(10);

        army.addUnit(unit1);
        army.addUnit(unit2);
        army.addUnit(unit3);

        List<Unit> units = army.getUnits();
        Assertions.assertNotNull(units, "The list of units should not be null");
        Assertions.assertEquals(3, units.size(), "The list of units should be contain exactly one unit");
        Assertions.assertTrue(units.contains(unit1), "The list of units should contain the added unit");
        Assertions.assertTrue(units.contains(unit2), "The list of units should contain the added unit");
        Assertions.assertTrue(units.contains(unit3), "The list of units should contain the added unit");
    }

    @Test
    public void testAddNullUnitThrows() {
        Army army = new Army();
        Assertions.assertThrows(IllegalArgumentException.class, () -> army.addUnit(null),
                "Adding null should be throw an exception");
    }
}
