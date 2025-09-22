package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class Character {
    private String name;
    private int strength = 1;
    private int agility = 1;
    private int intelligence = 1;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void takeDamage(int strength, Character opponent) {
        int actualStrength = Math.max(0, strength); //урон не может быть отрицательным
        opponent.health -= actualStrength;
        if (opponent.health < 0) {
            opponent.health = 0;
        }
    }

    public boolean isDead() {
        return health == 0;
    }
}
