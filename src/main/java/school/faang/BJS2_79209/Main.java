package school.faang.BJS2_79209;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Character warrior = new Warrior("Elon");
        Character archer = new Archer("Musk");

        while (true) {
            int random = ThreadLocalRandom.current().nextInt(0, 2);

            if (random == 0) {
                warrior.attack(archer);
            } else {
                archer.attack(warrior);
            }

            System.out.printf("warrior %d, archer %d\n", warrior.health, archer.health);
            if (warrior.health == 0 || archer.health == 0) {
                break;
            }
        }
    }
}
