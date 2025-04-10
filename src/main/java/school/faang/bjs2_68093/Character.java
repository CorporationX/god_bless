package school.faang.bjs2_68093;

import static school.faang.bjs2_68093.GameProperties.DEFAULT_AGILITY;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_HEALTH;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_INTELLECT;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_STRENGTH;
import static school.faang.bjs2_68093.GameProperties.MIN_VALID_HEALTH;

abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = DEFAULT_HEALTH;

    protected Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intellect = DEFAULT_INTELLECT;
    }

    protected Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    abstract void attack(Character opponent);

    protected void reduceHealth(int attackPower) {
        this.health = Math.max(this.health - attackPower, MIN_VALID_HEALTH);
    }
}
