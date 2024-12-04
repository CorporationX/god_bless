package school.faang.sprint1.bjs_43839;

public abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intelligence;
    public int health = 100;

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
