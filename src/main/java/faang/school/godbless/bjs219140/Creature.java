package faang.school.godbless.bjs219140;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;

    public int getDamage() {
        return this.attack;
    }
}
