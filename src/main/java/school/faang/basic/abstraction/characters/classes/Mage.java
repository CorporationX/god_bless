package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;

import static school.faang.basic.abstraction.characters.CharacterStats.MageStats.DEFAULT_AGILITY;
import static school.faang.basic.abstraction.characters.CharacterStats.MageStats.DEFAULT_INTELLIGENCE;
import static school.faang.basic.abstraction.characters.CharacterStats.MageStats.DEFAULT_STRENGTH;

public class Mage extends Character {

    public Mage(String name) {
        super(name,
                DEFAULT_STRENGTH,
                DEFAULT_AGILITY,
                DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int getAttackDamage() {
        return this.intelligence;
    }
}