package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected double healthPoints;

    public Character (String name){
        this.name = name;
        this.healthPoints = 100;
    }

    public  Character (String name, int power, int agility, int intelligence){
        this.name= name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.healthPoints = 100;
    }

    public abstract void attack (Character enemy);
}
