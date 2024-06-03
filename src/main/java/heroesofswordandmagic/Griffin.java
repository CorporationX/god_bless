package heroesofswordandmagic;

public class Griffin extends Creature {

    public Griffin(String name, int level, int damage, int defense, int speed, int quantity) {
        super(name, 2, 20, 20, 20, 20);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
