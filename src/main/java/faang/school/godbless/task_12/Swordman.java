package faang.school.godbless.task_12;

public class Swordman extends Creature {
    private static final int STRENGTH = 6;
    private static final int PROTECTION = 7;
    private static final int SPEED = 1;

    public Swordman(String name, int level) {
        super(name, level, STRENGTH, PROTECTION, SPEED);
    }

    @Override
    public int getDamage() {
        return getStrength() + getProtection() + getLevel();
    }
}

