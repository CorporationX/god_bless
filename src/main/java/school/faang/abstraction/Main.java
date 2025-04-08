package school.faang.abstraction;

import school.faang.abstraction.entitiy.Archer;
import school.faang.abstraction.entitiy.Creature;
import school.faang.abstraction.entitiy.Warrior;

public class Main {
    public static void main(String[] args) {
        Creature archer = new Archer("Archer");
        Creature warrior = new Warrior("Warrior");
        System.out.println("Warrior health: " + warrior.getHealth());

        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.getHealth());

        for (int i = 0; i < 12; i++) {
            warrior.attack(archer);
            System.out.println("Archer health: " + archer.getHealth());
        }
    }
}

