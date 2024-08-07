package faang.school.godbless.Heroes.UI;

import lombok.Getter;

public class Angel extends Creature {
    private static final int  ATTACK_CONST = 4;
    private static final int  PROTECTION_CONST = 6;
    private static final int  SPEED_CONST = 19;



    public Angel(int level, int count) {
        super(level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
        name = "Angel";
    }

    public Angel(Angel angel) {
        super(angel.level, angel.damage, angel.protection,
                angel.speed, angel.count);
        name = "Angel";
    }


}
