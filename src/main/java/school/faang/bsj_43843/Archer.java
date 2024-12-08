package school.faang.bsj_43843;

import static school.faang.bsj_43843.DefaultsParameters.ARCHER_AGILITY;
import static school.faang.bsj_43843.DefaultsParameters.ARCHER_INTELLIGENCE;
import static school.faang.bsj_43843.DefaultsParameters.ARCHER_STRENGTH;

public class Archer extends Character {
    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character == null) {
            throw new IllegalArgumentException();
        }
        character.setHealth(character.getHealth() - getStrength());
    }

}
