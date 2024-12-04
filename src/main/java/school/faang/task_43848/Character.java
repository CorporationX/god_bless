package school.faang.task_43848;

public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int MIN_HEALTH = 0;

    private String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private int health = DEFAULT_HEALTH;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int intelligence, int agility, int strength) {
        this.name = name;
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
    }

    public abstract void attack(Character defender);

    public boolean isAlive() {
        if (health == MIN_HEALTH) {
            return false;
        }
        return true;
    }

    public void setHealth(int health) {
        if (health < MIN_HEALTH) {
            this.health = MIN_HEALTH;
        } else {
            this.health = health;
        }
    }

    public int getHealth() {
        return health;
    }
}
