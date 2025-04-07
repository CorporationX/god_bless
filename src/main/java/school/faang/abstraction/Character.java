package school.faang.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intellect;
    protected int health = 100;

    protected static final int DEFAULT_STRENGTH = 5;
    protected static final int DEFAULT_DEXTERITY = 5;
    protected static final int DEFAULT_INTELLECT = 5;


    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.dexterity = DEFAULT_DEXTERITY;
        this.intellect = DEFAULT_INTELLECT;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intelligence;
    }

    public abstract void attack(Character opponent);

    public void checkHealth(Character opponent) {
        opponent.health = Math.max(opponent.health, 0);
    }
}

