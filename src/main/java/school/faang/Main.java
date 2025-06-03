package school.faang;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Tom");
        Character archer = new Archer("Robin");

        while (true) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 2);

            if (randomNum == 0) {
                warrior.attack(archer);
            } else {
                archer.attack(warrior);
            }

            if (archer.minHealth() || warrior.minHealth()) {
                break;
            }
        }
    }
}
