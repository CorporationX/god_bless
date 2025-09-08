package school.faang.abstraction;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
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

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public abstract void attack(Character opponent);

    protected void takeDamage(int strength, Character opponent) {
        int actualStrength = Math.max(0, strength); //урон не может быть отрицательным
        opponent.health -= actualStrength;
        if (opponent.health < 0) {
            opponent.health = 0;
        }
    }

    public boolean isDead() {
        return health == 0;
    }
}