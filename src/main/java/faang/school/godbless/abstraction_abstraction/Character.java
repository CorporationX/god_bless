package faang.school.godbless.abstraction_abstraction;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intelligence){
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
