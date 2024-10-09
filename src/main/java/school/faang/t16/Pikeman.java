package school.faang.t16;

class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 1, 4, 5, 4);
    }

    @Override
    public int getDamage() {
        return 1 + (int)(Math.random() * 3);
    }
}