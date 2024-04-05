package heroesOfMightAndMagic;

public class Angel extends Creature {
    public Angel() {
        super("Angel", 5, 10, 10, 10, 40);
    }

    @Override
    public int getDamage() {
        return this.getAttack();
    }
}
