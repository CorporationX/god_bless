package faang.school.godbless.BJS2_18932;

public class Angel extends Creature {
    private static final String ANGEL_NAME = "Angel";
    private static final int ANGEL_LVL = 10;
    private static final int ANGEL_DAMAGE = 60;
    private static final int ANGEL_DEFENCE = 25;
    private static final int ANGEL_SPEED = 40;

    public Angel() {
        super(ANGEL_NAME, ANGEL_LVL,ANGEL_DAMAGE, ANGEL_DEFENCE, ANGEL_SPEED);
    }
}
