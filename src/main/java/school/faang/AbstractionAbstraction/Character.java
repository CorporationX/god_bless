package school.faang.AbstractionAbstraction;

import lombok.Data;

@Data
abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
