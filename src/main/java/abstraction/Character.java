package abstraction;

public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int hp = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int dexterity, int intelligence) {
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
