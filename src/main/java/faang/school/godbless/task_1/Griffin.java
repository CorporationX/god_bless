package faang.school.godbless.task_1;

public class Griffin extends Creature{
    public Griffin() {
        super("Griffin", 3, 10, 5, 10, 15);
    }

    @Override
    public int getDamage() {
        return getAttack()*getQuantity();
    }
}
