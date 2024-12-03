package school.faang.sprint_1.task_43831.character.impl;

import school.faang.sprint_1.task_43831.character.Character;

public class Warrior extends school.faang.sprint_1.task_43831.character.Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.takingDamage(strength);
    }
}
