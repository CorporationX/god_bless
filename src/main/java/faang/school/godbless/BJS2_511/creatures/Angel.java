package faang.school.godbless.BJS2_511.creatures;

import static faang.school.godbless.BJS2_511.creatures.AngelConstants.*;

public class Angel extends Creature{
    public Angel(int quantity) {
        super(ANGEL_DEFAULT_NAME, ANGEL_DEFAULT_LEVEL, ANGEL_DEFAULT_DAMAGE, ANGEL_DEFAULT_DEFENSE, ANGEL_DEFAULT_SPEED
                , quantity);
    }
    @Override
    public int getDamage () {
        return this.getAttack() + getDefence();
    }
}
