package school.faang.BJS2_68253;

public abstract class Character {

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;

    }

    public Character(int agility, int intelligence, int strength, String name) {
        this.agility = agility;
        this.intelligence = intelligence;
        this.strength = strength;
        this.name = name;
    }

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;
    protected boolean isAlive = true;

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
        if (!isAlive) {
            System.out.println(getName() + "is died ");
            return;
        } else {
            this.health = Math.max(0, health);
            if (this.health == 0) {
                isAlive = false;
                System.out.println(getName() + " has just died ");
            }
        }
    }

    abstract void attack(Character opponent);
}
