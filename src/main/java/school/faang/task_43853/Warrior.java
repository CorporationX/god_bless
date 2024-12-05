package school.faang.task_43853;

import static school.faang.task_43853.CharacterProperties.WARRIOR_POWER;
import static school.faang.task_43853.CharacterProperties.WARRIOR_AGILITY;
import static school.faang.task_43853.CharacterProperties.WARRIOR_INTELLECT;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = WARRIOR_POWER;
        this.agility = WARRIOR_AGILITY;
        this.intellect = WARRIOR_INTELLECT;
    }

    @Override
    public void attack(Character character) {
        double healthAfterTakenDamage = character.getHealth() - this.power;
        character.setHealth(healthAfterTakenDamage);
    }

}
