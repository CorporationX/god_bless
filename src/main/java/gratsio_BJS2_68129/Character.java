package gratsio_BJS2_68129;

public abstract class Character {
    private static final int STRENGTH = 5;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 5;
    public String name;
    public int strength;
    public int dexterity;
    public int intelligence;
    int health = 100;

    public Character(String name){
        this(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }
    public Character(String name, int strength, int dexterity, int intelligence){
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
    public abstract void attack(Character character);
    protected void takeDamage(int damage){
        health = Math.max(health - damage, 0);
    }
}
