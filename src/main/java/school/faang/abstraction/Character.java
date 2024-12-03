package school.faang.abstraction;

public abstract class Character {
    protected static final int WARRIOR_POWER = 10;
    protected static final int ARCHER_POWER = 3;
    protected static final int WARRIOR_AGILITY = 5;
    protected static final int ARCHER_AGILITY = 10;
    protected static final int WARRIOR_INTELLECT = 3;
    protected static final int ARCHER_INTELLECT = 5;

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

    public abstract void attack(Character character);
}
