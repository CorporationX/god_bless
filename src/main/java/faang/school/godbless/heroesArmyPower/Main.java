package faang.school.godbless.heroesArmyPower;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Unit> units = List.of(new Mage(15), new Archer(30), new Swordsman(60),
                new Mage(22), new Mage(15), new Archer(30), new Swordsman(60),
                new Mage(22), new Mage(15), new Archer(30), new Swordsman(60),
                new Mage(22));
        Army army = new Army(units);

        int totalPower = army.calculateTotalPower();
        System.out.printf("Мощь армии: %d%n", totalPower);
    }

}
