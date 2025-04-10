package school.faang.abstraction;

public abstract class Character {
    private static final int BASE_VOLUME = 5;

    protected int health = 100;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(String name) {
        this.name = name;
        this.strength = BASE_VOLUME;
        this.agility = BASE_VOLUME;
        this.intelligence = BASE_VOLUME;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    protected void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

}
