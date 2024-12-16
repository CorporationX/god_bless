package school.faang.task_47698;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class PowerCalculator implements Runnable {
    @Getter
    private int totalPower;

    private final int startIndexInclusive;
    private final int endIndexExclusive;

    private final List<Unit> units;

    public PowerCalculator(@NonNull List<Unit> units,
                           int startIndexInclusive, int endIndexExclusive) {
        if (startIndexInclusive < 0
                || endIndexExclusive < startIndexInclusive
                || endIndexExclusive > units.size()) {
            throw new IllegalArgumentException("Invalid values");
        }
        this.totalPower = 0;

        this.startIndexInclusive = startIndexInclusive;
        this.endIndexExclusive = endIndexExclusive;

        this.units = units;
    }

    @Override
    public void run() {
        for (int i = startIndexInclusive; i < endIndexExclusive; i++) {
            totalPower += units.get(i).getPower();
        }
    }

}
