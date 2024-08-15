package ru.kraiush.BJS218953;

import java.util.Collections;

public class AppAbstractionTwice {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Jhon");

        Archer archer = new Archer("Rob");

        System.out.print(String.join("", Collections.nCopies(75, "-")));
        System.out.println();
        System.out.println("warrior: " + warrior);
        archer.attack(warrior);
        System.out.println("warrier after attack by archer:");
        System.out.println("warrior: " + warrior);

        System.out.print(String.join("", Collections.nCopies(75, "-")));
        System.out.println("\narcher: " + archer);
        warrior.attack(archer);
        System.out.println("archer after attack by warrier:");
        System.out.println("archer: " + archer);
    }
}
