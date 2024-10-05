package tasks.bjs2_31323;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health;

    private static final int DEFAULT_HEALTH = 100;

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH;
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

    public abstract void attack(Character character);

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " получил " + damage + " урона. Оставшееся здоровье: " + this.health);
    }

    protected void showAttackInformation(String enemyName, int damage) {
        System.out.println(String.format("%s атакует %s нанося урон : %s", this.name, enemyName, damage));
    }
}