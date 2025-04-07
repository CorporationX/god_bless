package school.faang.abstraction;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter(AccessLevel.PROTECTED)
@Getter
public abstract class Character {
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public abstract void attack(Character opponent);

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }
}
