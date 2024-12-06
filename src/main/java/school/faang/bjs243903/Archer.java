package school.faang.bjs243903;

import static school.faang.bjs243903.Constants.ARCHER_POWER;
import static school.faang.bjs243903.Constants.ARCHER_AGILITY;
import static school.faang.bjs243903.Constants.ARCHER_INTELLECT;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}
