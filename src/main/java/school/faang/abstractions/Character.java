package school.faang.abstractions;

public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    protected int hp;

    public Character(String name) {
        this.name = name;
        this.hp = 100;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.hp = 100;
    }

    public abstract void attack(Character enemy);

}
