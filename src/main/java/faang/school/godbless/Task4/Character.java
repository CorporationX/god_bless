package faang.school.godbless.Task4;

public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.health = 100;
    }

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    abstract void attack(Character character);

}
