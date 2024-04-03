package faang.school.godbless.task_12;

public class Angel extends Creature {
    private static final int STRENGTH = 1;
    private static final int PROTECTION = 6;
    private static final int SPEED = 3;

    public Angel(String name, int level) {
        super(name, level, STRENGTH, PROTECTION, SPEED);
    }

    @Override
    public int getDamage() {
        return getStrength() + getProtection() + getLevel() + getSpeed();
    }
}
