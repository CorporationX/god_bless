package school.faang.sprint_1.task_43831;

import school.faang.sprint_1.task_43831.character.Character;
import school.faang.sprint_1.task_43831.character.impl.Archer;
import school.faang.sprint_1.task_43831.character.impl.Warrior;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Misha");
        Character warrior = new Warrior("Danil");

        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println("Archer health " + archer.getHealth());
        System.out.println("Warrior health " + warrior.getHealth());
    }
}
