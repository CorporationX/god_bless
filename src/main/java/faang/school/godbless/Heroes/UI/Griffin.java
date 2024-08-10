package faang.school.godbless.Heroes.UI;


public class Griffin extends Creature {
    private static final int ATTACK_CONST = 8;
    private static final int PROTECTION_CONST = 6;
    private static final int SPEED_CONST = 15;

    public Griffin(int level, int count) {
        super("Griffin lvl" + level, level, ATTACK_CONST, PROTECTION_CONST, SPEED_CONST, count);
    }


    @Override
    public int summaryPower() {
        return level*(damage+protection+speed);
    }
}
