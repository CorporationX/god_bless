package school.faang.heroesofmightandmagic;

public class Griffin extends Creature {
    public Griffin(int quantity) {
        super("Griffin", 2, 8, 8, 7, quantity);
    }

    @Override
    public int getDamage() {
        return getAttack() * getQuantity();
    }
}