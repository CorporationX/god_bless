package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;

import static school.faang.basic.abstraction.characters.CharacterStats.WarriorStats.DEFAULT_AGILITY;
import static school.faang.basic.abstraction.characters.CharacterStats.WarriorStats.DEFAULT_INTELLIGENCE;
import static school.faang.basic.abstraction.characters.CharacterStats.WarriorStats.DEFAULT_STRENGTH;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,
                DEFAULT_STRENGTH,
                DEFAULT_AGILITY,
                DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int getAttackDamage() {
        return this.strength;
    }
}