package school.faang;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int healthPoint;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
        this.healthPoint = 100;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.healthPoint = 100;
    }

    public abstract void attack(Character opponent);


    protected void reduseHealth(int damage) {
        this.healthPoint -= damage;
        if (this.healthPoint < 0) {
            this.healthPoint = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
}



