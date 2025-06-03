package school.faang;

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

            System.out.println(warrior.health);
            System.out.println(archer.health);

            if (warrior.isLive() || archer.isLive()) {
                break;
            }
        }
    }
}
