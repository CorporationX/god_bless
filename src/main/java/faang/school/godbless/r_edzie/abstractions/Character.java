package faang.school.godbless.r_edzie.abstractions;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    Character(String name) {
        this.name = name;
    }

    Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
