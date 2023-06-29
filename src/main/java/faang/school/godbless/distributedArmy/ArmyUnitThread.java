package faang.school.godbless.distributedArmy;

import lombok.Getter;

@Getter

public class ArmyUnitThread extends Thread {

    private int power;

    public ArmyUnitThread(Runnable target) {
        super(target);
    }
}
