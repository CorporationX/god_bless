package school.faang.Abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int healPoint = 100;

    public void setHealPoint(int healPoint) {
        this.healPoint = Math.max(healPoint, 0);
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public abstract void attack(Character opponent);

}

