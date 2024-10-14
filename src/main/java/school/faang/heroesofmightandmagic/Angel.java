package school.faang.heroesofmightandmagic;

public class Angel extends Creature {
    public Angel(int quantity) {
        super("Angel", 4, 20, 20, 10, quantity);
    }

    @Override
    public int getDamage() {
        return getAttack() * getQuantity();
    }
}