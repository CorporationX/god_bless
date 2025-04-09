package school.faang.bjs2_68093;

import static school.faang.bjs2_68093.GameProperties.DEFAULT_WARRIOR_AGILITY;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_WARRIOR_INTELLECT;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_WARRIOR_STRENGTH;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, DEFAULT_WARRIOR_STRENGTH, DEFAULT_WARRIOR_AGILITY, DEFAULT_WARRIOR_INTELLECT);
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    void attack(Character opponent) {
        opponent.reduceHealth(this.strength);
    }
}
