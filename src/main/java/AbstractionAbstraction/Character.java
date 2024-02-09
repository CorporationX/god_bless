package AbstractionAbstraction;

public abstract class Character {
    private String name;
    private int force;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int agility, int intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getForce() {
        return force;
    }

    public int getAgility() {
        return agility;
    }

    public abstract void attack (Character character);
}
