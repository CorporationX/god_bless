package school.faang;

import school.faang.abstractclasses.Archer;
import school.faang.abstractclasses.Character;
import school.faang.abstractclasses.Warrior;

public class Main {
    public static void main(String[] args) {

        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("Warrior attack");
        warrior.attack(archer);
        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("Archer attack");
        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
