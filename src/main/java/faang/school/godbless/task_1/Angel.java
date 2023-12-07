package faang.school.godbless.task_1;

public class Angel extends Creature{
    public Angel() {
        super("Angel", 5, 5, 15, 5, 10);
    }
    @Override
    public int getDamage() {
        return getAttack()*getQuantity();
    }
}
