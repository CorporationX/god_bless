package faang.school.godbless.BJS2_19037;

public class Swordman extends Creature {
    private static final String SWORDMAN_NAME = "Swordman";
    private static final int SWORDMAN_LEVEL = 16;
    private static final int SWORDMAN_HEALTH = 7;
    private static final int SWORDMAN_DAMAGE = 8;
    private static final int SWORDMAN_DEFENSE = 7;
    private static final int SWORDMAN_SPEED = 6;
    private static final int SWORDMAN_QUANTITY = 1;

    public Swordman() {
        super(SWORDMAN_NAME, SWORDMAN_LEVEL, SWORDMAN_HEALTH, SWORDMAN_DAMAGE, SWORDMAN_DEFENSE, SWORDMAN_SPEED,
                SWORDMAN_QUANTITY);
    }

    @Override
    public int getDamage() {
        return SWORDMAN_QUANTITY;
    }
}
