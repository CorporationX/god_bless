package faang.school.godbless.javahashmap.task7;

public class Pikeman extends Creature {

    public Pikeman() {
        super("Pikeman", 1, 5, 4, 9, 12, 12, 0);
    }

    @Override
    public Integer getDamage() {
        return attack * level * quantity;
    }
}
