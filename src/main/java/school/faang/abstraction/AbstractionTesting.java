package school.faang.abstraction;

import java.util.concurrent.ThreadLocalRandom;

public class AbstractionTesting {
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

            if (archer.isKilling() || warrior.isKilling()) {
                break;
            }
        }
    }
}
