package school.faang.bjs48074;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Army {
    private final List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPowerParallel() {
        return units.parallelStream()
                .map(Unit::getPower)
                .reduce(0, Integer::sum);
    }

    public int calculateTotalPowerThreads() {
        return units.stream()
                .map(PowerCalculator::new)
                .peek(Thread::start)
                .peek(entry -> {
                    try {
                        entry.join();
                    } catch (InterruptedException e) {
                        log.error("Ошибка при join потока в main: {}", e.getMessage());
                    }
                })
                .map(PowerCalculator::getPower)
                .reduce(0, Integer::sum);
    }
}
