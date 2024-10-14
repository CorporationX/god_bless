package school.faang.heroesofmightandmagic;

public class Swordman extends Creature {
    public Swordman(int quantity) {
        super("Swordman", 3, 10, 12, 6, quantity);
    }

    @Override
    public int getDamage() {
        return getAttack() * getQuantity();
    }
}
