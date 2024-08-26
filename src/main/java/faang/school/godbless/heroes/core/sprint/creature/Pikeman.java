package faang.school.godbless.heroes.core.sprint.creature;

public class Pikeman extends Creature {

    public Pikeman() {
        this.name = "pikeman";
        this.level = 1;
        this.attack = 1;
        this.protection = 3;
        this.speed = 3;
    }

    @Override
    public int getDamage() {
        return quantity * attack * level;
    }
}
