package school.faang.t16;

class Angel extends Creature {
    public Angel() {
        super("Angel", 7, 20, 20, 11);
    }

    @Override
    public int getDamage() {
        return 20 + (int)(Math.random() * 30);
    }
}