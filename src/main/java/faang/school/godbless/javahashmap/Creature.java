package faang.school.godbless.javahashmap;

import lombok.Data;

@Data
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defend;
    private int speed;
    private int quantity = 0;

    public Creature(String name, int level, int attack, int defend, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defend = defend;
        this.speed = speed;
    }

    public int getDamage(){
        return attack;
    }


}
