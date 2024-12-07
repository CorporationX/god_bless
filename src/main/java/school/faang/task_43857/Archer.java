package school.faang.task_43857;

import static school.faang.task_43857.Properties.ARCHER_AGILITY;
import static school.faang.task_43857.Properties.ARCHER_INTELLECT;
import static school.faang.task_43857.Properties.ARCHER_POWER;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLECT);
    }

    @Override
    protected void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
        System.out.println(character.getName() + " has the health " + character.getHealth());
    }
}