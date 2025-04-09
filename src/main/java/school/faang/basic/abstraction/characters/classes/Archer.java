package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.CharacterStats;

public class Archer extends Character {

    public Archer(String name) {
        super(name,
                CharacterStats.ArcherStats.DEFAULT_STRENGTH,
                CharacterStats.ArcherStats.DEFAULT_AGILITY,
                CharacterStats.ArcherStats.DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int attack() {
        return this.agility;
    }
}