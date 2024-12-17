package school.faang.task_47613;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnitThread extends Thread {
    private final Unit unit;

    public int getUnitPower() {
        return unit.getPower();
    }

    @Override
    public void run() {
        super.run();
    }
}
