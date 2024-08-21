package faang.school.godbless;


class Angel extends Creature {
    public Angel() {
        super("Angel", 3, 15, 12, 10, 3);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }
}
