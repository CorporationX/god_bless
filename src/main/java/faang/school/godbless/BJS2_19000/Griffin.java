package faang.school.godbless.BJS2_19000;

public class Griffin extends Creature {

    public Griffin(int quantity) {
        super("Griffin",3, 4, 4, 8, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
