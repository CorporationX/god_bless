package school.faang.task43920;

import school.faang.task43920.model.Archer;
import school.faang.task43920.model.Warrior;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer("Robert the Archer");
        Warrior warrior = new Warrior("Richard the Warrior");

        System.out.println("Before attacks: ");
        System.out.println(archer);
        System.out.println(warrior);

        warrior.attack(archer);
        System.out.println("After attack archer to warrior: ");
        System.out.println(warrior);

        archer.attack(warrior);
        System.out.println("After attack warrior to archer: ");
        System.out.println(archer);


    }
}

