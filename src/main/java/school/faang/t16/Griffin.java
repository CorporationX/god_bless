package school.faang.t16;

class Griffin extends Creature {
    public Griffin() {
        super("Griffin", 3, 8, 8, 6);
    }

    @Override
    public int getDamage() {
        return 3 + (int)(Math.random() * 5);
    }
}