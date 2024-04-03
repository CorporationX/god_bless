package faang.school.godbless.task_12;

public class Pikeman extends Creature {
    private static final int STRENGTH = 3;
    private static final int PROTECTION = 5;
    private static final int SPEED = 5;

    public Pikeman(String name, int level) {
        super(name, level, STRENGTH, PROTECTION, SPEED);
    }

    @Override
    public int getDamage() {
        return getStrength() + getLevel();
    }
}
