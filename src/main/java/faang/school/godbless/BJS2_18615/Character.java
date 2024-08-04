package faang.school.godbless.BJS2_18615;

public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;

    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character character);
}
