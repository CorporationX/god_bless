package school.faang.task_43840;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected void damageHealth(Character character, int ability) {
        if (character != null) {
            int updatedHealth = Math.max(character.getHealth() - ability, 0);
            character.setHealth(updatedHealth);
        }
    }

    public abstract void attack(Character character);
}
