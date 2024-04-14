package faang.school.godbless.BJS2_4128;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Pikeman extends Creature {
    private static final int BASE_LEVEL = 1;
    private static final int DAMAGE = 5;
    private static final int DEFENSE = 5;
    private static final int SPEED = 4;
    private static final int HEALTH = 100;

    public Pikeman() {
        super("Pikeman", BASE_LEVEL, DAMAGE, DEFENSE, SPEED, HEALTH);
    }

    public int getAttackDamage() {
        return getLevel() * getDamage();
    }
}
