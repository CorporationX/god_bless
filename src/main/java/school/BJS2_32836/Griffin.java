package school.BJS2_32836;

public class Griffin extends Creature {

    public Griffin(String name, int lvl, int attack, int protect, int speed) {
        super(name, lvl, attack, protect, speed);
    }

    public int getDamage() {
        if (this.health < 50) {
            return (attack * 2) + (int) (0.3 * speed);
        } else return attack + (int) (0.3 * speed);
    }

}