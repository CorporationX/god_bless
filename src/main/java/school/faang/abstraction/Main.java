package school.faang.abstraction;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Фарамир");
        Character archer = new Archer("Леголас");

        warrior.attack(archer);

        for (int i = 0; i < warrior.getHealth(); i++) {
            archer.attack(warrior);

            Random random = new Random();
            int delay = random.nextInt(500, 1000);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
