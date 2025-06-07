package school.faang.abstraction;

public abstract class Character {
    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    protected boolean isKilling() {
        return health <= 0;
    }
}
