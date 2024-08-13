package faang.school.godbless.BJS2_19037;

public class Griffin extends Creature {
    private static final String GRIFFIN_NAME = "Griffin";
    private static final int GRIFFIN_LEVEL = 8;
    private static final int GRIFFIN_HEALTH = 4;
    private static final int GRIFFIN_DAMAGE = 8;
    private static final int GRIFFIN_DEFENSE = 2;
    private static final int GRIFFIN_SPEED = 4;
    private static final int GRIFFIN_QUANTITY = 2;

    public Griffin() {
        super(GRIFFIN_NAME, GRIFFIN_LEVEL, GRIFFIN_HEALTH, GRIFFIN_DAMAGE, GRIFFIN_DEFENSE, GRIFFIN_SPEED,
                GRIFFIN_QUANTITY);
    }

    @Override
    public int getDamage() {
        return GRIFFIN_QUANTITY;
    }
}
