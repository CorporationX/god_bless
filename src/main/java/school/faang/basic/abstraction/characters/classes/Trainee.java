package school.faang.basic.abstraction.characters.classes;

import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.CharacterStats;

public class Trainee extends Character {

    public Trainee(String name) {
        super(name,
                CharacterStats.TraineeStats.DEFAULT_STRENGTH,
                CharacterStats.TraineeStats.DEFAULT_AGILITY,
                CharacterStats.TraineeStats.DEFAULT_INTELLIGENCE
        );
    }

    @Override
    public int attack() {
        return Math.max(this.strength, this.agility);
    }
}