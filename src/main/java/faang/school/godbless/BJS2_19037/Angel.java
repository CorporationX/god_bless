package faang.school.godbless.BJS2_19037;

public class Angel extends Creature {
    private static final String ANGEL_NAME = "Angel";
    private static final int ANGEL_LEVEL = 10;
    private static final int ANGEL_HEALTH = 4;
    private static final int ANGEL_DAMAGE = 6;
    private static final int ANGEL_DEFENSE = 3;
    private static final int ANGEL_SPEED = 2;
    private static final int ANGEL_QUANTITY = 1;

    public Angel() {
        super(ANGEL_NAME, ANGEL_LEVEL, ANGEL_HEALTH, ANGEL_DAMAGE, ANGEL_DEFENSE, ANGEL_SPEED, ANGEL_QUANTITY);
    }

    @Override
    public int getDamage() {
        return ANGEL_QUANTITY;
    }
}
