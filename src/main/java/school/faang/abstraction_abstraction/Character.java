package school.faang.abstraction_abstraction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Character {
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hp = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int intelligence, int agility, int strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
    }

    protected abstract void attack(Character enemy);
}
