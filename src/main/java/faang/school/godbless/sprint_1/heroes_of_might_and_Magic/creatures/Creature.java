package faang.school.godbless.sprint_1.heroes_of_might_and_Magic.creatures;

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
