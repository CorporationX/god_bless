package faang.school.godbless.BJS2_23421;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final List<Unit> UNITS = new ArrayList<>();

    public int calculateTotalPower() {
        List<UnitPowerCalculator> unitPowerCalculators = UNITS.stream()
                .map(UnitPowerCalculator::new)
                .peek(UnitPowerCalculator::start)
                .toList();

        return unitPowerCalculators.stream()
                .peek(calc -> {
                    try {
                        calc.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(UnitPowerCalculator::getPower)
                .mapToInt(Integer::intValue)
                .sum();

    }

    public void addUnit(Unit unit) {
        UNITS.add(unit);
    }
}