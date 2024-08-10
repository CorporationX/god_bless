package faang.school.godbless.javahashmap.task7;

public class Griffin extends  Creature {

    public Griffin() {
        super("Griffin", 2, 7, 5, 14, 35, 35, 0);
    }

    @Override
    public Integer getDamage() {
        return attack * level * quantity;
    }
}
