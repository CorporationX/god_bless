package school.faang.abstraction.entitiy;

public abstract class Creature {
    private static final int DEFAULT_HEALTH = 100;
    private static final int AVERAGE_PROPERTIES_VALUE = 5;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;

    private int health;
    private boolean isAlive;

    public Creature(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
        this.isAlive = true;
    }

    public Creature(String name) {
        this.name = name;
        this.strength = AVERAGE_PROPERTIES_VALUE;
        this.agility = AVERAGE_PROPERTIES_VALUE;
        this.intelligence = AVERAGE_PROPERTIES_VALUE;
        this.health = DEFAULT_HEALTH;
        this.isAlive = true;
    }

    public abstract void attack(Creature target);

    public void takeDamage(int damage) {
        this.health -= damage;

        if (this.health <= 0 && !this.isAlive) {
            die();
        }
    }

    private void die() {
        System.out.println("Creature died");
        isAlive = false;
    }
}
