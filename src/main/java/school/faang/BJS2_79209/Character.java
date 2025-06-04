package school.faang.BJS2_79209;

public abstract class Character {
    private static final int initialStrength = 3;
    private static final int initialAgility = 10;
    private static final int initialIntellect = 5;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this(name, initialStrength, initialAgility, initialIntellect);
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    protected boolean isAliveAfterAttack(Character opponent, int power) {
        return (opponent.health - power) > 0;
    }
}
