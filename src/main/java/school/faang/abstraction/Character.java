package school.faang.abstraction;

public abstract class Character {
    public static final int DEFAULT_STRENGTH = 5;
    public static final int DEFAULT_AGILITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 5;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health не может быть отрицательным");
        }
        this.health = health;
    }

    public abstract void attack(Character opponent) throws IllegalArgumentException;
}