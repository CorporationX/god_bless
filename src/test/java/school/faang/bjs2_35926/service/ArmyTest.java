package school.faang.bjs2_35926.service;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_35926.model.Archer;
import school.faang.bjs2_35926.model.Fighter;
import school.faang.bjs2_35926.model.Mage;
import school.faang.bjs2_35926.model.Swordsman;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {
    private final Army army = new Army();

    @Test
    void calculateTotalPower() {
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));

        int correctResult = 115;
        int result = army.calculateTotalPower();

        assertEquals(correctResult, result);
        army.getFighters().clear();
    }

    @Test
    void addUnit() {
        Archer archer = new Archer(25);
        List<Fighter> correctResult = List.of(archer);

        army.addUnit(archer);

        List<Fighter> result = army.getFighters();
        assertEquals(correctResult, result);
    }
}