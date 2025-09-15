package school.faang.BJS2_85767;

public abstract class Character {
    public static final int BASE_STRENGTH = 5;
    public static final int BASE_AGILITY = 5;
    public static final int BASE_INTELLIGENCE = 5;
    public static final int DEFAULT_HEALTH = 100;

    protected final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    protected Character(String name) {
        this(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELLIGENCE);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public String getName() {return name;}
    public int getStrength() {return strength;}
    public int getAgility() {return agility;}
    public int getIntelligence() {return intelligence;}
    public int getHealth() {return health;}


    protected final void takeDamage(int damage) {
        this.health = this.health - damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    public abstract void attack(Character opponent);
}