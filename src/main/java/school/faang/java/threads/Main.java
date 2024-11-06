package school.faang.java.threads;

import school.faang.java.threads.army.Army;
import school.faang.java.threads.items.Archer;
import school.faang.java.threads.items.Mage;
import school.faang.java.threads.items.Swordsman;

import java.util.Random;

public class Main {

    public static final int RANDOM_RANGE = 1000;
    public static final int NUMBER_OF_ITEMS = 2;

    public static void main(String[] args) {
        Main m = new Main();
        Army a = new Army();

        m.crateArmy(a);

        a.calculatePowerV3(); //
        System.out.printf("\n Total in the army: %d ", a.calculateTotalPower());  // threads work in parallel
    }

    public void crateArmy(Army army) {
        for (int i = 0; i < Main.NUMBER_OF_ITEMS; i++) {
            army.setItemToMapList(new Archer(getRandomValue()));
            army.setItemToMapList(new Mage(getRandomValue()));
            army.setItemToMapList(new Swordsman(getRandomValue()));
        }
    }

    public int getRandomValue() {
        return new Random().nextInt(Main.RANDOM_RANGE);
    }
}