package faang.school.godbless.module.core.abstraction;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;
    
    public Character(String name) {
        this.name = name;
    }
    
    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }
    
    public abstract void attack(Character character);
}
