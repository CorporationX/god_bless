package school.faang.bjs_48017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {

    @Test
    void calculateTotalPower() {
        Army army = new Army();
        army.addCharacter(new Archer(25));
        army.addCharacter(new Swordsman(40));
        army.addCharacter(new Mage(50));
        army.addCharacter(new Mage(20));

        int actualPower = army.calculateTotalPower();
        int expectedPower = 135;

        assertEquals(expectedPower, actualPower);
    }
}