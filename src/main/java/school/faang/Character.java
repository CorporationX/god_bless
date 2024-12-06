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
        this.strength = GameProperties.Strength_Default;
        this.agility = GameProperties.Agility_Default;
        this.intelligence = GameProperties.Intelligence_Default;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = GameProperties.DefaultHealth;
    }

    public abstract void attack(Character character);
}
