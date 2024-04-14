package faang.school.godbless.BJS2_4128;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Griffin extends Creature {
    private static final int BASE_LEVEL = 4;
    private static final int DAMAGE = 8;
    private static final int DEFENSE = 8;
    private static final int SPEED = 6;
    private static final int HEALTH = 100;

    public Griffin() {
        super("Griffin", BASE_LEVEL, DAMAGE, DEFENSE, SPEED, HEALTH);
    }

    public int getAttackDamage() {
        return getLevel() * getDamage();
    }
}