package school.faang.task_48496;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hero> heroes = List.of(new Swordsman(50), new Archer(25), new Mage(15));
        Army army = new Army(heroes);

        int allHerosPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + allHerosPower);

    }
}
