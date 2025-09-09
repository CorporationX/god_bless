package school.faang.bjs2_85621.Character;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public void checkHealth(int healthOpponent) {
        if (healthOpponent <= 0) {
            health = 0;
        }
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);
}
