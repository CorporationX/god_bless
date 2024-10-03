package dima.evseenko.abstraction;

import dima.evseenko.abstraction.entity.Archer;
import dima.evseenko.abstraction.entity.Character;
import dima.evseenko.abstraction.entity.Warrior;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Dima");
        Character archer = new Archer("Kolya");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
