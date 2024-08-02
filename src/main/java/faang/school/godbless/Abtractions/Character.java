package faang.school.godbless.Abtractions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int hp = 100;

    public Character(String name)
    {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence)
    {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character enemy);

}
