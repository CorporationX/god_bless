package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = GameProperties.STRENGTH_DEFAULT;
        this.agility = GameProperties.AGILLITY_DEFAULT;
        this.intelligence = GameProperties.INTELLIGENCE_DEFAULT;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = GameProperties.DEFAULT_HEALTH;
    }

    public abstract void attack(Character character);
}
