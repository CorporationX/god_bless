package faang.school.godbless.BJS2_7918;

public class Angel extends Creature {

    public Angel(int quantity) {
        super("Angel", 1, 31, 70, 12, quantity);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }


    public static Creature createCreature(int quantity) {
        return new Angel(quantity);
    }
}
