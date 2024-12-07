package school.faang.abstraction;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@ToString
@Getter
@Setter
public abstract class Character {
    protected static final int WARRIOR_POWER = 10;
    protected static final int WARRIOR_AGILITY = 5;
    protected static final int WARRIOR_INTELLIGENCE = 3;
    protected static final int ARCHER_POWER = 3;
    protected static final int ARCHER_AGILITY = 10;
    protected static final int ARCHER_INTELLIGENCE = 5;

    private final String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
