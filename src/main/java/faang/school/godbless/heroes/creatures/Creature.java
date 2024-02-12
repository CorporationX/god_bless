package faang.school.godbless.heroes.creatures;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@Setter
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int quantity;

    public int getDamage() {
        return attack;
    }
}
