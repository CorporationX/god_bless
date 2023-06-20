package faang.school.godbless.Abstraction;

public abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intelligent;
    public int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligent) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligent = intelligent;
    }

    public abstract void attack(Character character);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
