package faang.school.godbless.Heroes.UI;

import lombok.Getter;

public class Swordman extends Creature {
    private static final int ATTACK_CONST = 9;
    private static final int PROTECTION_CONST = 12;
    private static final int SPEED_CONST = 8;



    public Swordman(int level, int count) {
        super(level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
        name = "Pikeman";
    }

}
