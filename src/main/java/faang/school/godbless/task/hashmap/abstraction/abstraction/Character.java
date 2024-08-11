package faang.school.godbless.task.hashmap.abstraction.abstraction;

public abstract class Character {
    private final static int DEFAULT_HEALTH = 100;

    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    protected Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH;
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character character);
}
