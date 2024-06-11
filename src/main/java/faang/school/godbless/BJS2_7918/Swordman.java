package faang.school.godbless.BJS2_7918;

public class Swordman extends Creature{

    public Swordman(int quantity) {
        super("Swordman", 1, 30, 20, 10, quantity);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }

    public static Creature createCreature(int quantity) {
        return new Swordman(quantity);
    }
}
