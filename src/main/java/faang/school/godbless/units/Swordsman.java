package faang.school.godbless.units;

import java.util.Random;

public class Swordsman extends Creature {

    private static final int LEVEL = 4;
    private static final int ATTACK = 10;
    private static final int DEFENSE = 12;
    private static final int SPEED = 5;
    private static final int DAMAGE_LOW_BOUND = 6;
    private static final int DAMAGE_HIGH_BOUND = 10;
    private static final String NAME = "Swordsman";

    public Swordsman() {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED);
    }

    @Override
    public int getDamage() {
        return new Random().nextInt(DAMAGE_LOW_BOUND, DAMAGE_HIGH_BOUND) * this.getAttack() * this.getQuantity();
    }
}
