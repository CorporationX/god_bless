package faang.school.godbless.BJS2_23387;

import lombok.Getter;

public class PowerThread extends Thread {
    private final Unit unit;
    @Getter
    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }

}
