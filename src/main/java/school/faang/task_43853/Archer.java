package school.faang.task_43853;

import static school.faang.task_43853.CharacterProperties.ARCHER_POWER;
import static school.faang.task_43853.CharacterProperties.ARCHER_AGILITY;
import static school.faang.task_43853.CharacterProperties.ARCHER_INTELLECT;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = ARCHER_POWER;
        this.agility = ARCHER_AGILITY;
        this.intellect = ARCHER_INTELLECT;
    }

    @Override
    public void attack(Character character) {
        double healthAfterTakenDamage = character.getHealth() - this.agility;
        character.setHealth(healthAfterTakenDamage);
    }
}
