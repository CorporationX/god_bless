package school.faang.task_43926;

public abstract class Character {
    private final String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }
    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int healthAfterDamage) {
        this.health = healthAfterDamage;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getPower() {
        return this.power;
    }
}

