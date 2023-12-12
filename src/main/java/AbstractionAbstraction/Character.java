package AbstractionAbstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    @Setter
    protected int health = 100;


    public Character(String name){
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence){
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character character);

}
