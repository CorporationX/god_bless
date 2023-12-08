package faang.school.godbless.task_1;

public class Angel  extends Creature{
    public Angel(int quantity) {
        super(EnumNameAndAttackIsUnits.ANGEL, 5, 8, 8,  230, quantity);
    }

    @Override
    public int getDamage() {
        return enumNameAndAttack.getAtack() *getLevel()*getQuantity();
    }
}
