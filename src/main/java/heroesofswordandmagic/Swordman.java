package heroesofswordandmagic;

public class Swordman extends Creature {

    public Swordman(String name, int level, int damage, int defense, int speed, int quantity) {
        super(name, 3, 30, 30, 30, 30);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
