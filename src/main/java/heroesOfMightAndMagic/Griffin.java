package heroesOfMightAndMagic;

public class Griffin extends Creature {

    public Griffin() {
        super("Griffin", 3, 6, 5, 6, 20);
    }

    @Override
    public int getDamage() {
        return this.getAttack();
    }
}
