package faang.school.godbless;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int agility, int intelligence) {
        this.strength = 0;
        this.agility = 0;
        this.intelligence = 0;
    }

    public abstract void attack(Character character);

}
class Warrior extends Character {
    public Warrior() {
        super("Warrior");
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        System.out.println("Наносит урон от своей силы: " + strength);
    }

}
class Archer extends Character{
    public Archer(){
        super("Archer");
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        System.out.println("Наносит урон от своей ловкости:  " + agility);
    }

}

