package heroes.item;

import lombok.Data;

@Data
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int security;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int attack, int security, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.security = security;
        this.speed = speed;
    }

    public void getDamage(){
        // method without realization :(
    }
}