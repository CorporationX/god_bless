package faang.school.godbless.BJS2_7918;

public class Pikeman extends Creature {

    public Pikeman(int quantity) {
        super("Pikeman", 1, 13, 50, 15, quantity);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }

    public static Creature createCreature(int quantity) {
        return new Pikeman(quantity);
    }
}
