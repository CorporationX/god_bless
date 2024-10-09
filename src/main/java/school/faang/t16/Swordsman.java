package school.faang.t16;

class Swordsman extends Creature {
    public Swordsman() {
        super("Swordsman", 4, 10, 12, 5);
    }

    @Override
    public int getDamage() {
        return 6 + (int)(Math.random() * 4);
    }
}