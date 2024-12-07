package school.faang.sprint1.task_43502;

import static school.faang.sprint1.task_43502.CharacterConfigurations.*;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, DEFAULT_WARRIOR_STRENGTH, DEFAULT_WARRIOR_AGILITY, DEFAULT_WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character characterToAttack) {
        characterToAttack.setHealth(characterToAttack.getHealth() - getStrength());
    }
}
