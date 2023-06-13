package faang.school.godbless;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    private int intelligence;
    protected int health;

    public abstract void attack(Character character);

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        health = 100;
    }
}
