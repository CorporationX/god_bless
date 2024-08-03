package faang.school.godbless.heroes.entity.creatures;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int quantity;


    public int getDamage() {
        return ((this.level + this.attack) * this.speed) * this.quantity;
    }
}