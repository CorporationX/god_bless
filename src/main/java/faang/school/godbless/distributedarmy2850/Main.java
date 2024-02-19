package faang.school.godbless.distributedarmy2850;

import faang.school.godbless.distributedarmy2850.troop.Archer;
import faang.school.godbless.distributedarmy2850.troop.Mage;
import faang.school.godbless.distributedarmy2850.troop.Swordsman;
import faang.school.godbless.distributedarmy2850.troop.Unit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = createArmy();

        System.out.printf("Total army power is: %d.%n", army.calculateTotalPower());
    }

    private static Army createArmy() {
        List<Unit> units = new ArrayList<>(List.of(
                new Archer(19), new Archer(10), new Mage(23),
                new Swordsman(17), new Swordsman(15), new Swordsman(15),
                new Archer(19), new Archer(10), new Mage(23),
                new Swordsman(17), new Swordsman(15), new Swordsman(15)
        ));
        return new Army(units);
    }
}
