package heroesOfMightAndMagic;

public class Pikeman extends Creature {
    public Pikeman() {
        super("Pikeman", 3, 3, 3, 2, 10);
    }

    @Override
    public int getDamage() {
        return this.getAttack();
    }
}
