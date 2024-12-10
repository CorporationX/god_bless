package school.faang.bsj43913;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    private int intellect;
    protected int heatPoints = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character enemy);
}
