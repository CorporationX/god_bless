package faang.school.godbless;


class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 2, 10, 6, 7, 5);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }
}
