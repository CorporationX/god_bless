package faang.school.godbless.abstraction;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character enemy);
}
