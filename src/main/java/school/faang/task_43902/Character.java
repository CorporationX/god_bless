package school.faang.task_43902;

public abstract class Character {
    String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
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

    public abstract void attack(Character damage);
}