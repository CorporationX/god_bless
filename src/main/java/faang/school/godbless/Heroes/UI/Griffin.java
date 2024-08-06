package faang.school.godbless.Heroes.UI;

import lombok.Getter;

public class Griffin extends Creature {
    private static final int ATTACK_CONST = 8;
    private static final int PROTECTION_CONST = 6;
    private static final int SPEED_CONST = 15;


    public Griffin(int level, int count) {
        super(level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
        name = "Griffin";
    }



}
