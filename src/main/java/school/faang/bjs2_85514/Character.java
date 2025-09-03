package school.faang.bjs2_85514;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }
    public abstract void attack(Character opponent);

    // основной метод
    protected void decreaseHealth(int damage) {
        health = Math.max(0, health - damage);
    }
}
