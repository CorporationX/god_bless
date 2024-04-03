package faang.school.godbless.heroes_of_might_and_Magic.unit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    // Не очень понял зачем нам это поле
    private int count;

    public abstract int getDamage();
}
