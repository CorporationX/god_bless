package school.faang.abstraction;

public abstract class Character {
    protected static final int DEFAULT_SCOPE = 5;
    private final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        strength = DEFAULT_SCOPE;
        agility = DEFAULT_SCOPE;
        intelligence = DEFAULT_SCOPE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected boolean isKilling() {
        return health <= 0;
    }
}
