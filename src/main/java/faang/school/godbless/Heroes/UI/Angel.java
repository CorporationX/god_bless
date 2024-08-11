package faang.school.godbless.Heroes.UI;

public class Angel extends Creature {
    private static final int  ATTACK_CONST = 4;
    private static final int  PROTECTION_CONST = 6;
    private static final int  SPEED_CONST = 19;

    public Angel(int level, int count) {
        super("Angel lvl" + level, level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
    }

    @Override
    public int summaryPower() {
        return level * (damage / 2 + protection / 3 + speed * 2);
    }
}
