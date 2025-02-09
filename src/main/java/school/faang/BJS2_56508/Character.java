package school.faang.BJS2_56508;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private int health = 100;
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    protected abstract void attack(Character opponent);

    protected boolean isAlive() {
        return health >= 0;
    }
}
