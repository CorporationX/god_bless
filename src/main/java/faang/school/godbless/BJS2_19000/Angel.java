package faang.school.godbless.BJS2_19000;

public class Angel extends Creature {

    public Angel(int quantity) {
        super("Angel", 7, 10, 10, 8, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
