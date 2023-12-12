package faang.school.godbless.BJS2_447;

import lombok.Getter;

public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    @Getter
    protected int health=100;
    public Character(String name){
        this.name=name;
    }
    public Character(String name, int power, int agility, int intelligence){
        this.name=name;
        this.power=power;
        this.agility=agility;
        this.intelligence=intelligence;
    }

    public abstract void attack(Character character);
}
