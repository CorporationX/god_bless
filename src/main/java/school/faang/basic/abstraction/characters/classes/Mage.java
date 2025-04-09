package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.CharacterStats;

public class Mage extends Character {

    public Mage(String name) {
        super(name,
                CharacterStats.MageStats.DEFAULT_STRENGTH,
                CharacterStats.MageStats.DEFAULT_AGILITY,
                CharacterStats.MageStats.DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int attack() {
        return this.intelligence;
    }
}