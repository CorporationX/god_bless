package school.faang.task_43829;

public abstract class Character {
    private String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence, int health) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = health;
    }

    public abstract void attack(Character character);
}

