package faang.school.godbless.units;

import java.util.Random;

public class Pikeman extends Creature {

    private static final int LEVEL = 1;
    private static final int ATTACK = 4;
    private static final int DEFENSE = 5;
    private static final int SPEED = 4;
    private static final int DAMAGE_LOW_BOUND = 1;
    private static final int DAMAGE_HIGH_BOUND = 4;
    private static final String NAME = "Pikeman";

    public Pikeman() {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED);
    }

    @Override
    public int getDamage() {
        return new Random().nextInt(DAMAGE_LOW_BOUND, DAMAGE_HIGH_BOUND) * this.getAttack() * this.getQuantity();
    }
}
