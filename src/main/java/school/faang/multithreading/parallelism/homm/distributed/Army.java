package school.faang.multithreading.parallelism.homm.distributed;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<UnitPowerCalculator> calculators = new ArrayList<>();
        for (Unit unit : units) {
            UnitPowerCalculator unitPowerCalculator = new UnitPowerCalculator(unit);
            calculators.add(unitPowerCalculator);
            unitPowerCalculator.start();
        }
        for (UnitPowerCalculator calculator : calculators) {
            calculator.join();
        }
        return calculators.stream()
                .mapToInt(UnitPowerCalculator::getUnitPower)
                .sum();
    }
}
