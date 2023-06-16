package faang.school.godbless.abstraction_BC_406;

public abstract class Character {
    private String name;

    protected int power;

    protected int agility;

    protected int intelligence;

    protected int health = 100;


    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }
    public abstract int attack(Character enemy);
}