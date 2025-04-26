package school.faang.heroes_of_might_and_magic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Archer archer1 = new Archer(25);
        Archer archer2 = new Archer(30);
        Swordsman swordsman1 = new Swordsman(40);
        Swordsman swordsman2 = new Swordsman(45);
        Mage mage1 = new Mage(50);
        Mage mage2 = new Mage(55);

        Squad<Archer> archers = new Squad<>(Arrays.asList(archer1, archer2));
        Squad<Swordsman> swordsmen = new Squad<>(Arrays.asList(swordsman1, swordsman2));
        Squad<Mage> mages = new Squad<>(Arrays.asList(mage1, mage2));

        Army army = new Army(Arrays.asList(archers, swordsmen, mages));
        int totalPower = army.calculateTotalPower();
        System.out.printf("Общая сила армии: %s%n", totalPower);
    }
}