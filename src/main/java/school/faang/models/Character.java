package school.faang.models;

public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        power = 5;
        agility = 5;
        intellect = 5;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }
}
