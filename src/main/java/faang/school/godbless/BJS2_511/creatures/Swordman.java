package faang.school.godbless.BJS2_511.creatures;

import static faang.school.godbless.BJS2_511.creatures.SwordmanConstants.*;

public class Swordman extends Creature{
    public Swordman(int quantity) {
        super(SWORDMAN_DEFAULT_NAME, SWORDMAN_DEFAULT_LEVEL, SWORDMAN_DEFAULT_DAMAGE, SWORDMAN_DEFAULT_DEFENSE, SWORDMAN_DEFAULT_SPEED
                , quantity);
    }
}
