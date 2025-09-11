package school.faang.abstractt.bjs285657;

import static school.faang.abstractt.bjs285657.StartCharacteristics.ARCHER_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.ARCHER_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.ARCHER_STRENGTH;

public class Archer extends Character {
    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_DEXTERITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public int getDamage() {
        return this.getDexterity();
    }

}
