package faang.school.godbless.BJS2_19037;

public class Pikeman extends Creature {
    private static final String PIKEMAN_NAME = "Pikeman";
    private static final int PIKEMAN_LEVEL = 15;
    private static final int PIKEMAN_HEALTH = 2;
    private static final int PIKEMAN_DAMAGE = 6;
    private static final int PIKEMAN_DEFENSE = 3;
    private static final int PIKEMAN_SPEED = 5;
    private static final int PIKEMAN_QUANTITY = 1;

    public Pikeman() {
        super(PIKEMAN_NAME, PIKEMAN_LEVEL, PIKEMAN_HEALTH, PIKEMAN_DAMAGE, PIKEMAN_DEFENSE, PIKEMAN_SPEED,
                PIKEMAN_QUANTITY);
    }
}
