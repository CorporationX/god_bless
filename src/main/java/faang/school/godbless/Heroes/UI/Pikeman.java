package faang.school.godbless.Heroes.UI;

import lombok.Getter;

public class Pikeman extends Creature {
    private static final int ATTACK_CONST = 9;
    private static final int PROTECTION_CONST = 15;
    private static final int SPEED_CONST = 5;


    public Pikeman(int level, int count) {
        super(level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
        name = "Pikeman";
    }


}
