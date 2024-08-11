package faang.school.godbless.javahashmap.task7;

public class Angel extends Creature {

    public Angel() {
        super("Angel", 3, 10, 5, 12, 100, 100, 0);
    }

    @Override
    public Integer getDamage() {
        return attack * level * quantity;
    }
}
