package school.faang.heroesofmightandmagic;

public class Pikeman extends Creature {
    public Pikeman(int quantity) {
        super("Pikeman", 1, 5, 5, 4, quantity);
    }

    @Override
    public int getDamage() {
        return getAttack() * getQuantity();
    }
}
