package school.faang.abstraction;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Character {

    String name;
    int strength;
    int agility;
    int intelligence;
    int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(school.faang.abstraction.Character opponent);


    protected void setHealth(int attribute) {
        health = Math.max(getHealth() - attribute, 0);
        System.out.println(health + " " + name + " health");
    }

}