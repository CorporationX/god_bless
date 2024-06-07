package heroesofswordandmagic;

public class Angel extends Creature {

    public Angel(String name, int level, int damage, int defense, int speed, int quantity) {
        super(name, 4, 40, 40, 40, 40);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
