package faang.school.godbless.heroes.sprint3;

import faang.school.godbless.heroes.sprint3.creature.Archer;
import faang.school.godbless.heroes.sprint3.creature.Mage;
import faang.school.godbless.heroes.sprint3.creature.Swordsman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmyTest {

    @Test
    void testCalculateTotalPower() {
        Army army = new Army();
        army.addUnit(new Archer(2));
        army.addUnit(new Swordsman(3));
        army.addUnit(new Swordsman(2));
        army.addUnit(new Mage(10));

        Assertions.assertEquals(320, army.calculateTotalPower());
    }
}
