package school.faang.task_48171;

import lombok.Getter;

public class UnitThread extends Thread {
    @Getter
    private int power;
    private Unit unit;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
