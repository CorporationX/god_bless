package school.faang.bjs2_85667;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {

    private final String name;
    private int power;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}