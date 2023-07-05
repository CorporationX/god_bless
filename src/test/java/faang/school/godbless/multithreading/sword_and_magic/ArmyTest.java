package faang.school.godbless.multithreading.sword_and_magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    void calculateTotalPower() {
        Army army = new Army();
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(20));
        army.addUnit(new Mage(13));
        army.addUnit(new Archer(22));

        int expected = 70;
        try {
            System.out.println(army.calculateTotalPower());
            assertEquals(expected, army.calculateTotalPower());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}