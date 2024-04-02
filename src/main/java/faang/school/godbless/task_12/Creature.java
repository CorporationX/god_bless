package faang.school.godbless.task_12;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int strength;
    protected int protection;
    protected int speed;

    public Creature(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract int getDamage();
}
