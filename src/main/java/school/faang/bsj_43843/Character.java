package school.faang.bsj_43843;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Character {
    protected final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DefaultsParameters.HEALTH;
    }

    public abstract void attack(Character character);
}
