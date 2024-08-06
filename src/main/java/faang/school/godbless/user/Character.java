package faang.school.godbless.user;

public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intellect;
    private int health;

    public Character (String name) {
        this.name = name;
        this.health = 100;
    }

    public Character (String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
        this.health = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getPower() {
        return this.power;
    }

    public void reduceHealth(int amount) {
        this.health = Math.max(this.health - amount, 0); // ensure health does not go below 0
    }

    public abstract void attack(Character character);
}
