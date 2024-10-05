package school.BJS2_32836;

public class Pikeman extends Creature {


    public Pikeman(String name, int lvl, int attack, int protect, int speed) {
        super(name, lvl, attack, protect, speed);
    }

    public int getDamage() {
        return attack + (int) (0.2 * speed);
    }
}