package school.faang.sprint1.task_43502;

import static school.faang.sprint1.task_43502.CharacterConfigurations.DEFAULT_ARCHER_AGILITY;
import static school.faang.sprint1.task_43502.CharacterConfigurations.DEFAULT_ARCHER_INTELLIGENCE;
import static school.faang.sprint1.task_43502.CharacterConfigurations.DEFAULT_ARCHER_STRENGTH;

public class Archer extends Character {

    public Archer(String name) {
        super(name, DEFAULT_ARCHER_STRENGTH, DEFAULT_ARCHER_AGILITY, DEFAULT_ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character characterToAttack) {
        characterToAttack.setHealth(characterToAttack.getHealth() - getAgility());
    }
}
