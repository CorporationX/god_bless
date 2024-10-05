package school.BJS2_32836;

public class Griffin extends Creature {

    public Griffin(String name) {
        super(name, 1, 30, 50, 10, 200);
    }

    public int getDamage() {
        if (this.health < 50) {
            return (attack * 2) + (int) (3 * speed);
        } else return attack + (int) (0.3 * speed);
    }

}