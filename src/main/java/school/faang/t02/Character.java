package school.faang.t02;

import lombok.Data;

@Data
public abstract class Character {

    private String name;
    private int power;
    private int dexterity;
    private int intelligence;
    private int health = 100;

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
