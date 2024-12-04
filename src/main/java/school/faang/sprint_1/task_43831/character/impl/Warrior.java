package school.faang.sprint_1.task_43831.character.impl;

import school.faang.sprint_1.task_43831.character.Character;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 11;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character enemy) {
        enemy.takingDamage(strength);
    }
}
