package gratsio_BJS2_68129;

public abstract class Character {
    public String name;
    public int strength;
    public int dexterity;
    public int intelligence;
    int health = 100;

    public Character(String name){
        this.name = name;
        strength = 5;
        dexterity = 5;
        intelligence = 5;
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
