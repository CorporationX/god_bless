package school.faang.bjs2_68093;

import static school.faang.bjs2_68093.GameProperties.DEFAULT_ARCHER_AGILITY;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_ARCHER_INTELLECT;
import static school.faang.bjs2_68093.GameProperties.DEFAULT_ARCHER_STRENGTH;

public class Archer extends Character {
    public Archer(String name) {
        super(name, DEFAULT_ARCHER_STRENGTH, DEFAULT_ARCHER_AGILITY, DEFAULT_ARCHER_INTELLECT);
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    void attack(Character opponent) {
        opponent.reduceHealth(this.agility);
    }
}
