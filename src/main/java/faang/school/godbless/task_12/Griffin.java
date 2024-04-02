package faang.school.godbless.task_12;

public class Griffin extends Creature {
    public Griffin(String name, int level) {
        super(name, level);
        this.protection = 1;
        this.strength = 3;
        this.speed = 7;
    }

    @Override
    public int getDamage() {
        return this.strength + this.speed + this.level;
    }
}
