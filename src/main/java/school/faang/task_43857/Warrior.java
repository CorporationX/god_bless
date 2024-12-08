package school.faang.task_43857;

import static school.faang.task_43857.Properties.WARRIOR_AGILITY;
import static school.faang.task_43857.Properties.WARRIOR_INTELLECT;
import static school.faang.task_43857.Properties.WARRIOR_POWER;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLECT);
    }

    @Override
    protected void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
        System.out.println(character.getName() + " has the health " + character.getHealth());
    }
}