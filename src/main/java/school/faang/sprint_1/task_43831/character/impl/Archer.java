package school.faang.sprint_1.task_43831.character.impl;

import school.faang.sprint_1.task_43831.character.Character;

public class Archer extends school.faang.sprint_1.task_43831.character.Character {
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character enemy) {
        enemy.takingDamage(agility);
    }
}
