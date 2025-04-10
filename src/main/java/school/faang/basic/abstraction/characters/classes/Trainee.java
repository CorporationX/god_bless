package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;

import static school.faang.basic.abstraction.characters.CharacterStats.TraineeStats.DEFAULT_AGILITY;
import static school.faang.basic.abstraction.characters.CharacterStats.TraineeStats.DEFAULT_INTELLIGENCE;
import static school.faang.basic.abstraction.characters.CharacterStats.TraineeStats.DEFAULT_STRENGTH;

public class Trainee extends Character {

    public Trainee(String name) {
        super(name,
                DEFAULT_STRENGTH,
                DEFAULT_AGILITY,
                DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int getAttackDamage() {
        return Math.max(this.strength, this.agility);
    }
}