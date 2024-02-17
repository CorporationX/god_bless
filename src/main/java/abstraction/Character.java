package abstraction;

public abstract class Character {
    protected String name;
    protected int power, dexterity, intelligence;
    protected int health = 100;

    public Character(String name){
        this.name = name;
    }
    public Character(String name, int power, int dexterity, int intelligence){
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
    public abstract void attack(Character character);

}
