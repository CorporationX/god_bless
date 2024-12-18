package school.faang.sprint_3.task_47691;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Army army = generateArmy();

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }

    private static Army generateArmy() {
        Army army = new Army(new ArrayList<>());

        Random random = new Random();
        int armySize = random.nextInt(1000);
        for (int i = 0; i < armySize; i++) {
            army.addWarrior(new Archer(random.nextInt(100)));
            army.addWarrior(new Swordsman(random.nextInt(100)));
            army.addWarrior(new Mage(random.nextInt(100)));
        }
        return army;
    }
}
