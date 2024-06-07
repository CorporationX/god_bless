package faang.school.godbless.BJS2_7742;

import faang.school.godbless.BJS2_7742.Character;

public class Warrior extends Character {
    private final int strength;
    private final int agility;
    private final int intelligence;
    protected Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    protected void attack(Character enemy) {
        if (enemy.getHealth() >= strength)
            enemy.setHealth(enemy.getStrength() - strength);
    }
}
