package faang.school.godbless.r_edzie.parallelism.army;

import lombok.Getter;

@Getter
public class PowerThread extends Thread {
    private Unit unit;
    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
