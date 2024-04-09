package faang.school.godbless.BJS2_5147;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int velocity;
    private int quantity;

    public int getDamage(Creature creature) {
        return creature.getAttack();
    }
}
