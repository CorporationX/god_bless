package faang.school.godbless.task_12;

public class Swordman extends Creature {
    public Swordman(String name, int level) {
        super(name, level);
        this.protection = 7;
        this.strength = 6;
        this.speed = 1;
    }

    @Override
    public int getDamage() {
        return this.strength + this.protection + this.level;
    }
}

