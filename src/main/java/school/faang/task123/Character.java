package school.faang.task123;

public abstract class Character {

    private String name ;
    public int strength;
    public int agility;
    private int intelligence;
    public int health=100;

    public Character(String name) {
        this.name = name;
    }
    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }
    public abstract void attack(Character character);
}
