package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.CharacterStats;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,
                CharacterStats.WarriorStats.DEFAULT_STRENGTH,
                CharacterStats.WarriorStats.DEFAULT_AGILITY,
                CharacterStats.WarriorStats.DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int attack() {
        return this.strength;
    }
}