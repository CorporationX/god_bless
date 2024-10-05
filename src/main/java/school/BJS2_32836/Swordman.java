package school.BJS2_32836;

public class Swordman extends Creature {

    public Swordman(String name) {
        super(name, 1, 20, 10, 40,150);
    }

    public int getDamage() {
        if (this.health < 50) {
            return attack + (int) (2 * this.speed);
        } else return attack + (int) (0.5 * this.speed);
    }
}