package school.faang.task_43838;

import school.faang.task_43838.entity.Archer;
import school.faang.task_43838.entity.Character;
import school.faang.task_43838.entity.Warrior;

public class Main {
    public static void main(String[] args) {
        Character Archer = new Archer("Assassin");
        Character Warrior = new Warrior("Axe");

        System.out.println(Archer);
        System.out.println(Warrior);

        Warrior.attack(Archer);
        Archer.attack(Warrior);

        System.out.println(Archer);
        System.out.println(Warrior);
    }
}
