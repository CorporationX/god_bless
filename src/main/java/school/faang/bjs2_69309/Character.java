package school.faang.bjs2_69309;

public abstract class Character {

    private static final int DEFAULT_POWER = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this(name, DEFAULT_POWER, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    protected boolean healthCheck(int dmg, int health) {
        if (health - dmg <= 0) {
            System.out.println("убил...");
        }
        return health - dmg >= 0;
    }
}
