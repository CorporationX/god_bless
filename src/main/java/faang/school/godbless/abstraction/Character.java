package faang.school.godbless.abstraction;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health=100;

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

class Warrior extends Character{

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health-=this.strength;
    }
}

class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -=this.agility;
    }
}

