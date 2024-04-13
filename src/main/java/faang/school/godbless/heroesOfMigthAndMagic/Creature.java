package faang.school.godbless.heroesOfMigthAndMagic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;

    public int getDamage() {
        return attack;
    }
}
