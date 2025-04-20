package school.faang.bjs272167;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {
    @Test
    void testCalculateTotalPower() {
        int firstPower = 25;
        int secondPower = 30;
        int thirdPower = 35;
        int fourthPower = 40;
        int fifthPower = 45;
        int sixthPower = 50;
        Squad archers = new Squad(List.of(new Archer(firstPower), new Archer(fourthPower)));
        Squad swordsmen = new Squad(List.of(new Swordsman(secondPower), new Swordsman(fifthPower)));
        Squad mages = new Squad(List.of(new Mage(thirdPower), new Mage(sixthPower)));
        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);
        int sum = firstPower + secondPower + thirdPower + fourthPower + fifthPower + sixthPower;

        int totalPower = army.calculateTotalPower();

        assertEquals(sum, totalPower);
    }
}