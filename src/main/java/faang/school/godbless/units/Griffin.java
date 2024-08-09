package faang.school.godbless.units;

import java.util.Random;

public class Griffin extends Creature {

    private static final int LEVEL = 3;
    private static final int ATTACK = 8;
    private static final int DEFENSE = 8;
    private static final int SPEED = 6;
    private static final int DAMAGE_LOW_BOUND = 3;
    private static final int DAMAGE_HIGH_BOUND = 7;
    private static final String NAME = "Griffin";

    public Griffin() {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED);
    }

    @Override
    public int getDamage() {
        return new Random().nextInt(DAMAGE_LOW_BOUND, DAMAGE_HIGH_BOUND) * this.getAttack() * this.getQuantity();
    }
}
