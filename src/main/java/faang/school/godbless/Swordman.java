package faang.school.godbless;

class Swordman extends Creature {
    public Swordman() {
        super("Swordman", 1, 7, 4, 4, 8);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }
}
