package faang.school.godbless.abstraction;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 0;
        this.dexterity = 0;
        this.intellect = 0;
        this.health = 100;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = agility;
        this.intellect = intellect;
        this.health = 100;
    }

    public abstract void attack(Character goal);
}
