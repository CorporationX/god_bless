package school.BJS2_32836;

public class Pikeman extends Creature {


    public Pikeman(String name) {
        super(name, 1, 10, 5,10, 100);
    }

    public int getDamage() {
        return attack + (int) (0.2 * speed);
    }
}