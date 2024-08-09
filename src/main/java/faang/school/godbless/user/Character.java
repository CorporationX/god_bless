package faang.school.godbless.user;

public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character (String name) {
        this.name = name;
    }

    public Character (String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public void reduceHealth(int amount) {
        this.health = Math.max(this.health - amount, 0); // ensure health does not go below 0
    }

    public abstract void attack(Character character);
}
