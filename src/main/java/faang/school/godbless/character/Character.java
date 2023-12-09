package faang.school.godbless.character;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PROTECTED)
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    @Setter(AccessLevel.PROTECTED)
    private int health = 100;

    public Character(
            String name,
            int strength,
            int agility,
            int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
