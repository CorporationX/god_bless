package school.faang.sprint_1.task_43831.character.impl;

import school.faang.sprint_1.task_43831.character.Character;

public class Archer extends school.faang.sprint_1.task_43831.character.Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        enemy.takingDamage(agility);
    }
}
