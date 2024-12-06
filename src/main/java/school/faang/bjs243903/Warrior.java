package school.faang.bjs243903;

import static school.faang.bjs243903.Constants.WARRIOR_POWER;
import static school.faang.bjs243903.Constants.WARRIOR_AGILITY;
import static school.faang.bjs243903.Constants.WARRIOR_INTELLECT;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
