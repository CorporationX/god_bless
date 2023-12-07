package faang.school.godbless.BJS2_511.creatures;

import static faang.school.godbless.BJS2_511.creatures.GriffinConstants.*;

public class Griffin extends Creature{
    public Griffin(int quantity) {
        super(GRIFFIN_DEFAULT_NAME, GRIFFIN_DEFAULT_LEVEL, GRIFFIN_DEFAULT_DAMAGE, GRIFFIN_DEFAULT_DEFENSE, GRIFFIN_DEFAULT_SPEED
                , quantity);
    }
}
