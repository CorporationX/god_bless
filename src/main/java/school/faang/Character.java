package school.faang;

abstract public class Character {
    private String name;
    private int strength;
    private int intelligence;
    private int health;
    private int agility;

    public Character(String name) {
        this.name = name;
        this.strength = 0;
        this.intelligence = 0;
        this.health = 100;
        this.agility = 0;
    }

    public Character(String name, int strength, int intelligence, int agility) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.health = 100;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAgility() {
        return agility;
    }

    public abstract void attack(Character hostile);
}




