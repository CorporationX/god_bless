package abstraction;

public abstract class Character {
    protected String name;
    protected int power;
    protected int skill;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int skill, int intellect) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
