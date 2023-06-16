package faang.school.godbless;

public abstract class Character {
    public static final int DEFAULT_HP = 100;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int healthPoints = DEFAULT_HP;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
