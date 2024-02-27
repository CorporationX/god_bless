package Basic.Task3;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int power;
    private int skill;
    private int brain;
    private int health = 100;

    public Character(String name){
        this.name = name;
    }
    public Character(String name, int power, int skill, int brain){
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.brain = brain;
    }
    public abstract void attack(Character character);
}
