package faang.school.godbless.task_12;

public class Pikeman extends Creature {
    public Pikeman(String name, int level) {
        super(name, level);
        this.protection = 3;
        this.strength = 5;
        this.speed = 5;
    }

    @Override
    public int getDamage() {
        return this.strength + this.level;
    }
}
