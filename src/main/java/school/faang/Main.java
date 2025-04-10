package school.faang;

import school.faang.abstraction.Archer;
import school.faang.abstraction.Warrior;

public class Main {
    public static void main(String[] args) {
        characterTests();
    }

    public static void characterTests() {
        Warrior conan = new Warrior("Conan");
        Archer legolas = new Archer("Legolas");
        Warrior boromir = new Warrior("Boromir");

        System.out.println("--- Character Creation ---");
        System.out.println(conan.toString());
        System.out.println(legolas.toString());

        System.out.println("\n--- Basic Attacks ---");
        System.out.println(boromir.toString());
        boromir.attack(legolas);
        System.out.println(legolas.toString());

        System.out.println("\n--- Attack on a 'Dead' Character ---");
        legolas.setHealth(0);
        System.out.println(boromir.toString());
        boromir.attack(legolas);
        System.out.println(legolas.toString());

        System.out.println("\n--- Multiple Attacks ---");
        Warrior strongGuy = new Warrior("StrongGuy");
        Archer nimbleShot = new Archer("NimbleShot");
        System.out.println(nimbleShot.getName() + " Health: " + nimbleShot.getHealth());
        for (int i = 0; i < 11; i++) {
            strongGuy.attack(nimbleShot);
            System.out.println(strongGuy.toString());
        }

        System.out.println("\n--- Initial Health Check ---");
        Warrior anotherWarrior = new Warrior("Tank");
        Archer anotherArcher = new Archer("SharpEye");
        System.out.println(anotherWarrior.getName() + " initial Health: " + anotherWarrior.getHealth());
        System.out.println(anotherArcher.getName() + " initial Health: " + anotherArcher.getHealth());

        System.out.println("\n--- Initial Stats Check ---");
        System.out.println(anotherWarrior.toString());
        System.out.println(anotherArcher.toString());
    }
}
