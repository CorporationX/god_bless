package school.faang.bjs2_69309;

public abstract class Character {

    protected String name;
    protected static int POWER = 5;
    protected static int AGILITY = 5;
    protected static int INTELLIGENCE = 5;
    protected int health = 100;

    public Character(String name) {
        this(name, POWER, AGILITY, INTELLIGENCE);
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        POWER = power;
        AGILITY = agility;
        INTELLIGENCE = intelligence;
    }

    abstract void attack(Character opponent);

    protected boolean healthCheck(int dmg, int health) {
        if (health - dmg <= 0) {
            System.out.println("убил...");
        }
        return health - dmg >= 0;
    }
}
