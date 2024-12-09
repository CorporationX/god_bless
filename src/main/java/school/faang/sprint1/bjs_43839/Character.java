package school.faang.sprint1.bjs_43839;

public abstract class Character {
    private static final int HEALTH_BY_DEFAULT = 100;
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    public int health = HEALTH_BY_DEFAULT;

    public Character(String name) {
        this(name, 0, 0, 0);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) { health = 0; }
    }
}
