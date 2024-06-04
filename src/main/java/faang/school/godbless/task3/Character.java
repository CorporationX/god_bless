package faang.school.godbless.task3;

abstract public class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.power = strength;
        this.dexterity = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
