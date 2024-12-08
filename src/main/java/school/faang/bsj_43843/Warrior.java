package school.faang.bsj_43843;

import static school.faang.bsj_43843.DefaultsParameters.WARRIOR_AGILITY;
import static school.faang.bsj_43843.DefaultsParameters.WARRIOR_INTELLIGENCE;
import static school.faang.bsj_43843.DefaultsParameters.WARRIOR_STRENGTH;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character == null) {
            throw new IllegalArgumentException();
        }
        character.setHealth(character.getHealth() - getStrength());
    }
}
