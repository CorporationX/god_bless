package faang.school.godbless.BJS2_4128;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Angel extends Creature {
    private static final int BASE_LEVEL = 5;
    private static final int DAMAGE = 10;
    private static final int DEFENSE = 10;
    private static final int SPEED = 10;
    private static final int HEALTH = 100;

    public Angel() {
        super("Angel", BASE_LEVEL, DAMAGE, DEFENSE, SPEED, HEALTH);
    }

    public int getAttackDamage() {
        return getLevel() * getDamage();
    }
}
