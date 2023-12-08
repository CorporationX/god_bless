package faang.school.godbless.task_1;

public class Griffin extends Creature {
    public Griffin(int quantity) {
        super(EnumNameAndAttackIsUnits.GRIFFIN, 3, 5, 4, 150, quantity);
    }

    @Override
    public int getDamage() {
        return enumNameAndAttack.getAtack() * getLevel() * getQuantity();
    }
}
