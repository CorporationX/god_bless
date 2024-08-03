package faang.school.godbless.abstraction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
abstract public class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void attack(Character character) {}
}
