package faang.school.godbless.BJS2_23387;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Army army = new Army(new ArrayList<>(Arrays.asList(new Archer(50), new Swordsman(70), new Mage(40),
                new Archer(50), new Swordsman(70), new Mage(40),
                new Archer(50), new Swordsman(70), new Mage(40),
                new Archer(50), new Swordsman(70), new Mage(40)
        )));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total power: " + totalPower);
    }
}
