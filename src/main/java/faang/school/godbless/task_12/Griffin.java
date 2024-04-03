package faang.school.godbless.task_12;

public class Griffin extends Creature {

    private static final int STRENGTH = 3;
    private static final int PROTECTION = 1;
    private static final int SPEED = 7;

    public Griffin(String name, int level) {
        super(name, level, STRENGTH, PROTECTION, SPEED);
    }

    @Override
    public int getDamage() {
        return getStrength() + getSpeed() + getLevel();
    }
}
