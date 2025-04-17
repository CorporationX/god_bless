package school.faang.abstraction;

public abstract class Character {
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 5;
    private static final int STRENGTH = 5;
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this(AGILITY, INTELLIGENCE, STRENGTH, name);

    }

    public Character(int agility, int intelligence, int strength, String name) {
        this.agility = agility;
        this.intelligence = intelligence;
        this.strength = strength;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (this.health <= 0) {
            System.out.println(getName() + "is died ");
        } else {
            this.health = health;

        }
    }

    abstract void attack(Character opponent);
}
