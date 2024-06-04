package faang.school.godbless.absractionabstraction;

public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public int getHealth() {
        return health;
    }

    public void getDamage(int healthDamage) {
        this.health -= healthDamage;

        if (!isAlive()) {
            System.out.println("Персонаж " + name + " мертв.");
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void attack(Character character);
}
