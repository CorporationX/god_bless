package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;

import static school.faang.basic.abstraction.characters.CharacterStats.ArcherStats.DEFAULT_AGILITY;
import static school.faang.basic.abstraction.characters.CharacterStats.ArcherStats.DEFAULT_INTELLIGENCE;
import static school.faang.basic.abstraction.characters.CharacterStats.ArcherStats.DEFAULT_STRENGTH;

public class Archer extends Character {

    public Archer(String name) {
        super(name,
                DEFAULT_STRENGTH,
                DEFAULT_AGILITY,
                DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int getAttackDamage() {
        return this.agility;
    }
}