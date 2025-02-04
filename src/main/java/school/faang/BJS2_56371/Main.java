package school.faang.BJS2_56371;

import school.faang.BJS2_56371.characters.Archer;
import school.faang.BJS2_56371.characters.Warrior;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        final Archer ramil = new Archer("Ramil");
        final Warrior albert = new Warrior("Albert");

        System.out.println("Начальное здоровье:");
        System.out.printf("%s: %d HP%n", ramil.getName(), ramil.getHealth());
        System.out.printf("%s: %d HP%n", albert.getName(), albert.getHealth());
        System.out.println("--------------------------------");

        while (ramil.isAlive() && albert.isAlive()) {
            if (ThreadLocalRandom.current().nextInt(2) == 0) {
                ramil.attack(albert);
            } else {
                albert.attack(ramil);
            }

            // Вывод текущего состояния
            System.out.printf("%s: %d HP%n", ramil.getName(), ramil.getHealth());
            System.out.printf("%s: %d HP%n", albert.getName(), albert.getHealth());
            System.out.println("--------------------------------");
        }

        // Определяем победителя
        if (ramil.isAlive()) {
            System.out.println(ramil.getName() + " победил!");
        } else {
            System.out.println(albert.getName() + " победил!");
        }

    }
}
