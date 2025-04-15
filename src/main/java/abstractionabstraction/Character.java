package abstractionabstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    public static final int DEFAULT_HEALTH = 100;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public abstract void attack(Character opponent);

    public boolean isAlive() {
        return this.health > 0;
    }

}
