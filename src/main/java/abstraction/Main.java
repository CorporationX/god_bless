package abstraction;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Konan");
        Character archer = new Archer("Legolas");
        Random rand = new Random();

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            if (rand.nextInt(100) > 45) {
                System.out.println(archer.getName() + " attacking " + warrior.getName() + "!");
                archer.attack(warrior);
                System.out.println("Nice shot! " + warrior.getName() + " health is " + warrior.getHealth());
            } else {
                System.out.println(warrior.getName() + " attacking " + archer.getName() + "!");
                warrior.attack(archer);
                System.out.println("What a strike! " + archer.getName() + " health is " + archer.getHealth());
            }
        }

        System.out.println("What a massacre!");
        if (warrior.getHealth() == 0) {
            System.out.println(warrior.getName() + " ended like a true warrior! Valhalla is waiting!");
        } else {
            System.out.println(archer.getName() + " is in another world now. Godness rest his soul.");
        }
    }
}
