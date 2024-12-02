package school.faang.task_43806;

import school.faang.task_43806.entity.Archer;
import school.faang.task_43806.entity.Character;
import school.faang.task_43806.entity.Warrior;

public class Main {

    public static void main(String[] args) {
        Character testArcher = new Archer("TestArcher");
        Character testWarrior = new Warrior("TestWarrior");

        System.out.println(testArcher);
        System.out.println(testWarrior);

        testWarrior.attack(testArcher);
        testArcher.attack(testWarrior);

        System.out.println(testArcher);
        System.out.println(testWarrior);
    }
}
