package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int brain;
    private int health = 100;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int brain){
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.brain = brain;
    }

    public abstract void attack(Character character);
}
