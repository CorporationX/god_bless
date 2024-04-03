package faang.school.godbless;

public abstract class Character {
    protected String name;
    private int power;
    private int agility;
    private int intellect;
    protected int health = 100;

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);

}
