package faang.school.godbless.BJS2_18519;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private String name;
    private int power;
    private int dexterity;
    private int intelligence;
    private int hitPoints;

    public Character(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this(name);
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
