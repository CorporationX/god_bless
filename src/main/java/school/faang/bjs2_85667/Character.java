package school.faang.bjs2_85667;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {

    private static final int DEFAULT_POWER = 5;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    private final String name;
    private final int power;
    private final int dexterity;
    private final int intelligence;
    private int health = 100;

    public Character(String name) {
        this(name, DEFAULT_POWER, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}