package school.faang.bjs2_79224;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Nicholas");
        Character archer = new Archer("Mary");
        Random random = new Random();

        System.out.printf("начальное здоровье %s = %d\n", warrior.getName(), warrior.getHealth());
        System.out.printf("начальное здоровье %s = %d\n", archer.getName(), archer.getHealth());

        while (warrior.isAlive() && archer.isAlive()) {
            boolean randomNum = random.nextBoolean();
            if (randomNum) {
                warrior.attack(archer);
            } else {
                archer.attack(warrior);
            }
        }
    }
}
