package school.faang;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Воин");
        Character archer = new Archer("Лучник");

        while (true) {
            int random = ThreadLocalRandom.current().nextInt(0, 2);

            if (random == 0) {
                warrior.attack(archer);
            } else {
                archer.attack(warrior);
            }

            if (warrior.health == 0 || archer.health == 0) {
                System.out.println("Бой окончен");
                break;
            }

            System.out.println("У " + warrior.name + "а осталось - " + warrior.health + " жизней");
            System.out.println("У " + archer.name + "а осталось - " + archer.health + " жизней");


        }
    }
}
