package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public abstract class Creature {
    private final static double SPEED_PARAM = 0.5d;
    private final static double LEVEL_PARAM = 0.2d;

    private String name;
    private int level;
    private int attack;
    private int defend;
    private int speed;
    private int health;

    public int getDamage() {
        return (int) (getAttack() + SPEED_PARAM * getSpeed() + LEVEL_PARAM * getLevel() + criticalStrike());
    }

    private int criticalStrike() {
        return new Random().nextInt(0, 20);
    }

    ;
}
