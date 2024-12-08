package school.faang.bsj_43843;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static school.faang.bsj_43843.DefaultsParameters.HEALTH;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public abstract class Character {
    @Getter(AccessLevel.PUBLIC)
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
