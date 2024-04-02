package faang.school.godbless.task_12;

public class Angel extends Creature {
    public Angel(String name, int level) {
        super(name, level);
        this.protection = 6;
        this.strength = 1;
        this.speed = 3;
    }

    @Override
    public int getDamage() {
        return this.strength + this.level + this.speed + this.protection;
    }
}
