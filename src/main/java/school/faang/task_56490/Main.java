package school.faang.task_56490;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Oliver");
        Character archer = new Archer("Mark");
        while (archer.getHp() != 0 && warrior.getHp() != 0) {
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                warrior.attack(archer);
            } else {
                archer.attack(warrior);
            }
            if (warrior.getHp() == 0) {
                System.out.println("Archer " + archer.getName() + " win!");
            } else if (archer.getHp() == 0) {
                System.out.println("Warrior " + warrior.getName() + " win!");
            }
        }
    }
}
