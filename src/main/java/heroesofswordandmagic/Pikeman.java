package heroesofswordandmagic;

public class Pikeman extends Creature {

    public Pikeman(String name, int level, int damage, int defense, int speed, int quantity) {
        super(name, 1, 10, 10, 10, 10);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
