package school.faang.BJS2_85767;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("A");
        Archer archer1 = new Archer("B");

        System.out.println("Старт: ");
        System.out.println(warrior1.getName() + " здоровье: " + warrior1.getHealth());
        System.out.println(archer1.getName() + " здоровье: " + archer1.getHealth());

        warrior1.attack(archer1);
        archer1.attack(warrior1);

        System.out.println("После боя: ");
        System.out.println(warrior1.getName() + " здоровье: " + warrior1.getHealth());
        System.out.println(archer1.getName() + " здоровье: " + archer1.getHealth());
    }
}