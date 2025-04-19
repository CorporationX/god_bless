package school.faang.bjs2_69381;

public abstract class Character {
    private static final int DEFAULT_ATTR_VALUE = 5;
    private static final int DEFAULT_HEALTH = 100;

    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this(name, DEFAULT_ATTR_VALUE, DEFAULT_ATTR_VALUE, DEFAULT_ATTR_VALUE);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    protected void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }
}