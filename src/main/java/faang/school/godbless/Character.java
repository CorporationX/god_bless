package faang.school.godbless;

public abstract class Character {
    public static final int DEFAULT_HP = 100;
    public String name;
    public int strength;
    public int agility;
    public int intelligence;
    public int healthPoints;

    public Character(String name) {
        this.name = name;
        healthPoints = DEFAULT_HP;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        healthPoints = DEFAULT_HP;
    }

    public abstract void attack(Character character);
}
