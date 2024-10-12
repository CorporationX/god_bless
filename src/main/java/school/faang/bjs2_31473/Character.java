package school.faang.bjs2_31473;

public abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intellect;
    public int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character target);
    //223
}


