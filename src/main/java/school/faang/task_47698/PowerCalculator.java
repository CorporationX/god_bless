package school.faang.task_47698;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class PowerCalculator implements Runnable {
    @Getter
    private int totalPower;

    private final List<Unit> units;

    public PowerCalculator(@NonNull List<Unit> units) {
        this.totalPower = 0;
        this.units = units;
    }

    @Override
    public void run() {
        totalPower = units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }

}
