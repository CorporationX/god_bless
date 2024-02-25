package faang.school.godbless.magicheroes;

import java.util.List;

public class Main {
    public static void main(String... args) {
        List<Unit> units = List.of(new Archer(25),
            new Swordsman(40),
            new Mage(50),
            new Archer(25),
            new Swordsman(40),
            new Mage(50));

        Army army = new Army(units);
        int totalPower = army.calculateTotalPower();
        System.out.println("Total power: " + totalPower);
    }
}
