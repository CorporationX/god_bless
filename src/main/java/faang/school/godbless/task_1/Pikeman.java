package faang.school.godbless.task_1;

public class Pikeman extends Creature{
    public Pikeman() {
        super("Pikeman", 1, 5, 5, 8, 10);
    }

    @Override
    public int getDamage() {
        return getAttack()*getQuantity();
    }
}
