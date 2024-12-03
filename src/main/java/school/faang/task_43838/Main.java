package school.faang.task_43838;

import school.faang.task_43838.entity.Archer;
import school.faang.task_43838.entity.Character;
import school.faang.task_43838.entity.Warrior;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Assassin");
        Character warrior = new Warrior("Axe");

        System.out.println(archer);
        System.out.println(warrior);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer);
        System.out.println(warrior);
    }
}
