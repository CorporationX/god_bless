package school.faang;

public abstract class Character {
    protected int health = 100;
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intellect;

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    abstract void attack(Character character);
}
