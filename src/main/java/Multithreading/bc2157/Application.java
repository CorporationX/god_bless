package Multithreading.bc2157;

import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        List<Hero> heroes = List.of(new Archer(25), new Swordsman(40), new Mage(50), new Mage(20),
                new Archer(25), new Swordsman(40), new Mage(50), new Mage(20),
                new Archer(25), new Swordsman(40), new Mage(50), new Mage(20));

        Army army = new Army(heroes);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

}
