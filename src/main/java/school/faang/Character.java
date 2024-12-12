package school.faang;

public abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intelligence;
    public int health;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public void attack(Character target) {}
}

