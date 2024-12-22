package school.faang.bjs48074;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Unit archer1 = new Archer(35);
        Unit archer2 = new Archer(30);
        Unit mage = new Archer(25);
        Unit swordsman = new Archer(65);

        Army army = new Army(new ArrayList<>(List.of(archer1, mage, swordsman)));
        army.addUnit(archer2);

        System.out.println(army.calculateTotalPowerThreads());
        System.out.println(army.calculateTotalPowerParallel());
    }
}
