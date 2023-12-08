package faang.school.godbless.task_1;

public class Pikeman extends Creature {
    public Pikeman(int quantity) {
        super(EnumNameAndAttackIsUnits.PIKEMAN ,2,  2, 2, 80, quantity);
    }

    @Override
    public int getDamage() {
        return enumNameAndAttack.getAtack() * getLevel() * getQuantity();
    }
}
