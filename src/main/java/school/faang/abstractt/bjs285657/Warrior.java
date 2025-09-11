package school.faang.abstractt.bjs285657;

import static school.faang.abstractt.bjs285657.StartCharacteristics.WARRIOR_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.WARRIOR_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.WARRIOR_STRENGTH;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public int getDamage() {
        return this.getStrength();
    }
}
