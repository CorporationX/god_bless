package HeroesOfMightAndMagic;

public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int health;

    public Creature(String name, int level, int damage, int defence, int speed, int health) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefence() {
        return defence;
    }
}
