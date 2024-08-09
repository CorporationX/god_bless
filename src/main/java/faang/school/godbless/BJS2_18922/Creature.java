package faang.school.godbless.BJS2_18922;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public abstract class Creature implements MinimalParameters{
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int quantity = 0;

    public Creature(String name, int level, int attack, int defence, int speed) {
        if(name.isBlank())
            throw new IllegalArgumentException("Name can not be empty");
        if(level < MIN_LEVEL)
            throw new IllegalArgumentException("Level can not be lower than 1");
        if(attack < MIN_ATTACK)
            throw new IllegalArgumentException("Attack can not be lower than 1");
        if(defence < MIN_DEFENCE)
            throw new IllegalArgumentException("Defence can not be lower than 1");
        if(speed < MIN_SPEED)
            throw new IllegalArgumentException("Speed can not be lower than 1");

        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }


    public int getDamage(){
        return this.getAttack() * this.getQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && attack == creature.attack && defence == creature.defence && speed == creature.speed && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, defence, speed);
    }
}
