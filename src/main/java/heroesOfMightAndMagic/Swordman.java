package heroesOfMightAndMagic;

public class Swordman extends Creature {
    public Swordman() {
        super("Swordman", 3, 4, 2, 3, 15);
    }

    @Override
    public int getDamage() {
        return this.getAttack();
    }
}
