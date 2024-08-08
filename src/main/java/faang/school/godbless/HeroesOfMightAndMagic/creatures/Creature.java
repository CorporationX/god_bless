package faang.school.godbless.HeroesOfMightAndMagic.creatures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;

    public int getDamage() {
        return attack * level;
    }
}
