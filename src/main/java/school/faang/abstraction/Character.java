package school.faang.abstraction;

abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, int Strength, int Agility, int Intelligence) {
        this.name = name;
        this.strength = Strength;
        this.agility = Agility;
        this.intelligence = Intelligence;
    }

    public abstract void attack(Character target);
}


