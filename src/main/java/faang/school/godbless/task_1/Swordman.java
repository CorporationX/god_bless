package faang.school.godbless.task_1;

public class Swordman extends Creature{
    public Swordman() {
        super("Swordman", 4, 15, 15, 5, 10);
    }
    @Override
    public int getDamage() {
        return getAttack()*getQuantity();
    }
}
