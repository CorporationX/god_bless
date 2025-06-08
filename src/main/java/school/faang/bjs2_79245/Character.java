package school.faang.bjs2_79245;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intellect;
    private int healthPoints;
    private boolean isAlive = true;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.intellect = 5;
        this.healthPoints = 100;
    }

    public Character(String name, int strength, int dexterity, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.healthPoints = 10;
    }

    public void setHealthPoints(int hp) {
        if (hp < 0) {
            this.healthPoints = 0;
            this.isAlive = false;
        } else {
            this.healthPoints = hp;
        }
    }

    public abstract void attack(Character opponent) throws Exception;
}
