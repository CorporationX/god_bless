package faang.school.godbless.BJS2_19000;

public class Pikeman extends Creature {


    public Pikeman(int quantity) {
        super("Pikeman", 1, 2, 2, 3, quantity);
    }

    @Override
    public Integer getDamage() {
        return this.getAttack() * this.getQuantity();

    }
}
