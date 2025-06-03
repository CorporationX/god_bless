package school.faang.BJS2_79209;

public abstract class Character {
    protected String name;
    protected final int strength;
    protected final int agility;
    protected final int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    protected boolean checkHitPoints(Character opponent, int power) {
        return (opponent.health - power) > 0;
    }
}
