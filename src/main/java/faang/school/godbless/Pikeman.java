package faang.school.godbless;

class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 1, 5, 2, 3, 10);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }
}
