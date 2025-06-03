package school.faang.Abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int healPoint = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }
    public Character(String name,int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = Math.max(healPoint, 0);
    }

    public abstract void attack(Character opponent);

}

