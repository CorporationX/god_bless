package faang.school.godbless.BJS2_19000;

public class Swordman extends Creature {

    public Swordman(int quantity) {
        super("Swordman", 5, 6, 6, 5, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
