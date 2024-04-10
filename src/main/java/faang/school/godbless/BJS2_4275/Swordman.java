package faang.school.godbless.BJS2_4275;

import faang.school.godbless.BJS2_4275.Creature;

public class Swordman extends Creature {

    private static final String NAME = "Swordman";
    private static final int LEVEL = 7;
    private static final int DAMAGE = 10;
    private static final int DEFENSE = 12;
    private static final int HEALTH = 30;
    private static final int SPEED = 5;

    public Swordman() {
        super(NAME, LEVEL, DAMAGE, DEFENSE, HEALTH, SPEED);
    }
}
