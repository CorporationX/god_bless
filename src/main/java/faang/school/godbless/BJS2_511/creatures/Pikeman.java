package faang.school.godbless.BJS2_511.creatures;

import static faang.school.godbless.BJS2_511.creatures.PikemanConstants.*;

public class Pikeman extends Creature {

    public Pikeman(int quantity) {
        super(PIKEMAN_DEFAULT_NAME, PIKEMAN_DEFAULT_LEVEL,PIKEMAN_DEFAULT_DAMAGE,PIKEMAN_DEFAULT_DEFENSE,PIKEMAN_DEFAULT_SPEED
                , quantity);
    }
}
