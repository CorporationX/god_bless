package Task3;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int force;
    protected int agility;
    protected int intelligence;
    private int health;

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
