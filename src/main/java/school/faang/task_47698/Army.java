package school.faang.task_47698;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Army {
    private final List<Unit> units;

    public Army() {
        this.units = new ArrayList<>();
    }

    public void addUnit(@NonNull Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        Map<UnitType, List<Unit>> unitsByUnitType = units.stream()
                .collect(Collectors.groupingBy(Unit::getUnitType));

        List<PowerCalculator> calculators = unitsByUnitType.values().stream()
                .map(PowerCalculator::new)
                .toList();

        List<Thread> threads = calculators.stream()
                .map(Thread::new)
                .toList();

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return calculators.stream()
                .mapToInt(PowerCalculator::getTotalPower)
                .sum();
    }

}
