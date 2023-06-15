package Task3;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    protected int force;
    protected int agility;
    protected int intelligence;
    private int health;

    public int setHealth(int health) {
        return this.health = health;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int agility, int intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract int attack(Character character);
}
