package school.faang.t02;

public abstract class Character {

    public String name;
    public int power;
    public int dexterity;
    public int intelligence;
    public int health = 100;

    public Character(String name, int power, int dexterity, int intelligence, int health) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = health;
    }

    public Character(String name) {
        this.name = name;
    }

    void attack(Character character) {
    }
}
