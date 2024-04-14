package faang.school.godbless.BJS2_4128;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Swordman extends Creature {
    private static final int BASE_LEVEL = 3;
    private static final int DAMAGE = 10;
    private static final int DEFENSE = 10;
    private static final int SPEED = 7;
    private static final int HEALTH = 100;

    public Swordman() {
        super("Swordsman", BASE_LEVEL, DAMAGE, DEFENSE, SPEED, HEALTH);
    }

    public int getAttackDamage() {
        return getLevel() * getDamage();
    }
}
