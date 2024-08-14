package faang.school.godbless.abstraction;

public abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
    public int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
