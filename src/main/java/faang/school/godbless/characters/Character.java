package faang.school.godbless.characters;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health;

    public Character(String name, int strength, int agility, int intellect, int health) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.health = health;
    }

    public abstract Character attack(Character character);
}
