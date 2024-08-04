package faang.school.godbless.BJS2_18922;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int quantity = 0;

    public Creature(String name, int level, int attack, int defence, int speed) {
        if(name.isBlank() || level < 1 || attack < 1 || defence < 1 || speed < 1)
            throw new IllegalArgumentException("Incorrect data for creature creation");

        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }


    public int getDamage(){
        return this.getAttack() * this.getQuantity();
    }
}
