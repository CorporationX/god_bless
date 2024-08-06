package faang.school.godbless.abstraction;

public abstract class Character {
    private String name;
    protected int power;
    protected int sleight;
    private int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int sleight, int intelligence) {
        this.name = name;
        this.power = power;
        this.sleight = sleight;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
