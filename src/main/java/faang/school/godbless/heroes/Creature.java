package faang.school.godbless.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Creature {
    private final String name;
    private final int level;
    private final int attack;
    private final int defense;
    private final int speed;
    private int quantity;

    public int getDamage() {
        return attack * quantity;
    }
}
