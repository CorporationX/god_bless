package faang.school.godbless.task_1;

public class Swordman extends Creature {
    public Swordman(int quantity) {
        super(EnumNameAndAttackIsUnits.SWORDMAN, 1, 2,  2, 60, quantity);
    }

    @Override
    public int getDamage() {
        return enumNameAndAttack.getAtack()* getLevel() * getQuantity();
    }
}
