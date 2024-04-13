package faang.school.godbless.BJS2_4275;

public abstract class Creature {

    private static final int DEFAULT_QUANTITY = 10;
    private static final int MAX_QUANTITY = 100;
    private static final int MIN_QUANTITY = 0;

    private String name;
    private int level;
    private int damage;
    private int defense;
    private int health;
    private int speed;
    private int quantity = DEFAULT_QUANTITY;

    public Creature(String name, int level, int damage, int defense, int health, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }

    public void addQuantity(int quantity) {
        if (quantity <= MIN_QUANTITY || quantity >= MAX_QUANTITY) {
            throw new IllegalArgumentException("Out of bounds");
        }
        this.quantity += quantity;
    }

    public int getPower() {
        return damage * quantity;
    }

    public int getHealth() {
        return defense + health;
    }

    public void attack(int power) {
        this.health = power - getHealth();
    }
}
