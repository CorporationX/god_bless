package school.faang.abstraction.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(){}

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

    protected void reduceHealth(Character opponent, int damage) {
        opponent.health -= damage;
        if (opponent.health <= 0) {
            opponent.health = 0;
        }
        System.out.println(name + " наносит " + damage + " урона " + opponent.name +
                ". Здоровье " + opponent.name + ": " + opponent.health);
    }
}
