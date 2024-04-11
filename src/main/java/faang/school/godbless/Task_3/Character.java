package faang.school.godbless.Task_3;

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
    abstract void attack(Character character);
}
