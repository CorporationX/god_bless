package school.faang.task_bjs248077;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PowerCalculator implements Runnable {
    private final Unit unit;

    @Getter
    private int power;

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}
